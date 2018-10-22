package com.tenghong.ndip.controller.diet;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.diet.DietMenu;
import com.tenghong.ndip.service.diet.DietMenuService;
import com.tenghong.ndip.utils.DateUtil;
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
 * @Date: created in 14:42 2018/6/19
 */
@Controller
@RequestMapping("/admin")
public class DietMenuController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DietMenuController.class);

    @Autowired
    private DietMenuService menuService;

    @Value("#{applicationProperties['image.path.url']}")
    private String fileViewPath;

    //获取菜单列表
    @RequestMapping(value = "/dietMenu/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam("menuDate") String menuDate,
                       @RequestParam(value = "ovenId", required = false, defaultValue = "") Integer ovenId,
                       @RequestParam("mealTimesId") Integer mealTimesId,
                       @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "menu.create_time", "desc");
            menuService.getDataGrip(pageInfo,page,rows,menuDate,ovenId,mealTimesId);
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


    //保存菜单
    @RequestMapping(value = "/dietMenu/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("ovenId") Integer ovenId,
                       @RequestParam("mealId") Integer mealId,
                       @RequestParam("cafeteriaId") Integer cafeteriaId,
                       @RequestParam("menuTime")Date menuTime,
                       @RequestParam("token")String token,
                       @RequestParam("menuId") Integer menuId){
        Result result = getResultInstance();
        Map<String,Object> map = new HashMap<>();
        try{
            if (null == ovenId){
                result.setState(0);
                result.setMsg("灶类id不能为空");
                return result;
            }
            if (null == mealId){
                result.setState(0);
                result.setMsg("餐次id不能为空");
                return result;
            }
            if (menuId.equals(0)){
                DietMenu menu = new DietMenu();
                menu.setCafeteriaId(cafeteriaId);
                menu.setMenuTime(menuTime);
                menu.setOvenId(ovenId);
                menu.setMealId(mealId);
                menu.setCreateBy(getCurrentUser(token).getUserId());
                menu.setCreateTime(new Date());
                menu.setStatus(1);
                menuService.save(menu);
                map.put("goalId",menu.getId());
            }else {
                DietMenu menu = menuService.getInfo(menuId);
                menu.setUpdateBy(getCurrentUser(token).getUserId());
                menu.setUpdateTime(new Date());
                menu.setMenuTime(menuTime);
                menuService.update(menu);
                map.put("goalId",menu.getId());
            }
            result.setData(map);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //菜单复制
    @RequestMapping(value = "/dietMenu/copy",method = RequestMethod.POST)
    @ResponseBody
    public Result copy(@RequestParam("sourcesDateStart") Date sourcesDateStart,
                       @RequestParam("sourcesDateEnd") Date sourcesDateEnd,
                       @RequestParam("targetDateStart") Date targetDateStart,
                       @RequestParam(value = "mealId", required = false, defaultValue = "") String mealId,
                       @RequestParam(value = "ovenId", required = false, defaultValue = "") String ovenId,
                       @RequestParam("token")String token){
        Result result = getResultInstance();
        try{
            LOGGER.info("mealId {}",mealId);
            LOGGER.info("ovenId {}",ovenId);
            if (!DateUtil.dateCompare(sourcesDateEnd,sourcesDateStart)){
                result.setState(0);
                result.setMsg("被复制菜单开始日期不能小于结束日期");
                return result;
            }
            List<Integer> mealIdList = Lists.newArrayList();
            List<Integer> ovenIdList = Lists.newArrayList();
            if (!mealId.equals("")) {
                mealIdList = JSONArray.parseArray(mealId, int.class);
            }
            if (!ovenId.equals("")){
                ovenIdList = JSONArray.parseArray(ovenId, int.class);
            }
            LOGGER.info("mealId {}",mealId);
            LOGGER.info("ovenId {}",ovenId);
            LOGGER.info("mealIdList {}",mealIdList.size());
            LOGGER.info("ovenIdList {}",ovenIdList.size());
            menuService.copy(DateUtil.getDiffer(sourcesDateEnd,sourcesDateStart),sourcesDateStart,targetDateStart,mealIdList,ovenIdList,getCurrentUser(token).getUserId());
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setMsg("Server Exception");
            result.setState(0);
        }
        return result;
    }
}
