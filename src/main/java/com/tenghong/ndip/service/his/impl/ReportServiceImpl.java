package com.tenghong.ndip.service.his.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenghong.ndip.mapper.diet.DietMealTimesMapper;
import com.tenghong.ndip.mapper.diet.DietOvenMapper;
import com.tenghong.ndip.mapper.his.HisInpatientAreaMapper;
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
    
    @Autowired
    private DietMealTimesMapper dietMealTimesMapper;
    
    @Autowired
    private HisInpatientAreaMapper hisInpatientAreaMapper;
    
    @Autowired
    private DietOvenMapper ovenMapper;

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
		List<ReportHisOms> listReport = reportMapper.getCost(diningTime, cafeteriaId, mealIdList, deptCode, wardId);
		List<ReportHisOms> result = new ArrayList<>();
		result.addAll(listReport);
		for (ReportHisOms oms1 : result) {
			int icount = 0;
			for (ReportHisOms oms3 : result) {
				if (oms1.getMealId().intValue() == oms3.getMealId().intValue() && oms1.getGoalType().equals(oms3.getGoalType())
						&& oms1.getGoalId().intValue() == oms3.getGoalId().intValue() && oms3.getProfit() != null) {
					icount = 1;
					break;
				}
			}
			if (icount == 1)
				continue;
			oms1.setProfit(oms1.getAmount());
			for (ReportHisOms oms2 : listReport) {
				if (oms1.getMealId().intValue() == oms2.getMealId().intValue()
				 && oms1.getGoalId().intValue() == oms2.getGoalId().intValue()
				 && oms1.getGoalType().equals(oms2.getGoalType())) {
					oms1.setProfit(oms1.getProfit().doubleValue() - oms2.getMatlAmount());
				}
			}
		}
		
		for (ReportHisOms oms : result) {
			if (oms.getProfit() == null) {
				oms.setGoalType(null);
				oms.setGoalId(null);
				oms.setGoalName(null);
				oms.setNum(null);
				oms.setPrice(null);
				oms.setAmount(null);
			}
		}
		return result;
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
	
	 @Override
    public List<ReportHisOms> getDeptIncome(PageInfo pageInfo) {
		Map<String, Double> mealTimesMap = new HashMap<String, Double>();
		Map<String, Double> ovenMap = new HashMap<String, Double>();
        List<ReportHisOms> list = reportMapper.getDeptIncome(pageInfo);
//        List<DietMealTimes> mealTimesList = dietMealTimesMapper.findDataByCafeteriaId((int)pageInfo.getCondition().get("cafeteriaId"));
//        List<OvenIndexVo> ovenList = ovenMapper.findOvenIndexVo((int)pageInfo.getCondition().get("cafeteriaId"));
        for (ReportHisOms hisOms : list){
        	//将订单信息按餐次+病区分类
			Double mealAmount = mealTimesMap.get(hisOms.getWardName() + "_" +  hisOms.getMealName());
			if (mealAmount == null) {
				mealTimesMap.put(hisOms.getWardName() + "_" +  hisOms.getMealName(), hisOms.getAmount());
			} else {
				Double amount = hisOms.getAmount().doubleValue() + mealAmount.doubleValue();
				mealTimesMap.put(hisOms.getWardName() + "_" + hisOms.getMealName(), amount);
			}
			
			//将订单信息按灶类+病区分类
			Double ovenAmount = ovenMap.get(hisOms.getWardName() + "_" + hisOms.getOvenName());
			if (ovenAmount == null) {
				ovenMap.put(hisOms.getWardName() + "_" + hisOms.getOvenName(), hisOms.getAmount());
			} else {
				Double amount = hisOms.getAmount().doubleValue() + ovenAmount.doubleValue();
				ovenMap.put(hisOms.getWardName() + "_" + hisOms.getOvenName(), amount);
			}
        }
        
        //将餐次+病区信息解析成主子关系
        List<ReportHisOms> reportHisOmsList = new ArrayList<>();
        for (String key : mealTimesMap.keySet()) {
        	int count = 0;
        	String newKey = key.split("_")[0];
        	for (ReportHisOms oms : reportHisOmsList) {
        		if (newKey.equals(oms.getWardName())) {
        			count = 1;
        			oms.setAmount(oms.getAmount().doubleValue() + mealTimesMap.get(key).doubleValue());
        			oms.getMealMap().put(key.split("_")[1], mealTimesMap.get(key));
        		}
        	}
        	
        	if (count == 0) {
        		ReportHisOms oms = new ReportHisOms();
        		oms.setWardName(newKey);
        		oms.setAmount(mealTimesMap.get(key));
        		oms.getMealMap().put(key.split("_")[1], mealTimesMap.get(key));
        		reportHisOmsList.add(oms);
        	}
        }
        
        //将灶类+病区信息解析到餐次+病区信息的解析结果中
        for (String key : ovenMap.keySet()) {
        	String newKey = key.split("_")[0];
        	for (ReportHisOms oms : reportHisOmsList) {
        		if (newKey.equals(oms.getWardName())) {
        			oms.getOvenMap().put(key.split("_")[1], ovenMap.get(key));
        		}
        	}
        }
        
        for (ReportHisOms oms : reportHisOmsList)  {
        	for (String mealName : oms.getMealMap().keySet()) {
        		oms.getMealNameList().add(mealName);
        		oms.getMealValueList().add(oms.getMealMap().get(mealName));
        	}
        	for (String ovenName : oms.getOvenMap().keySet()) {
        		oms.getOvenNameList().add(ovenName);
        		oms.getOvenValueList().add(oms.getOvenMap().get(ovenName));
        	}
        }
        return reportHisOmsList;
    }
	 
	 @Override
    public List<ReportHisOms> getOvenRecords(PageInfo pageInfo) {
	 Map<String, Double> map = new HashMap<String, Double>();
        List<ReportHisOms> list = reportMapper.getOvenRecords(pageInfo);
        for (ReportHisOms hisOms : list){
        	//将订单信息按病区+(餐次+灶类+菜名)分类
			Double mealNum = map.get(hisOms.getWardName() + "_" +  hisOms.getMealName() + "=" +  hisOms.getOvenName() + "=" + hisOms.getGoalName());
			if (mealNum == null) {
				map.put(hisOms.getWardName() + "_" +  hisOms.getMealName() + "=" +  hisOms.getOvenName() + "=" + hisOms.getGoalName(), hisOms.getNum());
			} else {
				Double num = hisOms.getNum().doubleValue() + mealNum.doubleValue();
				map.put(hisOms.getWardName() + "_" +  hisOms.getMealName() + "=" +  hisOms.getOvenName() + "=" + hisOms.getGoalName(), num);
			}
        }
        
        //将订单信息按病区+(餐次+灶类+菜名)信息解析成主子关系
        List<ReportHisOms> reportHisOmsList = new ArrayList<>();
        for (String key : map.keySet()) {
        	int count = 0;
        	String newKey = key.split("_")[1];
        	for (ReportHisOms oms : reportHisOmsList) {
        		if (newKey.equals(oms.getMealName() + "=" +  oms.getOvenName() + "=" + oms.getGoalName())) {
        			count = 1;
        			oms.setNum(oms.getNum().doubleValue() + map.get(key).doubleValue());
        			oms.getWardMap().put(key.split("_")[0], map.get(key));
        		}
        	}
        	
        	if (count == 0) {
        		ReportHisOms oms = new ReportHisOms();
        		oms.setMealName(newKey.split("=")[0]);
        		oms.setOvenName(newKey.split("=")[1]);
        		oms.setGoalName(newKey.split("=")[2]);
        		oms.setNum(map.get(key));
        		oms.getWardMap().put(key.split("_")[0], map.get(key));
        		reportHisOmsList.add(oms);
        	}
        }
        
        for (ReportHisOms oms : reportHisOmsList)  {
        	for (String wardName : oms.getWardMap().keySet()) {
        		oms.getWardNameList().add(wardName);
        		oms.getWardValueList().add(oms.getWardMap().get(wardName));
        	}
        }
        return reportHisOmsList;
    }
}
