package com.tenghong.ndip.mapper.diet;

import com.tenghong.ndip.model.diet.DietOven;
import com.tenghong.ndip.model.vo.OvenIndexVo;
import com.tenghong.ndip.utils.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DietOvenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DietOven record);

    int insertSelective(DietOven record);

    DietOven selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DietOven record);

    int updateByPrimaryKey(DietOven record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<DietOven> findPageCondition(PageInfo pageInfo);

    //根据类别查询
    List<DietOven> selectByTypeId(Integer id);

    List<DietOven> findDataByIdList(@Param("list") List<Integer> list);

    //根据食堂id查询灶类
    List<OvenIndexVo> findOvenIndexVo(@Param("cafeteriaId") Integer cafeteriaId);
}