package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisRelation;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

public interface HisRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisRelation record);

    int insertSelective(HisRelation record);

    HisRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisRelation record);

    int updateByPrimaryKey(HisRelation record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<HisRelation> findPageCondition(PageInfo pageInfo);
}