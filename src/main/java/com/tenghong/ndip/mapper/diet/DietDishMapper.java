package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.DietDish;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

public interface DietDishMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DietDish record);

    int insertSelective(DietDish record);

    DietDish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DietDish record);

    int updateByPrimaryKey(DietDish record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<DietDish> findPageCondition(PageInfo pageInfo);

    //查询详情
    DietDish getInfo(Integer id);
}