package com.tenghong.ndip.mapper.his;

import java.util.List;

import com.tenghong.ndip.model.his.ReportHisOms;
import com.tenghong.ndip.utils.PageInfo;

public interface ReportMapper {
    
    List<ReportHisOms> getUseMeals(PageInfo pageInfo);

	int findUseMealCount(PageInfo pageInfo);

}