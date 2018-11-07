package com.tenghong.ndip.controller.his;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.tenghong.ndip.config.exception.NullException;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.core.constants.HisOmsEnum;
import com.tenghong.ndip.model.command.OrderReportCommand;
import com.tenghong.ndip.model.diet.DietMealTimes;
import com.tenghong.ndip.model.his.HisCafeteria;
import com.tenghong.ndip.model.his.HisInpatientArea;
import com.tenghong.ndip.model.his.HisOms;
import com.tenghong.ndip.model.his.HisOmsDetails;
import com.tenghong.ndip.model.his.HisPatient;
import com.tenghong.ndip.service.diet.DietRelationService;
import com.tenghong.ndip.service.diet.MealTimesService;
import com.tenghong.ndip.service.diet.OvenService;
import com.tenghong.ndip.service.his.CafeteriaService;
import com.tenghong.ndip.service.his.DataSaveSerice;
import com.tenghong.ndip.service.his.InpatientAreaService;
import com.tenghong.ndip.service.his.OmsDetailsService;
import com.tenghong.ndip.service.his.OmsService;
import com.tenghong.ndip.service.his.PatientService;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 17:49 2018/6/22
 */
@Controller
@RequestMapping("/admin")
public class OmsController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OmsController.class);

    @Autowired
    private OmsService omsService;

    @Autowired
    private MealTimesService mealTimesService;

    @Autowired
    private OvenService ovenService;

    @Autowired
    private CafeteriaService cafeteriaService;

    @Autowired
    private OmsDetailsService omsDetailsService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private InpatientAreaService inpatientAreaService;

    @Autowired
    private DietRelationService dietRelationService;

    @Autowired
    private DataSaveSerice dataSaveSerice;

    @Value("#{applicationProperties['oms.ded.style']}")
    private String style;

    @Value("#{applicationProperties['his.manager.patient']}")
    private String hisManager;

    //批量订餐
    @RequestMapping(value = "/oms/saveBatch", method = RequestMethod.POST)
    @ResponseBody
    public Result saveBatch(@RequestParam("patientList") String patient,
                            @RequestParam("diningTime") Date diningTime,
                            @RequestParam("omsDetail") String omsDetail,
                            @RequestParam("token") String token) {
        Result result = getResultInstance();
        try {
            List<String> list = JSONArray.parseArray(patient, String.class);
            LOGGER.info("病人id集合 {}", list.size());
            if (list.size() == 0) {
                result.setState(0);
                result.setMsg("请选择病人");
                return result;
            }
            List<HisOmsDetails> details = JSONArray.parseArray(omsDetail, HisOmsDetails.class);
            result = dataSaveSerice.saveWebData(details,diningTime,list,token,style);
        } catch (NullException e) {
            LOGGER.error("Server Exception：{}", e);
            result.setState(0);
            result.setMsg("病人病区与系统病区不符合");
        } catch (Exception e) {
            LOGGER.error("Server Exception：{}", e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //详情列表
    @RequestMapping(value = "/oms/detailList", method = RequestMethod.POST)
    @ResponseBody
    public Result getDetailList(@RequestParam("patientId") String patientId,
                                @RequestParam("diningDate") String diningDate,
                                @RequestParam(value = "mealId", required = false, defaultValue = "") Integer mealId) {
        Result result = getResultInstance();
        try {
            result.setData(omsDetailsService.getList(patientId, diningDate, mealId));
            result.setState(1);
            result.setMsg("success");
        } catch (Exception e) {
            LOGGER.error("Server Exception：{}", e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //修改订单
    @RequestMapping(value = "/oms/detailEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result detailEdit(@RequestParam("patientId") String patientId,
                             @RequestParam("diningTime") Date diningTime,
                             @RequestParam("omsDetail") String omsDetail,
                             @RequestParam("token") String token) throws Exception {
        Result result = getResultInstance();
        try {
            List<HisOmsDetails> details = JSONArray.parseArray(omsDetail, HisOmsDetails.class);
//            List<Integer> listOmsIds = new ArrayList<Integer>();
            Integer omsId = null;
            HisOms oms = new HisOms();
            Double price = Double.valueOf(0);
//            List<HisOms> omsList = new ArrayList<HisOms>();
            for (HisOmsDetails detail : details) {
            	if (omsId == null) {
            		omsId = detail.getOmsId();
            	}
//            	if (detail.getOmsId() != null) {
//            		listOmsIds.add(detail.getOmsId());
//            	}
//            	for (HisOms hisOms : omsList) {
//            		if (hisOms.getMealId() == detail.getMealId()) {
//            			oms = hisOms;
//            		} 
//            	}
//            	
//            	if (oms == null) {
//        			oms = new HisOms();
//        			omsList.add(oms);
//        		}
//            	 Double price = oms.getPrice();
//            	 if (price == null) {
//            		 price = Double.valueOf(0);
//            	 }
                 detail.setCurrentPrice(getDouble(detail.getGoalPrice() * detail.getGoalNum()));
                 price += detail.getCurrentPrice();
                 oms.setPatientId(patientId);
                 oms.setMealId(detail.getMealId());
                 oms.setMealName(detail.getMealName());
            }
            
            if (style.equals("1")) {
           	 oms.setOmsType(HisOmsEnum.PAY.getType());
            } else {
           	 oms.setOmsType(HisOmsEnum.WAIT_FOR_PAY.getType()); 
            }
            oms.setUserName(getCurrentUser(token).getUserName());
            oms.setUserId(getCurrentUser(token).getUserId());
            oms.setDiningTime(diningTime);
            oms.setCreateTime(new Date());
            oms.setCreateBy(getCurrentUser(token).getUserId());
            oms.setPrice(price);
            
            
            //根据病人信息查询当前时间是否存在历史订单
//            for (Integer omsId : listOmsIds) {
            	HisOms om = omsService.getOne(omsId);
            	if (om!=null){
            		if (om.getOmsType() == HisOmsEnum.PAY.getType()){
            			LOGGER.info("进入退款方法.....");
            			patientService.rewardWallet(om, om.getPrice());
            		}
            		LOGGER.info("进入修改订单类型状态方法.....{}",om.getOmsType());
            		om.setOmsType(HisOmsEnum.REFUND.getType());
            		om.setUpdateTime(new Date());
            		om.setUpdateBy(getCurrentUser(token).getUserId());
            		saveOmsStatus(om.getId(), om.getOmsType(), om.getCreateBy(), om.getCreateTime());
            		omsService.update(om);
            		LOGGER.info("修改订单类型状态方法完成.....{}",om.getOmsType());
            	}
//            }
            
//            omsDetailsService.deleteBy(patientId, diningTime);
//            omsService.deleteBy(patientId, diningTime);
//            for (HisOms hisOms : omsList) {
            	 DietMealTimes times = mealTimesService.select(oms.getMealId());
                 HisCafeteria cafeteria = cafeteriaService.select(times.getCafeteriaId());
                 HisPatient patientS = patientService.select(patientId);
                 HisInpatientArea area = inpatientAreaService.selectByCode(patientS.getWardCode());
                 if (null == area) {
                     throw new NullException();
                 }
                 oms.setWardId(area.getId());
                 oms.setWardName(area.getWardName());
                 oms.setCafeteriaId(cafeteria.getId());
                 oms.setCafeteriaName(cafeteria.getCafeteriaName());
                 omsService.save(oms);
                 saveOmsStatus(oms.getId(), oms.getOmsType(), oms.getCreateBy(), oms.getCreateTime());
                 for (HisOmsDetails hisOmsDetails : details) {
                	 hisOmsDetails.setOmsId(oms.getId());
                	 omsDetailsService.save(hisOmsDetails);
                 }
                 
                 //实时扣款
                 if (style.equals("1")) {
                     patientService.dedWallet(oms);
                 }
//            }
            
            result.setState(1);
            result.setMsg("success");
        } catch (NullException e) {
            LOGGER.error("Server Exception：{}", e);
            result.setState(0);
            result.setMsg("病人病区与系统病区不符合");
            throw new Exception();
        } catch (Exception e) {
            LOGGER.error("Server Exception：{}", e);
            result.setState(0);
            result.setMsg("Server Exception");
            throw new Exception();
        }
        return result;
    }

    //查询订单列表
    @RequestMapping(value = "/oms/list", method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "diningDateStart", required = false, defaultValue = "") String diningDateStart,
                       @RequestParam(value = "diningDateEnd", required = false, defaultValue = "") String diningDateEnd,
                       @RequestParam(value = "wardId", required = false, defaultValue = "") Integer wardId,
                       @RequestParam(value = "cafeteriaId", required = false, defaultValue = "") Integer cafeteriaId,
                       @RequestParam(value = "ovenId", required = false, defaultValue = "") Integer ovenId,
                       @RequestParam(value = "mealId", required = false, defaultValue = "") Integer mealId,
                       @RequestParam(value = "userId", required = false, defaultValue = "") Integer userId,
                       @RequestParam(value = "patientName", required = false, defaultValue = "") Integer patientName,
                       @RequestParam(value = "bedNo", required = false, defaultValue = "") String bedNo,
                       @RequestParam(value = "inpNo", required = false, defaultValue = "") String inpNo,
                       @RequestParam(value = "typeId", required = false, defaultValue = "") Integer typeId,
                       @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer rows) {
        Result result = getResultInstance();
        Map<String, Object> map = getQueryMap();
        try {
            map.put("diningDateStart", diningDateStart);
            map.put("diningDateEnd", diningDateEnd);
            map.put("wardId", wardId);
            map.put("cafeteriaId", cafeteriaId);
            map.put("ovenId", ovenId);
            map.put("mealId", mealId);
            map.put("userId", userId);
            map.put("patientName", patientName);
            map.put("bedNo", bedNo);
            map.put("inpNo", inpNo);
            map.put("typeId", typeId);
            PageInfo pageInfo = new PageInfo(page, rows, "create_time", "desc");
            pageInfo.setCondition(map);
            omsService.getData(pageInfo);
            result.setData(pageInfo);
            result.setMsg("success");
            result.setState(1);
        } catch (Exception e) {
            LOGGER.error("Server Exception：{}", e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }


    @RequestMapping(value = "/oms/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestParam("detailsId") Integer id, @RequestParam("token") String token) { //2018-05-06
        Result result = getResultInstance();
        try {
            HisOmsDetails details = omsDetailsService.getInfo(id);
            HisOms oms = omsService.getOne(details.getOmsId());
            oms.setPrice(oms.getPrice() - details.getCurrentPrice());
            if (oms.getPrice().compareTo(Double.valueOf(0)) == 0) {
//            	omsService.deleteByPrimaryKey(oms.getId());
            	oms.setOmsType(HisOmsEnum.REFUND.getType());
            } 
            
//            omsService.update(oms);
            
            
            //根据病人信息查询当前时间是否存在历史订单
          	if (oms!=null){
          		if (oms.getOmsType() == HisOmsEnum.PAY.getType()){
          			LOGGER.info("进入退款方法.....");
          			patientService.rewardWallet(oms, details.getCurrentPrice());
          		}
          		LOGGER.info("进入修改订单类型状态方法.....{}",oms.getOmsType());
          		oms.setUpdateTime(new Date());
          		oms.setUpdateBy(getCurrentUser(token).getUserId());
          		omsService.update(oms);
          		LOGGER.info("修改订单类型状态方法完成.....{}",oms.getOmsType());
          	}
            
            
            
            //删除详情
            omsDetailsService.delete(id);
            saveOmsStatus(oms.getId(), oms.getOmsType(), oms.getCreateBy(), oms.getCreateTime());
            result.setState(1);
            result.setMsg("success");
        } catch (Exception e) {
            LOGGER.error("Server Exception：{}", e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/oms/receiveDetailList", method = RequestMethod.POST)
    public Result getReceiveDetailList(@RequestBody OrderReportCommand command) {
        Result result = getResultInstance();
        try {
            result.setData(omsService.selectReceiveDetail(command));
            result.setState(1);
            result.setMsg("success");
        } catch (Exception e) {
            LOGGER.error("Server Exception：{}", e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/oms/deliverDetailList", method = RequestMethod.POST)
    public Result getDeliverDetailList(@RequestBody OrderReportCommand command) {
        Result result = getResultInstance();
        try {
            result.setData(omsService.selectDeliverDetail(command));
            result.setState(1);
            result.setMsg("success");
        } catch (Exception e) {
            LOGGER.error("Server Exception：{}", e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    public Double getDouble(Double f) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(f));
    }

}
