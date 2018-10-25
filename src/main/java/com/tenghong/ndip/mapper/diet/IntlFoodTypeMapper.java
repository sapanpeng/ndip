package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.IntlFoodType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IntlFoodTypeMapper {

    //查询一级菜单
    List<IntlFoodType> selectParentType();

    //查询二级菜单
    List<IntlFoodType> selectChildType(@Param("pid") Integer pid);

}