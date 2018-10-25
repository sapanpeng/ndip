package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.DietMenu;
import com.tenghong.ndip.model.vo.MenuVo;
import com.tenghong.ndip.utils.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DietMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DietMenu record);

    int insertSelective(DietMenu record);

    DietMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DietMenu record);

    int updateByPrimaryKey(DietMenu record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<MenuVo> findPageCondition(PageInfo pageInfo);

    List<MenuVo> findPageConditionNew(PageInfo pageInfo);

    List<MenuVo> findDataByIdList(@Param("list") List<Integer> list,@Param("flag") Integer flag);

    //copy
    List<DietMenu> getCopyList(@Param("ovenId") List<Integer> ovenId,@Param("mealId") List<Integer> mealId,@Param("menuTime") Date menuTime);
}