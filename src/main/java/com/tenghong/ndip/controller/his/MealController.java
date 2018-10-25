package com.tenghong.ndip.controller.his;

import com.alibaba.fastjson.JSONArray;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.dto.ImageDto;
import com.tenghong.ndip.model.his.HisMealType;
import com.tenghong.ndip.service.his.MealService;
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
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:30 2018/6/10
 */
@Controller
@RequestMapping("/admin")
public class MealController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(MealController.class);

    @Autowired
    private MealService mealService;


    @Value("#{applicationProperties['image.path.url']}")
    private String fileViewPath;

    @RequestMapping(value = "/mealType/list",method = RequestMethod.POST)
    @ResponseBody
    public Result listType(@RequestParam("cafeteriaId") Integer cafeteriaId,
                       @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> queryMap = getQueryMap();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "sort", "desc");
            queryMap.put("cafeteriaId",cafeteriaId);
            pageInfo.setCondition(queryMap);
            mealService.getTypeDataGrip(pageInfo,fileViewPath);
            result.setData(pageInfo);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/mealType/save",method = RequestMethod.POST)
    @ResponseBody
    public Result saveType(@RequestParam("token") String token,
                       @RequestParam("mealTypeName") String mealTypeName,
                       @RequestParam("sort") Integer sort,
                       @RequestParam("mealTypePic") String mealTypePic,
                       @RequestParam("memo") String memo,
                       @RequestParam("cafeteriaId") Integer cafeteriaId){
        Result result = getResultInstance();
        try{
            List<ImageDto> list = JSONArray.parseArray(mealTypePic, ImageDto.class);
            HisMealType type = new HisMealType();
            type.setMealTypeName(mealTypeName);
            type.setSort(sort);
            type.setMealTypePic(NdipUtils.ndipInstance().getImageName(list));
            type.setMemo(memo);
            type.setCafeteriaId(cafeteriaId);
            type.setCreateTime(new Date());
            type.setCreateBy(getCurrentUser(token).getUserId());
            type.setStatus(1);
            mealService.saveType(type);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/mealType/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result detailType(@RequestParam("id") Integer id,
                             @RequestParam("token") String token,
                             @RequestParam("mealTypeName") String mealTypeName,
                             @RequestParam("sort") Integer sort,
                             @RequestParam("mealTypePic") String mealTypePic,
                             @RequestParam("memo") String memo,
                             @RequestParam("cafeteriaId") Integer cafeteriaId){
        Result result = getResultInstance();
        try{
            List<ImageDto> list = JSONArray.parseArray(mealTypePic, ImageDto.class);
            HisMealType type = mealService.getTypeInfo(id);
            type.setMealTypeName(mealTypeName);
            type.setSort(sort);
            type.setMealTypePic(NdipUtils.ndipInstance().getImageName(list));
            type.setMemo(memo);
            type.setCafeteriaId(cafeteriaId);
            type.setUpdateBy(getCurrentUser(token).getUserId());
            type.setUpdateTime(new Date());
            mealService.editType(type);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/mealType/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result editType(@RequestParam("id") Integer id){
        Result result = getResultInstance();
        try{
            result.setData(mealService.select(id,fileViewPath));
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/mealType/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result deleteType(@RequestParam("id") Integer id,
                             @RequestParam("token") String token){
        Result result = getResultInstance();
        try{
            HisMealType type = mealService.getTypeInfo(id);
            type.setStatus(0);
            type.setUpdateTime(new Date());
            type.setUpdateBy(getCurrentUser(token).getUserId());
            mealService.editType(type);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }
}
