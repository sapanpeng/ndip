package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.DietMatlType;
import com.tenghong.ndip.model.diet.DietMealTimes;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

public interface DietMatlTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DietMatlType record);

    int insertSelective(DietMatlType record);

    DietMatlType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DietMatlType record);

    int updateByPrimaryKey(DietMatlType record);
}