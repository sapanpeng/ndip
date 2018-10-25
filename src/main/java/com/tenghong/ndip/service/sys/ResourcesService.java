package com.tenghong.ndip.service.sys;

import com.tenghong.ndip.model.vo.ResourcesVo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 17:16 2018/6/4
 */
public interface ResourcesService {
    //获取所有树
    List<ResourcesVo> list(Integer userId);

    //获取用户菜单id
    List<Integer> info(Integer userId);

    //清除用户所有权限树
    void delete(Integer userId);

    //添加用户权限
    void save(List<Integer> userList,List<Integer> resourcesList);



 }
