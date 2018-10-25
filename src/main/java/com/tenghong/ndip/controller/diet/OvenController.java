package com.tenghong.ndip.controller.diet;

import com.alibaba.fastjson.JSONArray;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.diet.DietOven;
import com.tenghong.ndip.model.diet.DietOvenType;
import com.tenghong.ndip.model.dto.ImageDto;
import com.tenghong.ndip.service.diet.OvenService;
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
 * @Date: created in 17:02 2018/6/7
 */
@Controller
@RequestMapping("/admin")
public class OvenController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(OvenController.class);

    @Autowired
    private OvenService ovenService;

    @Value("#{applicationProperties['image.path.url']}")
    private String fileViewPath;

    @RequestMapping(value = "/ovenType/list",method = RequestMethod.POST)
    @ResponseBody
    public Result listType(@RequestParam("cafeteriaId")Integer cafeteriaId,
                           @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> queryMap = new HashMap<>();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "sort", "desc");
            queryMap.put("cafeteriaId",cafeteriaId);
            pageInfo.setCondition(queryMap);
            ovenService.getTypeDataGrip(pageInfo,fileViewPath);
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

    @RequestMapping(value = "/ovenType/save",method = RequestMethod.POST)
    @ResponseBody
    public Result saveType(@RequestParam("token") String token,
                           @RequestParam("ovenTypeName") String ovenTypeName,
                           @RequestParam("ovenTypePic") String ovenTypePic,
                           @RequestParam("ovenTypeIndex") Integer sort,
                           @RequestParam("cafeteriaId") Integer cafeteriaId,
                           @RequestParam("cafeteriaName") String cafeteriaName,
                           @RequestParam(value = "memo", required = false, defaultValue = "") String memo){
        Result result = getResultInstance();
        try{
            List<ImageDto> list = JSONArray.parseArray(ovenTypePic, ImageDto.class);
            DietOvenType type = new DietOvenType();
            type.setOvenTypeName(ovenTypeName);
            type.setOvenTypePic(NdipUtils.ndipInstance().getImageName(list));
            type.setSort(sort);
            type.setMemo(memo);
            type.setCafeteriaId(cafeteriaId);
            type.setCafeteriaName(cafeteriaName);
            type.setCreateBy(getCurrentUser(token).getUserId());
            type.setCreateTime(new Date());
            ovenService.saveType(type);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/ovenType/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result detailType(@RequestParam("ovenTypeId") Integer ovenTypeId){
        Result result = getResultInstance();
        try{
            DietOvenType type = ovenService.getInfoType(ovenTypeId,fileViewPath);
            result.setData(type);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/ovenType/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result editType(@RequestParam("token") String token,
                           @RequestParam("ovenTypeId") Integer ovenTypeId,
                           @RequestParam("ovenTypeName") String ovenTypeName,
                           @RequestParam("ovenTypePic") String ovenTypePic,
                           @RequestParam("ovenTypeIndex") Integer sort,
                           @RequestParam("cafeteriaId") Integer cafeteriaId,
                           @RequestParam("cafeteriaName") String cafeteriaName,
                           @RequestParam(value = "memo", required = false, defaultValue = "") String memo){
        Result result = getResultInstance();
        try{
            List<ImageDto> list = JSONArray.parseArray(ovenTypePic, ImageDto.class);
            DietOvenType type = ovenService.getInfoType(ovenTypeId,fileViewPath);
            type.setOvenTypeName(ovenTypeName);
            type.setOvenTypePic(NdipUtils.ndipInstance().getImageName(list));
            type.setSort(sort);
            type.setCafeteriaId(cafeteriaId);
            type.setMemo(memo);
            type.setCafeteriaName(cafeteriaName);
            type.setUpdateBy(getCurrentUser(token).getUserId());
            type.setUpdateTime(new Date());
            ovenService.updateType(type);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/ovenType/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result deleteType(@RequestParam("token") String token,
                           @RequestParam("ovenTypeId") Integer ovenTypeId){
        Result result = getResultInstance();
        try{
            DietOvenType type = ovenService.getInfoType(ovenTypeId,fileViewPath);
            type.setStatus(0);
            type.setUpdateBy(getCurrentUser(token).getUserId());
            type.setUpdateTime(new Date());
            ovenService.updateType(type);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }


    @RequestMapping(value = "/oven/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam("ovenTypeId")Integer ovenTypeId,
                           @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> queryMap = new HashMap<>();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "sort", "desc");
            queryMap.put("ovenTypeId",ovenTypeId);
            pageInfo.setCondition(queryMap);
            ovenService.getDataGrip(pageInfo);
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

    @RequestMapping(value = "/oven/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("token") String token,
                           @RequestParam("ovenName") String ovenName,
                           @RequestParam("ovenIndex") Integer sort,
                           @RequestParam("ovenTypeId") Integer ovenTypeId,
                           @RequestParam("feeType") Integer feeType,
                           @RequestParam("isTreatment") Integer isTreatment,
                           @RequestParam("isPublic") Integer isPublic){
        Result result = getResultInstance();
        try{
            DietOven oven = new DietOven();
            oven.setOvenName(ovenName);
            oven.setSort(sort);
            oven.setOvenTypeId(ovenTypeId);
            oven.setFeeType(feeType);
            oven.setIsPublic(isPublic);
            oven.setIsTreatment(isTreatment);
            oven.setCreateBy(getCurrentUser(token).getUserId());
            oven.setCreateTime(new Date());
            ovenService.save(oven);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/oven/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result detail(@RequestParam("ovenId") Integer ovenId){
        Result result = getResultInstance();
        try{
            DietOven oven = ovenService.getInfo(ovenId);
            result.setData(oven);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/oven/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam("token") String token,
                           @RequestParam("ovenId") Integer ovenId,
                           @RequestParam("ovenCode") String ovenCode,
                           @RequestParam("ovenName") String ovenName,
                           @RequestParam("ovenIndex") Integer sort,
                           @RequestParam("ovenTypeId") Integer ovenTypeId,
                           @RequestParam("feeType") Integer feeType,
                           @RequestParam("isTreatment") Integer isTreatment,
                           @RequestParam("isPublic") Integer isPublic){
        Result result = getResultInstance();
        try{
            DietOven oven = ovenService.getInfo(ovenId);
            oven.setOvenCode(ovenCode);
            oven.setOvenName(ovenName);
            oven.setSort(sort);
            oven.setOvenTypeId(ovenTypeId);
            oven.setFeeType(feeType);
            oven.setIsPublic(isPublic);
            oven.setIsTreatment(isTreatment);
            oven.setUpdateBy(getCurrentUser(token).getUserId());
            oven.setUpdateTime(new Date());
            ovenService.update(oven);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/oven/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam("token") String token,
                       @RequestParam("ovenId") Integer ovenId){
        Result result = getResultInstance();
        try{
            DietOven oven = ovenService.getInfo(ovenId);
            oven.setStatus(0);
            oven.setUpdateBy(getCurrentUser(token).getUserId());
            oven.setUpdateTime(new Date());
            ovenService.update(oven);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/oven/tree",method = RequestMethod.POST)
    @ResponseBody
    public Result tree(@RequestParam("cafeteriaId") Integer cafeteriaId){
        Result result = getResultInstance();
        try{
            result.setData(ovenService.getTree(cafeteriaId));
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
