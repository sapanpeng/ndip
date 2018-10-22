package com.tenghong.ndip.model.sys;

import java.io.Serializable;

/**
 * sys_resources_pkg
 * @author 
 */
public class SysResourcesPkg implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 菜单id
     */
    private Integer resourcesId;

    /**
     * 用户id
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}