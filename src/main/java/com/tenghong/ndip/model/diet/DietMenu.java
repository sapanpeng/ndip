package com.tenghong.ndip.model.diet;

import java.io.Serializable;
import java.util.Date;

/**
 * diet_menu
 * @author 
 */
public class DietMenu implements Serializable {
    private Integer id;

    /**
     * 灶类id
     */
    private Integer ovenId;

    /**
     * 餐次id
     */
    private Integer mealId;

    /**
     * 食堂id
     */
    private Integer cafeteriaId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 描述
     */
    private String memo;

    private Date menuTime;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    /**
     * 0 删除  1存在
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOvenId() {
        return ovenId;
    }

    public void setOvenId(Integer ovenId) {
        this.ovenId = ovenId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public Integer getCafeteriaId() {
        return cafeteriaId;
    }

    public void setCafeteriaId(Integer cafeteriaId) {
        this.cafeteriaId = cafeteriaId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getMenuTime() {
        return menuTime;
    }

    public void setMenuTime(Date menuTime) {
        this.menuTime = menuTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}