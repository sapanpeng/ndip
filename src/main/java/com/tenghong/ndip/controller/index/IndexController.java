package com.tenghong.ndip.controller.index;

import com.google.common.collect.Maps;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.service.diet.OvenService;
import com.tenghong.ndip.service.his.CafeteriaService;
import com.tenghong.ndip.service.his.InpatientAreaService;
import com.tenghong.ndip.service.his.OmsService;
import com.tenghong.ndip.service.his.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 13:55 2018/7/17
 */
@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private OmsService omsService;

    @Autowired
    private CafeteriaService cafeteriaService;

    @Autowired
    private InpatientAreaService inpatientAreaService;

    @Autowired
    private OvenService ovenService;


    @RequestMapping(value = "/index",method = RequestMethod.POST)
    @ResponseBody
    public Result index(@RequestParam("cafeteriaId") Integer cafeteriaId){
        Result result = getResultInstance();
        Map<String,Object> map = Maps.newHashMap();
        try{
            map.put("yesterdayPatientNum",patientService.getYesterdayPatients(cafeteriaId));
            map.put("yesterdayBookRate",getPercent(patientService.getYesterdayPatientsHadOrder(cafeteriaId),patientService.getYesterdayPatients(cafeteriaId)));
            map.put("yesterdayTurnover",omsService.getYesterdayReward(cafeteriaId));
            map.put("cafeteriaTurnoverList",cafeteriaService.getTurnover());
            map.put("wardCostList",inpatientAreaService.getTurnover(cafeteriaId));
            map.put("dailyBookRateList",patientService.getPatientOrderNum(cafeteriaId));
            map.put("ovenBookList",ovenService.getDailyOrderVal(cafeteriaId));
            result.setData(map);
            result.setMsg("success");
            result.setState(1);
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    public String getPercent(Integer param1,Integer param2){
        if (param2.toString().equals("0"))
            return "0.00%";
        double percent = (double)param1/param2;
        NumberFormat nt = NumberFormat.getPercentInstance();//获取格式化对象
        nt.setMinimumFractionDigits(2);
        return nt.format(percent);
    }
}
