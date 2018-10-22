package com.tenghong.ndip.model.his;

import com.tenghong.ndip.model.diet.DietElement;

import java.io.Serializable;
import java.util.Date;

/**
 * his_oms_details
 * @author 
 */
public class HisOmsDetails implements Serializable {
    private Integer id;

    /**
     * 订单id
     */
    private Integer omsId;

    private Integer omsType;

    private Integer mealId;

    /**
     * 餐次名称
     */
    private String mealName;

    /**
     * 当前金额
     */
    private Double currentPrice;

    /**
     * 灶类id
     */
    private Integer ovenId;

    /**
     * 灶类名称
     */
    private String ovenName;

    private Integer goalId;

    private String goalName;

    /**
     * 单个金额
     */
    private Double goalPrice;

    /**
     * 目标数量
     */
    private Integer goalNum;

    /**
     * 2菜谱  3套餐
     */
    private Integer goalType;

    /**
     * 备注
     */
    private String memo;

    private DietElement element;

    private Integer hour;

    private Integer minute;

    private String expTime;

    private Date diningTime;

    private static final long serialVersionUID = 1L;

    public Integer getOmsType() {
        return omsType;
    }

    public void setOmsType(Integer omsType) {
        this.omsType = omsType;
    }

    public Date getDiningTime() {
        return diningTime;
    }

    public void setDiningTime(Date diningTime) {
        this.diningTime = diningTime;
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

    public String getExpTime() {
        return expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }

    public DietElement getElement() {
        return element;
    }

    public void setElement(DietElement element) {
        this.element = element;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOmsId() {
        return omsId;
    }

    public void setOmsId(Integer omsId) {
        this.omsId = omsId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getOvenId() {
        return ovenId;
    }

    public void setOvenId(Integer ovenId) {
        this.ovenId = ovenId;
    }

    public String getOvenName() {
        return ovenName;
    }

    public void setOvenName(String ovenName) {
        this.ovenName = ovenName;
    }

    public Integer getGoalId() {
        return goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Double getGoalPrice() {
        return goalPrice;
    }

    public void setGoalPrice(Double goalPrice) {
        this.goalPrice = goalPrice;
    }

    public Integer getGoalNum() {
        return goalNum;
    }

    public void setGoalNum(Integer goalNum) {
        this.goalNum = goalNum;
    }

    public Integer getGoalType() {
        return goalType;
    }

    public void setGoalType(Integer goalType) {
        this.goalType = goalType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}