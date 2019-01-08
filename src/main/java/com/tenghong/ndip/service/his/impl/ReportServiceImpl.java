package com.tenghong.ndip.service.his.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenghong.ndip.mapper.his.ReportMapper;
import com.tenghong.ndip.model.his.ReportHisOms;
import com.tenghong.ndip.service.his.ReportService;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:26 2018/6/23
 */
@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private ReportMapper reportMapper;

	@Override
	public void getUseMeals(PageInfo pageInfo) {
		List<ReportHisOms> list = reportMapper.getUseMeals(pageInfo);
		pageInfo.setRows(list);
        pageInfo.setRecords(reportMapper.findUseMealCount(pageInfo));
	}

	
}
