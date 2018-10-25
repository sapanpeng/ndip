package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.DietRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DietRelationMapper {
    int deleteByPrimaryKey(Integer relationId);

    int insert(DietRelation record);

    int insertSelective(DietRelation record);

    DietRelation selectByPrimaryKey(Integer relationId);

    List<DietRelation> selectByParentKey(@Param("parentId") Integer parentId, @Param("parentType") Integer parentType);

    int updateByPrimaryKeySelective(DietRelation record);

    int updateByPrimaryKey(DietRelation record);

    //delete
    int delete(@Param("parentId") Integer parentId, @Param("parentType") Integer parentType);

    int getMenuId(@Param("reGoalId") Integer reGoalId, @Param("reGoalType") Integer reGoalType);
}