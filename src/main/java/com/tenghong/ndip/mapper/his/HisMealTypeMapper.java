package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisMealType;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

public interface HisMealTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisMealType record);

    int insertSelective(HisMealType record);

    HisMealType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisMealType record);

    int updateByPrimaryKey(HisMealType record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<HisMealType> findPageCondition(PageInfo pageInfo);
}