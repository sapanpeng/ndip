package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.DietOvenType;
import com.tenghong.ndip.utils.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DietOvenTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DietOvenType record);

    int insertSelective(DietOvenType record);

    DietOvenType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DietOvenType record);

    int updateByPrimaryKey(DietOvenType record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<DietOvenType> findPageCondition(PageInfo pageInfo);

    List<DietOvenType> findDataByIdList(@Param("list") List<Integer> list);
}