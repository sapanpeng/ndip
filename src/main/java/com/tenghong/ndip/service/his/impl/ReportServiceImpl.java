package com.tenghong.ndip.service.his.impl;

import java.util.ArrayList;
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

	@Override
	public void getSendMeals(PageInfo pageInfo) {
		List<ReportHisOms> list = reportMapper.getSendMeals(pageInfo);
		pageInfo.setRows(list);
        pageInfo.setRecords(reportMapper.findSendMealCount(pageInfo));
	}

	@Override
	public List<ReportHisOms> getOvenStat(String diningTime, Integer cafeteriaId, List<String> ovenIdList) {
		List<ReportHisOms> list = reportMapper.getOvenStat(diningTime, cafeteriaId, ovenIdList);
		List<ReportHisOms> reportHisOmsList = new ArrayList<ReportHisOms>();
		for (ReportHisOms oms : list) {
			int icount1 = 0;
			for (ReportHisOms reportOms : reportHisOmsList) {
				if (oms.getOvenId() == reportOms.getOvenId()) {
					icount1 = 1;
					int icount2 = 0;
					List<ReportHisOms> mealList =  reportOms.getMealList();
					for (ReportHisOms meal : mealList) {
						if (oms.getMealId() == meal.getMealId()) {
							icount2 = 1;
							List<ReportHisOms> menuList =  meal.getMenuList();
							menuList.add(oms);
//							for (ReportHisOms menu : menuList) {
//								if (oms.getMealId() == menu.getMealId()) {
//									
//								}
//							}
						}
					}
					
					if (icount2 == 0) {
						ReportHisOms meal = new ReportHisOms();
						meal.setOvenId(oms.getOvenId());
						meal.setOvenName(oms.getOvenName());
						meal.setMealId(oms.getMealId());
						meal.setMealName(oms.getMealName());
						meal.getMenuList().add(oms);
						reportOms.getMealList().add(meal);
					}
				} 
			}
			
			if (icount1 == 0) {
				ReportHisOms reportHisOms = new ReportHisOms();
				reportHisOms.setOvenId(oms.getOvenId());
				reportHisOms.setOvenName(oms.getOvenName());
				ReportHisOms meal = new ReportHisOms();
				meal.setOvenId(oms.getOvenId());
				meal.setOvenName(oms.getOvenName());
				meal.setMealId(oms.getMealId());
				meal.setMealName(oms.getMealName());
				meal.getMenuList().add(oms);
				reportHisOms.getMealList().add(meal);
				reportHisOmsList.add(reportHisOms);
			}
		}
		return reportHisOmsList;
	}
}
