package com.tenghong.ndip.service.his.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<ReportHisOms> getConsumptionStat(String diningTime, Integer cafeteriaId, List<String> mealIdList,
			String deptCode, Integer wardId) {
		List<ReportHisOms> list = reportMapper.getConsumptionStat(diningTime, cafeteriaId, mealIdList, deptCode, wardId);
		List<ReportHisOms> reportHisOmsList = new ArrayList<ReportHisOms>();
		for (ReportHisOms oms : list) {
			int icount1 = 0;
			for (ReportHisOms reportOms : reportHisOmsList) {
				if (oms.getPatientId().equals(reportOms.getPatientId())) {
					icount1 = 1;
					List<ReportHisOms> mealList =  reportOms.getMealList();
					mealList.add(oms);
				} 
			}
			if (icount1 == 0) {
				ReportHisOms reportHisOms = new ReportHisOms();
				reportHisOms.setWardId(oms.getWardId());;
				reportHisOms.setWardName(oms.getWardName());
				reportHisOms.setBedNo(oms.getBedNo());
				reportHisOms.setInpNo(oms.getInpNo());
				reportHisOms.setPatientId(oms.getPatientId());
				reportHisOms.setPatientName(oms.getPatientName());
				ReportHisOms meal = new ReportHisOms();
				meal.setMealId(oms.getMealId());
				meal.setMealName(oms.getMealName());
				meal.setGoalId(oms.getGoalId());
				meal.setGoalName(oms.getGoalName());
				meal.setNum(oms.getNum());
				meal.setAmount(oms.getAmount());
				reportHisOms.getMealList().add(meal);
				reportHisOmsList.add(reportHisOms);
			}
		}
		
		for (ReportHisOms oms : reportHisOmsList) {
			Double amount = new Double(0);
			Map<Integer, Double> amountMap = new HashMap<Integer, Double>();
			for (ReportHisOms meal : oms.getMealList()) {
				amount = amount.doubleValue() + meal.getAmount().doubleValue();
				if (amountMap.get(meal.getMealId()) == null) {
					amountMap.put(meal.getMealId(), meal.getAmount());
				} else {
					amountMap.put(meal.getMealId(), amountMap.get(meal.getMealId()).doubleValue() + meal.getAmount().doubleValue());
				}
			}
			for (ReportHisOms meal : oms.getMealList()) {
				if (amountMap.get(meal.getMealId()) != null) {
					meal.setTotalAmount(amountMap.get(meal.getMealId()));
				}
			}
			oms.setTotalAmount(amount);
		} 
		return reportHisOmsList;
	}

	@Override
	public List<ReportHisOms> getWardAmountStat(String diningTimeBegin, String diningTimeEnd, Integer cafeteriaId,
			List<String> mealIdList, String deptCode, Integer wardId) {
		return reportMapper.getWardAmountStat(diningTimeBegin, diningTimeEnd, cafeteriaId, mealIdList, deptCode, wardId);
	}
	
	@Override
    public void getOrderInformation(PageInfo pageInfo) {
        pageInfo.setRows(reportMapper.selectOrderInformation(pageInfo));
        pageInfo.setTotal(reportMapper.selectOrderInformationCount(pageInfo));
    }

	@Override
	public List<ReportHisOms> getCost(String diningTime, Integer cafeteriaId, List<String> mealIdList, String deptCode,
			Integer wardId) {
		return reportMapper.getCost(diningTime, cafeteriaId, mealIdList, deptCode, wardId);
	}
	
	@Override
	public List<ReportHisOms> getFoodStat(String diningTimeBegin, String diningTimeEnd, Integer cafeteriaId, String ovenCode) {
		return reportMapper.getFoodStat(diningTimeBegin, diningTimeEnd, cafeteriaId, ovenCode);
	}

	@Override
	public List<ReportHisOms> getFoodDetailStat(String diningTimeBegin, String diningTimeEnd, Integer cafeteriaId, String ovenCode) {
		return reportMapper.getFoodDetailStat(diningTimeBegin, diningTimeEnd, cafeteriaId, ovenCode);
	}

	@Override
	public List<ReportHisOms> getFoodPurchaseStat(String diningTimeBegin, String diningTimeEnd, Integer cafeteriaId, String ovenCode) {
		return reportMapper.getFoodPurchaseStat(diningTimeBegin, diningTimeEnd, cafeteriaId, ovenCode);
	}
}
