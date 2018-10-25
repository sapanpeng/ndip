package com.tenghong.ndip.mapper.sys;

import com.tenghong.ndip.model.sys.SysResources;
import com.tenghong.ndip.model.sys.SysResourcesPkg;
import com.tenghong.ndip.model.vo.ResourcesVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysResourcesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysResources record);

    int insertSelective(SysResources record);

    SysResources selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysResources record);

    int updateByPrimaryKey(SysResources record);

    //查询父级菜单
    List<ResourcesVo> getParentTreeNode(@Param("userId") Integer userId);

    List<ResourcesVo> getChildrenNode(@Param("code") String code,@Param("userId") Integer userId);


}