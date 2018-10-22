package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisOmsStatus;

public interface HisOmsStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisOmsStatus record);

    int insertSelective(HisOmsStatus record);

    HisOmsStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisOmsStatus record);

    int updateByPrimaryKey(HisOmsStatus record);
}