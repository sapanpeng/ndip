package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.dto.CafeteriaIndexDto;
import com.tenghong.ndip.model.his.HisCafeteria;
import com.tenghong.ndip.utils.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HisCafeteriaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisCafeteria record);

    int insertSelective(HisCafeteria record);

    HisCafeteria selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisCafeteria record);

    int updateByPrimaryKey(HisCafeteria record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<HisCafeteria> findPageCondition(PageInfo pageInfo);

    List<HisCafeteria> findDataByIdList(@Param("list") List<Integer> list);

    List<CafeteriaIndexDto> findTurnover();
}