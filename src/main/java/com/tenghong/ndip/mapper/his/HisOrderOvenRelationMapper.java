package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisOrderOvenRelation;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

public interface HisOrderOvenRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisOrderOvenRelation record);

    int insertSelective(HisOrderOvenRelation record);

    HisOrderOvenRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisOrderOvenRelation record);

    int updateByPrimaryKey(HisOrderOvenRelation record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<HisOrderOvenRelation> findPageCondition(PageInfo pageInfo);
}