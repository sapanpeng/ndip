package com.tenghong.ndip.mapper.sys;

import com.tenghong.ndip.model.sys.SysUser;
import com.tenghong.ndip.utils.PageInfo;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    //根据用户token获得用户实体
    SysUser selectByToken(String userToken);

    //分页
    Integer findPageCount(PageInfo pageInfo);

    List<SysUser> findPageCondition(PageInfo pageInfo);
}