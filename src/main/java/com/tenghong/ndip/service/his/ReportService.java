package com.tenghong.ndip.service.his;

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

}
