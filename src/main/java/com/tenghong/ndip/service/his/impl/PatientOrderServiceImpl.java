package com.tenghong.ndip.service.his.impl;

import com.tenghong.ndip.mapper.his.HisPatientOrdersMapper;
import com.tenghong.ndip.model.his.HisPatientOrders;
import com.tenghong.ndip.service.his.PatientOrdersService;
import com.tenghong.ndip.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 23:08 2018/6/24
 */
@Service
public class PatientOrderServiceImpl implements PatientOrdersService{

    @Autowired
    private HisPatientOrdersMapper patientOrdersMapper;

    @Override
    public List<HisPatientOrders> getDataGrip(List<Integer> list,Integer userId) {
        List<HisPatientOrders> retList = patientOrdersMapper.findDataByIdList(list,userId);
        for (HisPatientOrders orders : retList){
            if (DateUtil.format(orders.getStartTime(),"yyyy-MM-dd").equals(DateUtil.format(new Date(),"yyyy-MM-dd")))
                orders.setIsNew(1);
            else
                orders.setIsNew(0);
        }
        return retList;
    }
}
