package com.tenghong.ndip.controller.diet;

import com.alibaba.fastjson.JSONArray;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.diet.DietDish;
import com.tenghong.ndip.model.diet.DietElement;
import com.tenghong.ndip.model.diet.DietRelation;
import com.tenghong.ndip.model.dto.ImageDto;
import com.tenghong.ndip.service.diet.DishService;
import com.tenghong.ndip.service.diet.MaterialService;
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
 * @Date: created in 15:49 2018/6/13
 */
@Controller
@RequestMapping("/admin")
public class DishController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(DishController.class);

    @Autowired
    private DishService dishService;

    @Value("#{applicationProperties['image.path.url']}")
    private String fileViewPath;


    //获取菜谱库
    @RequestMapping(value = "/dish/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                       @RequestParam(value = "cafeteriaId", required = false, defaultValue = "") Integer cafeteriaId,
                       @RequestParam(value = "typeId", required = false, defaultValue = "") Integer typeId,
                       @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> queryMap = getQueryMap();
        try{
            queryMap.put("name",name);
            queryMap.put("typeId",typeId);
            queryMap.put("cafeteriaId",cafeteriaId);
            PageInfo pageInfo = new PageInfo(page, rows, "sort", "desc");
            pageInfo.setCondition(queryMap);
            dishService.getDataGrip(pageInfo,fileViewPath);
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

    //保存菜谱
    @RequestMapping(value = "/dish/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("name") String name,
                       @RequestParam("price") Double price,
                       @RequestParam("cotlPrice") Double cotlPrice,
                       @RequestParam("typeId")Integer typeId,
                       @RequestParam("tbWareName") String  tbWareName,
                       @RequestParam("tbWareNum") Integer  tbWareNum,
                       @RequestParam("icon") String icon,
                       @RequestParam("token") String token,
                       @RequestParam("sort") Integer sort){
        Result result = getResultInstance();
        Map<String,Object> map = new HashMap<>();
        try{
            List<ImageDto> list = JSONArray.parseArray(icon, ImageDto.class);
            DietDish dish = new DietDish();
            dish.setName(name);
            dish.setPrice(price);
            dish.setCotlPrice(cotlPrice);
            dish.setTypeId(typeId);
            dish.setTbWareName(tbWareName);
            dish.setTbWareNum(tbWareNum);
            dish.setIcon(NdipUtils.ndipInstance().getImageName(list));
            dish.setSort(sort);
            dish.setCreateBy(getCurrentUser(token).getUserId());
            dish.setCreateTime(new Date());
            dish.setStatus(1);
            dishService.save(dish);
            map.put("goalId",dish.getId());
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


    //查询菜谱详情
    @RequestMapping(value = "/dish/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result detail(@RequestParam("id") Integer id){
        Result result = getResultInstance();
        Map<String,Object> map = new HashMap<>();
        try{
            map.put("dish",dishService.getInfo(id,fileViewPath));
            map.put("relation",queryRelation(id,2));
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

    //查询菜谱修改
    @RequestMapping(value = "/dish/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("price") Double price,
                       @RequestParam("cotlPrice") Double cotlPrice,
                       @RequestParam("typeId")Integer typeId,
                       @RequestParam("tbWareName") String  tbWareName,
                       @RequestParam("tbWareNum") Integer  tbWareNum,
                       @RequestParam("icon") String icon,
                       @RequestParam("token") String token,
                       @RequestParam("sort") Integer sort){
        Result result = getResultInstance();
        try{
            List<ImageDto> list = JSONArray.parseArray(icon, ImageDto.class);
            DietDish dish = dishService.selectOne(id);
            dish.setName(name);
            dish.setPrice(price);
            dish.setCotlPrice(cotlPrice);
            dish.setTypeId(typeId);
            dish.setTbWareName(tbWareName);
            dish.setTbWareNum(tbWareNum);
            dish.setIcon(NdipUtils.ndipInstance().getImageName(list));
            dish.setSort(sort);
            dish.setUpdateBy(getCurrentUser(token).getUserId());
            dish.setUpdateTime(new Date());
            dishService.update(dish);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }



    @RequestMapping(value = "/dish/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam("id") Integer id,
                       @RequestParam("token") String token){
        Result result = getResultInstance();
        try{
            DietDish dish = dishService.selectOne(id);
            dish.setStatus(0);
            dish.setUpdateBy(getCurrentUser(token).getUserId());
            dish.setUpdateTime(new Date());
            dishService.update(dish);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }
}
