package com.tenghong.ndip.model.sys;

import java.io.Serializable;

/**
 * sys_oven_schedual
 * @author 
 */
public class SysOvenSchedual implements Serializable {
    private Integer id;

    /**
     * 餐次id
     */
    private String key;

    /**
     * 截止小时
     */
    private Integer expHour;

    /**
     * 截止分钟
     */
    private Integer expMin;

    /**
     * 截止时间
     */
    private String expTime;

    /**
     * 扣款时间
     */
    private String dedTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getExpHour() {
        return expHour;
    }

    public void setExpHour(Integer expHour) {
        this.expHour = expHour;
    }

    public Integer getExpMin() {
        return expMin;
    }

    public void setExpMin(Integer expMin) {
        this.expMin = expMin;
    }

    public String getExpTime() {
        return expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }

    public String getDedTime() {
        return dedTime;
    }

    public void setDedTime(String dedTime) {
        this.dedTime = dedTime;
    }
}