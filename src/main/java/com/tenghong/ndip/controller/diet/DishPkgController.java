package com.tenghong.ndip.controller.diet;

import com.alibaba.fastjson.JSONArray;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.diet.DietDish;
import com.tenghong.ndip.model.diet.DietDishPkg;
import com.tenghong.ndip.model.dto.ImageDto;
import com.tenghong.ndip.service.diet.DishPkgService;
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
 * @Date: created in 10:22 2018/6/19
 */
@Controller
@RequestMapping("/admin")
public class DishPkgController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DishPkgController.class);

    @Autowired
    private DishPkgService dishPkgService;

    @Value("#{applicationProperties['image.path.url']}")
    private String fileViewPath;


    //获取套餐库
    @RequestMapping(value = "/dishPkg/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                       @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> queryMap = getQueryMap();
        try{
            queryMap.put("name",name);
            PageInfo pageInfo = new PageInfo(page, rows, "sort", "desc");
            pageInfo.setCondition(queryMap);
            dishPkgService.getDataGrip(pageInfo,fileViewPath);
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

    //保存套餐
    @RequestMapping(value = "/dishPkg/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("name") String name,
                       @RequestParam("price") Double price,
                       @RequestParam("consPrice") Double consPrice,
                       @RequestParam("tbWareName") String  tbWareName,
                       @RequestParam("tbWareNum") Integer  tbWareNum,
                       @RequestParam("icon") String icon,
                       @RequestParam("token") String token,
                       @RequestParam("sort") Integer sort,
                       @RequestParam(value = "memo", required = false, defaultValue = "")String memo){
        Result result = getResultInstance();
        Map<String,Object> map = new HashMap<>();
        try{
            List<ImageDto> list = JSONArray.parseArray(icon, ImageDto.class);
            DietDishPkg dish = new DietDishPkg();
            dish.setName(name);
            dish.setPrice(price);
            dish.setConsPrice(consPrice);
            dish.setTbWareName(tbWareName);
            dish.setTbWareNum(tbWareNum);
            dish.setIcon(NdipUtils.ndipInstance().getImageName(list));
            dish.setSort(sort);
            dish.setMemo(memo);
            dish.setCreateBy(getCurrentUser(token).getUserId());
            dish.setCreateTime(new Date());
            dish.setStatus(1);
            dishPkgService.save(dish);
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


    //查询套餐详情
    @RequestMapping(value = "/dishPkg/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result detail(@RequestParam("id") Integer id){
        Result result = getResultInstance();
        Map<String,Object> map = new HashMap<>();
        try{
            map.put("dish",dishPkgService.getInfo(id,fileViewPath));
            map.put("relation",queryRelation(id,3));
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

    //套餐修改
    @RequestMapping(value = "/dishPkg/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("price") Double price,
                       @RequestParam("consPrice") Double consPrice,
                       @RequestParam("tbWareName") String  tbWareName,
                       @RequestParam("tbWareNum") Integer  tbWareNum,
                       @RequestParam("icon") String icon,
                       @RequestParam("token") String token,
                       @RequestParam("sort") Integer sort,
                       @RequestParam(value = "memo", required = false, defaultValue = "")String memo){
        Result result = getResultInstance();
        try{
            if (null == id){
                result.setState(0);
                result.setMsg("套餐id不能为null");
                return result;
            }
            List<ImageDto> list = JSONArray.parseArray(icon, ImageDto.class);
            DietDishPkg dish = dishPkgService.selectOne(id);
            dish.setName(name);
            dish.setPrice(price);
            dish.setConsPrice(consPrice);
            dish.setTbWareName(tbWareName);
            dish.setTbWareNum(tbWareNum);
            dish.setIcon(NdipUtils.ndipInstance().getImageName(list));
            dish.setSort(sort);
            dish.setMemo(memo);
            dish.setUpdateBy(getCurrentUser(token).getUserId());
            dish.setUpdateTime(new Date());
            dishPkgService.update(dish);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //套餐删除
    @RequestMapping(value = "/dishPkg/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam("id") Integer id,
                       @RequestParam("token") String token){
        Result result = getResultInstance();
        try{
            DietDishPkg dish = dishPkgService.selectOne(id);
            dish.setStatus(0);
            dish.setUpdateBy(getCurrentUser(token).getUserId());
            dish.setUpdateTime(new Date());
            dishPkgService.update(dish);
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
