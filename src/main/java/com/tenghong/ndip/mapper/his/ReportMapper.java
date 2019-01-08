package com.tenghong.ndip.mapper.his;

import java.util.List;

import com.tenghong.ndip.model.his.ReportHisOms;
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

}