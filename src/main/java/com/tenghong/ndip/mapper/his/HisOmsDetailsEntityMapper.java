package com.tenghong.ndip.mapper.his;

import com.tenghong.ndip.model.his.HisOmsDetailsEntity;
import com.tenghong.ndip.model.his.HisOmsDetailsEntityExample;
import com.tenghong.ndip.model.bo.ReceiveOrderBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HisOmsDetailsEntityMapper {
    long countByExample(HisOmsDetailsEntityExample example);

    int deleteByExample(HisOmsDetailsEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HisOmsDetailsEntity record);

    int insertSelective(HisOmsDetailsEntity record);

    List<HisOmsDetailsEntity> selectByExample(HisOmsDetailsEntityExample example);

    HisOmsDetailsEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HisOmsDetailsEntity record, @Param("example") HisOmsDetailsEntityExample example);

    int updateByExample(@Param("record") HisOmsDetailsEntity record, @Param("example") HisOmsDetailsEntityExample example);

    int updateByPrimaryKeySelective(HisOmsDetailsEntity record);

    int updateByPrimaryKey(HisOmsDetailsEntity record);

    List<ReceiveOrderBO> selectByGroup(Map map);
}