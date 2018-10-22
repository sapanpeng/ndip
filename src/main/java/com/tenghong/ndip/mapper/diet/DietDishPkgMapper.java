package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.DietDishPkg;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

public interface DietDishPkgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DietDishPkg record);

    int insertSelective(DietDishPkg record);

    DietDishPkg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DietDishPkg record);

    int updateByPrimaryKey(DietDishPkg record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<DietDishPkg> findPageCondition(PageInfo pageInfo);

    //查询详情
    DietDishPkg getInfo(Integer id);
}