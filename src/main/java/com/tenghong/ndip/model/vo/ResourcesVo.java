package com.tenghong.ndip.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 18:12 2018/6/4
 */
public class ResourcesVo implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 菜单编号
     */
    private String code;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * url地址
     */
    private String url;

    /**
     * 菜单层级
     */
    private Integer levels;

    private List<ResourcesVo> children;


    /**
     * 0关闭  1打开
     */
    private Integer isOpen;

    private static final long serialVersionUID = 1L;

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public List<ResourcesVo> getChildren() {
        return children;
    }

    public void setChildren(List<ResourcesVo> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

}
