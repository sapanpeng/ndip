package com.tenghong.ndip.service.his;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tenghong.ndip.model.his.ReportHisOms;
import com.tenghong.ndip.utils.PageInfo;

/**
 * Created by .
 *
 * @Author: 
 * @Description:
 * @Date: 
 */
public interface ReportService {

	//获取订餐情况
	void getUseMeals(PageInfo pageInfo);
	
	//获取送餐情况
	void getSendMeals(PageInfo pageInfo);

	//获取灶类统计
	List<ReportHisOms> getOvenStat(String diningTime, Integer cafeteriaId, List<String> ovenIdList);
	
	//获取灶类统计
	List<ReportHisOms> getConsumptionStat(String diningTime, Integer cafeteriaId, 
			List<String> mealIdList,String deptCode, Integer wardId);
	

	//获取病区金额汇总
	List<ReportHisOms> getWardAmountStat(String diningTimeBegin, String diningTimeEnd,Integer cafeteriaId, 
			List<String> mealIdList,String deptCode, Integer wardId);
	
	//订餐信息查询
    void getOrderInformation(PageInfo pageInfo);
    
    //成本核算表（参考价）
  	List<ReportHisOms> getCost(String diningTime, Integer cafeteriaId, 
  				List<String> mealIdList,String deptCode, Integer wardId);
  	
  //原材料统计
  	List<ReportHisOms> getFoodStat(String diningTimeBegin, String diningTimeEnd,Integer cafeteriaId, String ovenCode);

  	//原材料明细统计
  	List<ReportHisOms> getFoodDetailStat(String diningTimeBegin, String diningTimeEnd,Integer cafeteriaId, String ovenCode);

  	//原材料采购清单
  	List<ReportHisOms> getFoodPurchaseStat(String diningTimeBegin, String diningTimeEnd,Integer cafeteriaId, String ovenCode);

}
