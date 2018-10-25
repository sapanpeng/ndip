package com.tenghong.ndip.service.his.impl;

import com.tenghong.ndip.mapper.his.HisOmsStatusMapper;
import com.tenghong.ndip.model.his.HisOms;
import com.tenghong.ndip.model.his.HisOmsStatus;
import com.tenghong.ndip.service.his.OmsService;
import com.tenghong.ndip.service.his.OmsStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:09 2018/6/24
 */
@Service
public class OmsStatusServiceImpl implements OmsStatusService {

    @Autowired
    private HisOmsStatusMapper omsStatusMapper;

    @Override
    public void save(HisOmsStatus status) {
        omsStatusMapper.insertSelective(status);
    }
}
