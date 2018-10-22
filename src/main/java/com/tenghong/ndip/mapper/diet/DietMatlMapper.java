package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.DietMatl;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

public interface DietMatlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DietMatl record);

    int insertSelective(DietMatl record);

    DietMatl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DietMatl record);

    int updateByPrimaryKey(DietMatl record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<DietMatl> findPageCondition(PageInfo pageInfo);

    //查询原材料库实例
    DietMatl getInfo(Integer id);
}