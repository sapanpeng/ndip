package com.tenghong.ndip.mapper.sys;

import com.tenghong.ndip.model.sys.SysResourcesPkg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysResourcesPkgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysResourcesPkg record);

    int insertSelective(SysResourcesPkg record);

    SysResourcesPkg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysResourcesPkg record);

    int updateByPrimaryKey(SysResourcesPkg record);

    //保存权限
    void  insertPlus(@Param("list") List<SysResourcesPkg> list);
}