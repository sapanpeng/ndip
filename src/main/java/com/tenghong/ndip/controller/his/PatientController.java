package com.tenghong.ndip.controller.his;

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
import com.tenghong.ndip.service.his.PatientService;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 17:48 2018/6/22
 */
@Controller
@RequestMapping("/admin")
public class PatientController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(OvenOrderController.class);

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/patient/list",method = RequestMethod.POST)
    @ResponseBody
    public Result list(@RequestParam(value = "diningDate", required = false, defaultValue = "")String diningDate,
                       @RequestParam(value = "wardId", required = false, defaultValue = "")Integer wardId,
                       @RequestParam(value = "cafeteriaId", required = false, defaultValue = "")Integer cafeteriaId,
                       @RequestParam(value = "bedNo", required = false, defaultValue = "")Integer bedNo,
                       @RequestParam(value = "sex", required = false, defaultValue = "")Integer sex,
                       @RequestParam(value = "inpNo", required = false, defaultValue = "")String inpNo,
                       @RequestParam(value = "mainJudge", required = false, defaultValue = "")String mainJudge,
                       @RequestParam(value = "order", required = false, defaultValue = "")String order,
                       @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer rows){
        Result result = getResultInstance();
        Map<String,Object> queryMap = getQueryMap();
        try{
        	queryMap.put("wardId",wardId);
            queryMap.put("cafeteriaId",cafeteriaId);
            queryMap.put("bedNo",bedNo);
            if (sex != null) {
            	if(sex == 0) {
            		queryMap.put("sex","男");
            	} else if(sex == 1) {
            		queryMap.put("sex","女");
            	}
            } else {
            	queryMap.put("sex",sex);
            }
            
            queryMap.put("inpNo",inpNo);
            queryMap.put("mainJudge",mainJudge);
            queryMap.put("diningDate",diningDate);
            queryMap.put("order",order);
            PageInfo pageInfo = new PageInfo(page, rows, "id", "desc");
            pageInfo.setCondition(queryMap);
            patientService.getDataGrip(pageInfo,diningDate);
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
}
