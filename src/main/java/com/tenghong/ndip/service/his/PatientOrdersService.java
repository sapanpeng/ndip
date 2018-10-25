package com.tenghong.ndip.service.his;

import com.tenghong.ndip.model.his.HisPatientOrders;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 23:08 2018/6/24
 */
public interface PatientOrdersService {

    //获取列表app
    List<HisPatientOrders> getDataGrip(List<Integer> list,Integer userId);
}
