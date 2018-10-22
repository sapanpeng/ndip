package com.tenghong.ndip.controller.his;

import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.his.HisOrderOvenRelation;
import com.tenghong.ndip.service.his.OvenOrderService;
import com.tenghong.ndip.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Date: created in 23:05 2018/6/20
 */
@Controller
@RequestMapping("/admin")
public class OvenOrderController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(OvenOrderController.class);

    @Autowired
    private OvenOrderService ovenOrderService;

    @RequestMapping(value = "/ovenOrder/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "ovenId", required = false, defaultValue = "")Integer ovenId,
                       @RequestParam(value = "ovenTypeId", required = false, defaultValue = "")Integer ovenTypeId,
                       @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> map = getQueryMap();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "id", "desc");
            map.put("ovenId",ovenId);
            map.put("ovenTypeId",ovenTypeId);
            pageInfo.setCondition(map);
            ovenOrderService.getDataGrip(pageInfo);
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

    @RequestMapping(value = "/ovenOrder/detail",method = RequestMethod.POST)
    @ResponseBody
    public Result detail(@RequestParam(value = "id")Integer id){
        Result result = getResultInstance();
        try{
            result.setData(ovenOrderService.select(id));
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/ovenOrder/preSave",method = RequestMethod.POST)
    @ResponseBody
    public Result preSave(){
        Result result = getResultInstance();
        try{
            result.setData(ovenOrderService.getOrderList());
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/ovenOrder/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam(value = "id")Integer id){
        Result result = getResultInstance();
        try{
            ovenOrderService.delete(id);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/ovenOrder/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam(value = "id") Integer id,
                       @RequestParam(value = "orderName") String orderName,
                       @RequestParam(value = "orderCode") String orderCode,
                       @RequestParam(value = "memo", required = false, defaultValue = "") String memo,
                       @RequestParam(value = "ovenName")  String ovenName,
                       @RequestParam(value = "ovenId")  Integer ovenId,
                       @RequestParam(value = "ovenTypeName")  String ovenTypeName,
                       @RequestParam(value = "ovenTypeId")  Integer ovenTypeId){
        Result result = getResultInstance();
        try{
            HisOrderOvenRelation relation = ovenOrderService.select(id);
            relation.setOrderCode(orderCode);
            relation.setOrderName(orderName);
            relation.setMemo(memo);
            relation.setOvenId(ovenId);
            relation.setOvenName(ovenName);
            relation.setOvenTypeId(ovenTypeId);
            relation.setOvenTypeName(ovenTypeName);
            ovenOrderService.update(relation);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @RequestMapping(value = "/ovenOrder/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save( @RequestParam(value = "orderName") String orderName,
                        @RequestParam(value = "orderCode") String orderCode,
                        @RequestParam(value = "memo", required = false, defaultValue = "") String memo,
                        @RequestParam(value = "ovenName")  String ovenName,
                        @RequestParam(value = "ovenId")  Integer ovenId,
                        @RequestParam(value = "ovenTypeName")  String ovenTypeName,
                        @RequestParam(value = "ovenTypeId")  Integer ovenTypeId){
        Result result = getResultInstance();
        try{
            if (ovenOrderService.selectByOrderCode(orderCode)){
                result.setState(0);
                result.setMsg("当前医嘱已绑定灶类");
                return result;
            }
            HisOrderOvenRelation relation = new HisOrderOvenRelation();
            relation.setOrderCode(orderCode);
            relation.setOrderName(orderName);
            relation.setMemo(memo);
            relation.setOvenId(ovenId);
            relation.setOvenName(ovenName);
            relation.setOvenTypeId(ovenTypeId);
            relation.setOvenTypeName(ovenTypeName);
            ovenOrderService.save(relation);
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
