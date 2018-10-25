package com.tenghong.ndip.controller.diet;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.diet.DietMatl;
import com.tenghong.ndip.service.diet.MaterialService;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 0:41 2018/6/12
 */
@Controller
@RequestMapping("/admin")
public class MaterialController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialController.class);

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "/intlType/list",method = RequestMethod.POST)
    @ResponseBody
    public Result intlTypeList(){
        Result result = getResultInstance();
        try{
            result.setData(materialService.getIntlTypeDataGrip());
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/intl/list",method = RequestMethod.POST)
    @ResponseBody
    public Result intlList(@RequestParam(value="typeId", required = false)Integer typeId,
                           @RequestParam(value="level", required = false)Integer level,
                           @RequestParam(value="name", required = false)String name,
                           @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> queryMap = new HashMap<>();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "food.id", "asc");
            materialService.getIntlDataGrip(typeId,pageInfo,queryMap,level,name);
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

    @RequestMapping(value = "/intl/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result intlDetail(@RequestParam("intlId")String intlId){
        Result result = getResultInstance();
        try{
            result.setData(materialService.getInfo(intlId));
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }


    //查询原材料类别列表
    @RequestMapping(value = "/matlType/list",method = RequestMethod.POST)
    @ResponseBody
    public Result typeList(@RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        try{
            result.setData(materialService.getMatlTypeDataGrip());
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //查询原材料列表
    @RequestMapping(value = "/matl/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "typeId", required = false, defaultValue = "") Integer typeId,
                       @RequestParam(value = "name", required = false, defaultValue = "") String name,
                       @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> queryMap = getQueryMap();
        try{
            queryMap.put("typeId",typeId);
            queryMap.put("name",name);
            PageInfo pageInfo = new PageInfo(page, rows, "create_time", "desc");
            pageInfo.setCondition(queryMap);
            materialService.getDataGrip(pageInfo);
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

    //保存原材料
    @RequestMapping(value = "/matl/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("name") String name,
                       @RequestParam(value = "memo", required = false, defaultValue = "") String memo,
                       @RequestParam("unit") String unit,
                       @RequestParam("price") Double price,
                       @RequestParam("typeId")Integer typeId,
                       @RequestParam("standardId") String  standardId,
                       @RequestParam("standardName") String  standardName,
                       @RequestParam("standardWeight") Double standardWeight,
                       @RequestParam("token") String token){
        Result result = getResultInstance();
        Map<String,Object> map = new HashMap<>();
        try{
            DietMatl matl = new DietMatl();
            matl.setName(name);
            matl.setMemo(memo);
            matl.setUnit(unit);
            matl.setPrice(price);
            matl.setTypeId(typeId);
            matl.setStandardId(standardId);
            matl.setStandardName(standardName);
            matl.setStandardWeight(standardWeight);
            matl.setStatus(1);
            matl.setCreateTime(new Date());
            matl.setCreateBy(getCurrentUser(token).getUserId());
            materialService.save(matl);
            map.put("goalId",matl.getId());
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


    //原材料详情
    @RequestMapping(value = "/matl/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result detail(@RequestParam("id") Integer id){
        Result result = getResultInstance();
        try{
            result.setData(materialService.getInfo(id));
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }


    //修改原材料
    @RequestMapping(value = "/matl/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam(value = "memo", required = false, defaultValue = "") String memo,
                       @RequestParam("unit") String unit,
                       @RequestParam("price") Double price,
                       @RequestParam("typeId")Integer typeId,
                       @RequestParam("standardId") String  standardId,
                       @RequestParam("standardName") String  standardName,
                       @RequestParam("standardWeight") Double standardWeight,
                       @RequestParam("token") String token){
        Result result = getResultInstance();
        try{
            DietMatl matl = materialService.select(id);
            matl.setName(name);
            matl.setMemo(memo);
            matl.setUnit(unit);
            matl.setPrice(price);
            matl.setTypeId(typeId);
            matl.setStandardId(standardId);
            matl.setStandardName(standardName);
            matl.setStandardWeight(standardWeight);
            matl.setUpdateTime(new Date());
            matl.setUpdateBy(getCurrentUser(token).getUserId());
            materialService.update(matl);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }



    //删除原材料
    @RequestMapping(value = "/matl/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam("id") Integer id,
                       @RequestParam("token") String token){
        Result result = getResultInstance();
        try{
            DietMatl matl = materialService.select(id);
            matl.setStatus(0);
            matl.setUpdateTime(new Date());
            matl.setUpdateBy(getCurrentUser(token).getUserId());
            materialService.update(matl);
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
