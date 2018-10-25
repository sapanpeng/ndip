package com.tenghong.ndip.controller.task;

import com.tenghong.ndip.controller.BaseController;
import com.tenghong.ndip.controller.sys.ResourcesController;
import com.tenghong.ndip.service.diet.DietMenuService;
import com.tenghong.ndip.service.his.OmsService;
import com.tenghong.ndip.utils.DateUtil;
import com.tenghong.ndip.utils.EhcacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 20:17 2018/6/25
 */
@Component
public class SchduledController extends BaseController {



    @Autowired
    private OmsService omsService;

    //@Scheduled(cron = "0 0/1 * * * ? ")
    public void refresh(){
        List<Integer> keyList = (List<Integer>) EhcacheUtil.getInstance().get("mealTimesCache", "ovenKeyList");
        for (Integer item : keyList){
            if (DateUtil.getHourTime(new Date()).equals(EhcacheUtil.getInstance().get("mealTimesCache",item.toString()))){
                omsService.refreshOms(item);
            }
        }

    }
}
