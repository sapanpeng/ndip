package com.tenghong.ndip.mapper.sys;

import com.tenghong.ndip.model.sys.SysOvenSchedual;

public interface SysOvenSchedualMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOvenSchedual record);

    int insertSelective(SysOvenSchedual record);

    SysOvenSchedual selectByPrimaryKey(Integer id);

    SysOvenSchedual selectByKey(String key);

    int updateByPrimaryKeySelective(SysOvenSchedual record);

    int updateByPrimaryKey(SysOvenSchedual record);
}