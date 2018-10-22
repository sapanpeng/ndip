package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisOmsEntity;
import com.tenghong.ndip.model.his.HisOmsEntityExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HisOmsEntityMapper {
    long countByExample(HisOmsEntityExample example);

    int deleteByExample(HisOmsEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HisOmsEntity record);

    int insertSelective(HisOmsEntity record);

    List<HisOmsEntity> selectByExample(HisOmsEntityExample example);

    HisOmsEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HisOmsEntity record, @Param("example") HisOmsEntityExample example);

    int updateByExample(@Param("record") HisOmsEntity record, @Param("example") HisOmsEntityExample example);

    int updateByPrimaryKeySelective(HisOmsEntity record);

    int updateByPrimaryKey(HisOmsEntity record);
}