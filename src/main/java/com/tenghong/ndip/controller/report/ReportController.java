package com.tenghong.ndip.controller.report;

import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.model.vo.report.DeptIncomeVo;
import com.tenghong.ndip.service.his.OmsService;
import com.tenghong.ndip.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 10:55 2018/7/19
 */
@Controller
@RequestMapping("/admin")
public class ReportController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private OmsService omsService;

    //病区金额汇总表
    @RequestMapping(value = "/report/wardAmountMoney",method = RequestMethod.POST)
    @ResponseBody
    public Result wardAmountMoney(@RequestParam("startDate") String startDate,
                                  @RequestParam("endDate") String endDate,
                                  @RequestParam(value = "cafeteriaId", required = false, defaultValue = "") Integer cafeteriaId,
                                  @RequestParam(value = "departmentId", required = false, defaultValue = "") String departmentId,
                                  @RequestParam(value = "wardId", required = false, defaultValue = "") Integer wardId,
                                  @RequestParam(value = "mealTimesId", required = false, defaultValue = "") Integer mealTimesId,
                                  @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> map = getQueryMap();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "ward.sort", "desc");
            map.put("startDate",startDate);
            map.put("endDate",endDate);
            map.put("cafeteriaId",cafeteriaId);
            map.put("departmentId",departmentId);
            map.put("wardId",wardId);
            map.put("mealTimesId",mealTimesId);
            pageInfo.setCondition(map);
            omsService.getWardIncome(pageInfo);
            pageInfo.setTitle(getCafeteriaName(cafeteriaId)+"病区金额汇总表");
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

    //营业情况简表
    @RequestMapping(value = "/report/buinessSituation",method = RequestMethod.POST)
    @ResponseBody
    public Result buinessSituation(@RequestParam("startDate") String startDate,
                                  @RequestParam("endDate") String endDate,
                                  @RequestParam("cafeteriaId") Integer cafeteriaId,
                                  @RequestParam(value = "departmentId", required = false, defaultValue = "") String departmentId,
                                  @RequestParam(value = "wardId", required = false, defaultValue = "") Integer wardId,
                                  @RequestParam(value = "hisNo", required = false, defaultValue = "") String hisNo){
        Result result = getResultInstance();
        Map<String,Object> map = getQueryMap();
        try{
            PageInfo pageInfo = new PageInfo(1, 100, "ward.sort", "desc");
            map.put("startDate",startDate);
            map.put("endDate",endDate);
            map.put("cafeteriaId",cafeteriaId);
            map.put("departmentId",departmentId);
            map.put("wardId",wardId);
            map.put("hisNo",hisNo);
            pageInfo.setCondition(map);
            DeptIncomeVo vo = omsService.getDeptIncome(pageInfo);
            vo.setTitle(getCafeteriaName(cafeteriaId)+"营业情况简表");
            result.setData(vo);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //订单信息查询
    @RequestMapping(value = "/report/orderInformation",method = RequestMethod.POST)
    @ResponseBody
    public Result orderInformation(@RequestParam("startDate") String startDate,
                                   @RequestParam("endDate") String endDate,
                                   @RequestParam("cafeteriaId") Integer cafeteriaId,
                                   @RequestParam("wardId") Integer wardId,
                                   @RequestParam(value = "departmentId", required = false, defaultValue = "") String departmentId,
                                   @RequestParam(value = "hisNo", required = false, defaultValue = "") String hisNo,
                                   @RequestParam(value = "mealTimesId", required = false, defaultValue = "") String mealTimesId,
                                   @RequestParam(value = "name", required = false, defaultValue = "") String name,
                                   @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> map = getQueryMap();
        try{
            PageInfo pageInfo = new PageInfo(page, rows, "ward.sort", "desc");
            map.put("startDate",startDate);
            map.put("endDate",endDate);
            map.put("cafeteriaId",cafeteriaId);
            map.put("departmentId",departmentId);
            map.put("wardId",wardId);
            map.put("hisNo",hisNo);
            map.put("mealTimesId",mealTimesId);
            map.put("name",name);
            pageInfo.setCondition(map);
            omsService.getOrderInformation(pageInfo);
            pageInfo.setTitle(getCafeteriaName(cafeteriaId)+"订餐信息查询");
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


    //灶类明细统计表
    @RequestMapping(value = "/report/ovenRecords",method = RequestMethod.POST)
    @ResponseBody
    public Result ovenRecords(@RequestParam("date") String date,
                              @RequestParam(value = "ovenId", required = false, defaultValue = "") Integer ovenId,
                                   @RequestParam("cafeteriaId") Integer cafeteriaId,
                                   @RequestParam(value = "departmentId", required = false, defaultValue = "") String departmentId,
                                   @RequestParam(value = "mealTimesId", required = false, defaultValue = "") Integer mealTimesId){
        Result result = getResultInstance();
        try{
            result.setData(omsService.getOvenRecords(cafeteriaId,ovenId,date,departmentId,mealTimesId));
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //原材料统计
    @RequestMapping(value = "/report/matlRecords",method = RequestMethod.POST)
    @ResponseBody
    public Result matlRecords(@RequestParam("date") String date,
                              @RequestParam(value = "ovenId", required = false, defaultValue = "") Integer ovenId,
                              @RequestParam("cafeteriaId") Integer cafeteriaId){
        Result result = getResultInstance();
        try{
            result.setData(null);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }
}
