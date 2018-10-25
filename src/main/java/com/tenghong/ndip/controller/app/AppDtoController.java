package com.tenghong.ndip.controller.app;

import com.google.common.collect.Maps;
import com.tenghong.ndip.config.exception.NullException;
import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.core.NdipUtils;
import com.tenghong.ndip.core.Result;
import com.tenghong.ndip.core.constants.HisOmsEnum;
import com.tenghong.ndip.model.diet.DietMealTimes;
import com.tenghong.ndip.model.diet.DietOven;
import com.tenghong.ndip.model.dto.OmsAppDto;
import com.tenghong.ndip.model.his.*;
import com.tenghong.ndip.service.diet.DietMenuService;
import com.tenghong.ndip.service.diet.DietRelationService;
import com.tenghong.ndip.service.diet.MealTimesService;
import com.tenghong.ndip.service.diet.OvenService;
import com.tenghong.ndip.service.his.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 20:30 2018/6/24
 */
@Controller
@RequestMapping("/api")
public class AppDtoController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(AppDtoController.class);

    @Value("#{applicationProperties['image.path.url']}")
    private String fileViewPath;

    @Value("#{applicationProperties['oms.ded.style']}")
    private String style;

    @Value("#{applicationProperties['his.manager.patient']}")
    private String hisManager;

    @Autowired
    private CafeteriaService cafeteriaService;

    @Autowired
    private InpatientAreaService inpatientAreaService;

    @Autowired
    private OvenService ovenService;

    @Autowired
    private MealTimesService mealTimesService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientOrdersService patientOrdersService;

    @Autowired
    private AreaCafeteriaService areaCafeteriaServic;

    @Autowired
    private OmsService omsService;

    @Autowired
    private DietMenuService menuService;

    @Autowired
    private OvenOrderService ovenOrderService;

    @Autowired
    private DataSaveSerice dataSaveSerice;

    @RequestMapping(value = "/downland")
    @ResponseBody
    public Result downland(@RequestParam("token")String token){
        Result result = getResultInstance();

        try{
            //获得送餐员id
            Integer userId = getCurrentUser(token).getUserId();
            String userName = getCurrentUser(token).getUserName();
            List<Integer> list = areaCafeteriaServic.getCatefeteriaIds(userName);
            if (list.isEmpty() || null == list){
                result.setMsg("无相关食堂");
                result.setState(0);
                return result;
            }
            String catIds = NdipUtils.ndipInstance().getIds(list);
            result = ndipDownData(list,catIds,userId);
            result.setState(1);
            result.setMsg("success");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

    //膳食系统实现数据下载
    private Result ndipDownData(List<Integer> list,String catIds,Integer userId){
        Result result = getResultInstance();
        Map<String,Object> map = Maps.newHashMap();
        map.put("cafeteria",cafeteriaService.getDataGrip(list,fileViewPath));
        map.put("ward",inpatientAreaService.getDataGrip(list,fileViewPath,userId));
        map.put("ovenType",ovenService.getTypeDataGrip(list,fileViewPath));
        map.put("oven",ovenService.getDataGrip(list));
        map.put("mealTimes",mealTimesService.getDataGrip(list,fileViewPath));
        map.put("patient",patientService.getDataGrip(list,userId));
        map.put("patientOrders",patientOrdersService.getDataGrip(list,userId));
        map.put("oms",omsService.getDataGrip(list,userId));
        map.put("menu",menuService.getDataGrip(catIds,fileViewPath));
        map.put("hisRelation",areaCafeteriaServic.gelAll(userId));
        map.put("hisOrderOvenRelation",ovenOrderService.list());
        result.setData(map);
        return result;
    }


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Result upload(@RequestBody List<OmsAppDto> dtoList){
        Result result = getResultInstance();
        try{
            result = dataSaveSerice.saveAppData(dtoList,style);
        }catch (NullException e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("病人病区与系统病区不符合");
        }catch (Exception e){
            LOGGER.error("Server Exception：{}",e);
            result.setState(0);
            result.setMsg("Server Exception");
        }
        return result;
    }

}
