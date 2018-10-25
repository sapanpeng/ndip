package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.DietElement;
import org.apache.ibatis.annotations.Param;

public interface DietElementMapper {
    int deleteByPrimaryKey(Integer elementId);

    int insert(DietElement record);

    int insertSelective(DietElement record);

    DietElement selectByPrimaryKey(Integer elementId);

    int updateByPrimaryKeySelective(DietElement record);

    int updateByPrimaryKey(DietElement record);

    DietElement selectByCondition(@Param("goalId") Integer goalId,@Param("goalType") Integer goalType);
}