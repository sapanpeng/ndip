package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.DietMealTimes;
import com.tenghong.ndip.utils.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DietMealTimesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DietMealTimes record);

    int insertSelective(DietMealTimes record);

    DietMealTimes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DietMealTimes record);

    int updateByPrimaryKey(DietMealTimes record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<DietMealTimes> findPageCondition(PageInfo pageInfo);

    List<DietMealTimes> findDataByIdList(@Param("list") List<Integer> list);

    List<DietMealTimes> findDataByCafeteriaId(Integer cafeteriaId);

    List<DietMealTimes> findDataByReq(@Param("cafeteriaId") Integer cafeteriaId,@Param("mealId") Integer mealId);

    List<DietMealTimes> findDataByCafeteriaIdAndDate(@Param("cafeteriaId") Integer cafeteriaId,@Param("date") String date);
}