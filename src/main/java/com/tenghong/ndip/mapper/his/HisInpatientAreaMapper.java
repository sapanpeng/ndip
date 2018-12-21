package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisInpatientArea;
import com.tenghong.ndip.model.vo.WardIndexVo;
import com.tenghong.ndip.model.vo.report.WardDto;
import com.tenghong.ndip.utils.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HisInpatientAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisInpatientArea record);

    int insertSelective(HisInpatientArea record);

    HisInpatientArea selectByPrimaryKey(Integer id);

    HisInpatientArea selectByCode(String code);

    int updateByPrimaryKeySelective(HisInpatientArea record);

    int updateByPrimaryKey(HisInpatientArea record);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<HisInpatientArea> findPageCondition(PageInfo pageInfo);

    List<HisInpatientArea> findDataByIdList(@Param("list") List<Integer> list,@Param("userId") Integer userId);

    List<WardIndexVo> findTurnover();

    List<WardDto> findWardDto(@Param("cafeteriaId") Integer cafeteriaId);
    
    WardIndexVo findWardTurnover(@Param("cafeteriaId") Integer cafeteriaId, @Param("wardId") Integer wardId);
}