package com.tenghong.ndip.mapper.his;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tenghong.ndip.model.his.ReportHisOms;
import com.tenghong.ndip.model.vo.OrderInformationVo;
import com.tenghong.ndip.utils.PageInfo;

public interface ReportMapper {
    
	//用餐表报表列表
    List<ReportHisOms> getUseMeals(PageInfo pageInfo);

    //用餐表报表分页
	int findUseMealCount(PageInfo pageInfo);

	//送餐表报表列表
	List<ReportHisOms> getSendMeals(PageInfo pageInfo);

	//送餐表报表分页
	int findSendMealCount(PageInfo pageInfo);

	//查询灶类统计表信息
	List<ReportHisOms> getOvenStat(@Param("diningTime")String diningTime, @Param("cafeteriaId")Integer cafeteriaId, @Param("list")List<String> ovenIdList);
	
	//查询今日消费明细表
	List<ReportHisOms> getConsumptionStat(@Param("diningTime")String diningTime, @Param("cafeteriaId")Integer cafeteriaId, 
			@Param("list")List<String> mealIdList,@Param("deptCode")String deptCode, @Param("wardId")Integer wardId);
	
	//查询今日消费明细表
	List<ReportHisOms> getWardAmountStat(@Param("diningTimeBegin")String diningTimeBegin, 
			@Param("diningTimeEnd")String diningTimeEnd,@Param("cafeteriaId")Integer cafeteriaId, 
				@Param("list")List<String> mealIdList,@Param("deptCode")String deptCode, @Param("wardId")Integer wardId);
	
	 //订单信息查询（报表）
    List<OrderInformationVo> selectOrderInformation(PageInfo pageInfo);
    
    //订单信息查询（报表）
    Integer selectOrderInformationCount(PageInfo pageInfo);
    
    //成本核算表（参考价）
  	List<ReportHisOms> getCost(@Param("diningTime")String diningTime, @Param("cafeteriaId")Integer cafeteriaId, 
  				@Param("list")List<String> mealIdList,@Param("deptCode")String deptCode, @Param("wardId")Integer wardId);
  	
  	//原材料统计
  	List<ReportHisOms> getFoodStat(@Param("diningTimeBegin")String diningTimeBegin,
  										 @Param("diningTimeEnd")String diningTimeEnd,@Param("cafeteriaId")Integer cafeteriaId, @Param("ovenCode")String ovenCode);

  	//原材料明细统计
  	List<ReportHisOms> getFoodDetailStat(@Param("diningTimeBegin")String diningTimeBegin,
  								   @Param("diningTimeEnd")String diningTimeEnd,@Param("cafeteriaId")Integer cafeteriaId, @Param("ovenCode")String ovenCode);

  	//原材料采购清单
  	List<ReportHisOms> getFoodPurchaseStat(@Param("diningTimeBegin")String diningTimeBegin,
  								   @Param("diningTimeEnd")String diningTimeEnd,@Param("cafeteriaId")Integer cafeteriaId, @Param("ovenCode")String ovenCode);

}