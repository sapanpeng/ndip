package com.tenghong.ndip.model.his;

import java.io.Serializable;

/**
 * his_oms_details
 * @author 
 */
public class HisOmsDetailsEntity implements Serializable {
    private Integer id;

    /**
     * 订单id
     */
    private Integer omsId;

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

    private static final long serialVersionUID = 1L;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HisOmsDetailsEntity other = (HisOmsDetailsEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOmsId() == null ? other.getOmsId() == null : this.getOmsId().equals(other.getOmsId()))
            && (this.getMealId() == null ? other.getMealId() == null : this.getMealId().equals(other.getMealId()))
            && (this.getMealName() == null ? other.getMealName() == null : this.getMealName().equals(other.getMealName()))
            && (this.getCurrentPrice() == null ? other.getCurrentPrice() == null : this.getCurrentPrice().equals(other.getCurrentPrice()))
            && (this.getOvenId() == null ? other.getOvenId() == null : this.getOvenId().equals(other.getOvenId()))
            && (this.getOvenName() == null ? other.getOvenName() == null : this.getOvenName().equals(other.getOvenName()))
            && (this.getGoalId() == null ? other.getGoalId() == null : this.getGoalId().equals(other.getGoalId()))
            && (this.getGoalName() == null ? other.getGoalName() == null : this.getGoalName().equals(other.getGoalName()))
            && (this.getGoalPrice() == null ? other.getGoalPrice() == null : this.getGoalPrice().equals(other.getGoalPrice()))
            && (this.getGoalNum() == null ? other.getGoalNum() == null : this.getGoalNum().equals(other.getGoalNum()))
            && (this.getGoalType() == null ? other.getGoalType() == null : this.getGoalType().equals(other.getGoalType()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOmsId() == null) ? 0 : getOmsId().hashCode());
        result = prime * result + ((getMealId() == null) ? 0 : getMealId().hashCode());
        result = prime * result + ((getMealName() == null) ? 0 : getMealName().hashCode());
        result = prime * result + ((getCurrentPrice() == null) ? 0 : getCurrentPrice().hashCode());
        result = prime * result + ((getOvenId() == null) ? 0 : getOvenId().hashCode());
        result = prime * result + ((getOvenName() == null) ? 0 : getOvenName().hashCode());
        result = prime * result + ((getGoalId() == null) ? 0 : getGoalId().hashCode());
        result = prime * result + ((getGoalName() == null) ? 0 : getGoalName().hashCode());
        result = prime * result + ((getGoalPrice() == null) ? 0 : getGoalPrice().hashCode());
        result = prime * result + ((getGoalNum() == null) ? 0 : getGoalNum().hashCode());
        result = prime * result + ((getGoalType() == null) ? 0 : getGoalType().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", omsId=").append(omsId);
        sb.append(", mealId=").append(mealId);
        sb.append(", mealName=").append(mealName);
        sb.append(", currentPrice=").append(currentPrice);
        sb.append(", ovenId=").append(ovenId);
        sb.append(", ovenName=").append(ovenName);
        sb.append(", goalId=").append(goalId);
        sb.append(", goalName=").append(goalName);
        sb.append(", goalPrice=").append(goalPrice);
        sb.append(", goalNum=").append(goalNum);
        sb.append(", goalType=").append(goalType);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}