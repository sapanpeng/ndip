package com.tenghong.ndip.controller.diet;

import com.alibaba.fastjson.JSONArray;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.diet.DietMealTimes;
import com.tenghong.ndip.model.dto.ImageDto;
import com.tenghong.ndip.model.sys.SysOvenSchedual;
import com.tenghong.ndip.service.diet.MealTimesService;
import com.tenghong.ndip.service.sys.SchedualService;
import com.tenghong.ndip.utils.DateUtil;
import com.tenghong.ndip.utils.EhcacheUtil;
import com.tenghong.ndip.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 23:07 2018/6/10
 */
@Controller
@RequestMapping("/admin")
public class MealTimesController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealTimesController.class);

    @Autowired
    private MealTimesService mealTimesService;

    @Autowired
    private SchedualService schedualService;

    @Value("#{applicationProperties['image.path.url']}")
    private String fileViewPath;

    @Value("#{applicationProperties['meal.ded.time']}")
    private Integer dedTime;

    @RequestMapping(value = "/mealTimes/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam("cafeteriaId")Integer cafeteriaId,
                           @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> queryMap = new HashMap<>();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "sort", "desc");
            queryMap.put("cafeteriaId",cafeteriaId);
            pageInfo.setCondition(queryMap);
            mealTimesService.getDataGrip(pageInfo,fileViewPath);
            result.setData(pageInfo);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }


    @RequestMapping(value = "/mealTimes/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("cafeteriaId")Integer cafeteriaId,
                       @RequestParam("token") String token,
                       @RequestParam("mealTimeName") String mealTimeName,
                       @RequestParam("sort") Integer sort,
                       @RequestParam("mealTimeIcon") String mealTimeIcon,
                       @RequestParam("hour") Integer hour,
                       @RequestParam("minute") Integer minute){
        Result result = getResultInstance();
        try{
            List<ImageDto> list = JSONArray.parseArray(mealTimeIcon, ImageDto.class);
            DietMealTimes times = new DietMealTimes();
            times.setMealTimeName(mealTimeName);
            times.setMealTimeIcon(NdipUtils.ndipInstance().getImageName(list));
            times.setSort(sort);
            times.setCafeteriaId(cafeteriaId);
            times.setCreateTime(new Date());
            times.setCreateBy(getCurrentUser(token).getUserId());
            times.setStatus(1);
            mealTimesService.save(times);

            //保存截止日期
            SysOvenSchedual schedual = new SysOvenSchedual();
            schedual.setKey(times.getId().toString());
            schedual.setExpHour(hour);
            schedual.setExpMin(minute);
            schedual.setExpTime(DateUtil.getStringValue(hour,minute));
            schedual.setDedTime(DateUtil.getStringValue(hour+dedTime,minute));
            schedualService.save(schedual);
            refreshMealTimesCache();
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }


    @RequestMapping(value = "/mealTimes/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result detail(@RequestParam("id")Integer id){
        Result result = getResultInstance();
        try{
            DietMealTimes times = mealTimesService.getInfo(id,fileViewPath);
            SysOvenSchedual schedual = schedualService.selectForItem(id.toString());
            times.setHour(schedual.getExpHour());
            times.setMinute(schedual.getExpMin());
            times.setExpTime(schedual.getExpTime());
            result.setData(times);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/mealTimes/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam("id")Integer id,
                       @RequestParam("cafeteriaId")Integer cafeteriaId,
                       @RequestParam("token") String token,
                       @RequestParam("mealTimeName") String mealTimeName,
                       @RequestParam("sort") Integer sort,
                       @RequestParam("mealTimeIcon") String mealTimeIcon,
                       @RequestParam("hour") Integer hour,
                       @RequestParam("minute") Integer minute){
        Result result = getResultInstance();
        try{
            List<ImageDto> list = JSONArray.parseArray(mealTimeIcon, ImageDto.class);
            DietMealTimes times = mealTimesService.select(id);
            times.setMealTimeName(mealTimeName);
            times.setMealTimeIcon(NdipUtils.ndipInstance().getImageName(list));
            times.setSort(sort);
            times.setCafeteriaId(cafeteriaId);
            times.setUpdateTime(new Date());
            times.setUpdateBy(getCurrentUser(token).getUserId());
            mealTimesService.update(times);

            //刷新定时任务表
            SysOvenSchedual schedual = schedualService.selectForItem(id.toString());
            schedual.setExpHour(hour);
            schedual.setExpMin(minute);
            schedual.setExpTime(DateUtil.getStringValue(hour,minute));
            schedual.setDedTime(DateUtil.getStringValue(hour+dedTime,minute));
            schedualService.update(schedual);
            refreshMealTimesCache();

            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }


    @RequestMapping(value = "/mealTimes/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam("id")Integer id,
                       @RequestParam("token") String token){
        Result result = getResultInstance();
        try{
            DietMealTimes times = mealTimesService.select(id);
            times.setStatus(0);
            times.setUpdateTime(new Date());
            times.setUpdateBy(getCurrentUser(token).getUserId());
            mealTimesService.update(times);

            //刷新定时任务表
            SysOvenSchedual schedual = schedualService.selectForItem(id.toString());
            schedualService.delete(schedual);
            refreshMealTimesCache();

            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //刷新mealTimes缓存
    public void refreshMealTimesCache(){
        List<Integer> keyList = schedualService.select();
        EhcacheUtil.getInstance().put("mealTimesCache","ovenKeyList", keyList);
        if (keyList.size() > 0){
            for (Integer key : keyList){
                schedualService.select(key.toString());
            }
        }
    }
}
