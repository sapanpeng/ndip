package com.tenghong.ndip.model.diet;

import com.tenghong.ndip.model.dto.ImageDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * diet_meal_times
 * @author 
 */
public class DietMealTimes implements Serializable {
    /**
     * 餐次id
     */
    private Integer id;

    /**
     * 餐次名称
     */
    private String mealTimeName;

    /**
     * 餐次图片
     */
    private String mealTimeIcon;

    private List<ImageDto> mealTimeIconVo;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 食堂id
     */
    private Integer cafeteriaId;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    /**
     * 0删除 1存在
     */
    private Integer status;

    private String expTime;

    private Integer hour;

    private Integer minute;

    private static final long serialVersionUID = 1L;

    public String getExpTime() {
        return expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public List<ImageDto> getMealTimeIconVo() {
        return mealTimeIconVo;
    }

    public void setMealTimeIconVo(List<ImageDto> mealTimeIconVo) {
        this.mealTimeIconVo = mealTimeIconVo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMealTimeName() {
        return mealTimeName;
    }

    public void setMealTimeName(String mealTimeName) {
        this.mealTimeName = mealTimeName;
    }

    public String getMealTimeIcon() {
        return mealTimeIcon;
    }

    public void setMealTimeIcon(String mealTimeIcon) {
        this.mealTimeIcon = mealTimeIcon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCafeteriaId() {
        return cafeteriaId;
    }

    public void setCafeteriaId(Integer cafeteriaId) {
        this.cafeteriaId = cafeteriaId;
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