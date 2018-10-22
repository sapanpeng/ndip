package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.IntlFood;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

public interface IntlFoodMapper {

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<IntlFood> findPageCondition(PageInfo pageInfo);

    IntlFood selectByPrimaryKey(String id);
}