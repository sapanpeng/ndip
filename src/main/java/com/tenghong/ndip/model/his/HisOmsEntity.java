package com.tenghong.ndip.model.his;

import java.io.Serializable;
import java.util.Date;

/**
 * his_oms
 * @author 
 */
public class HisOmsEntity implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    private Integer patientId;

    /**
     * 餐次id
     */
    private Integer mealId;

    /**
     * 餐次名称
     */
    private String mealName;

    /**
     * 病区id
     */
    private Integer wardId;

    /**
     * 病区名称
     */
    private String wardName;

    /**
     * 订单金额
     */
    private Double price;

    /**
     * 食堂id
     */
    private Integer cafeteriaId;

    /**
     * 食堂名称
     */
    private String cafeteriaName;

    /**
     * 订单状态      1待支付  2已支付  3已退款
     */
    private Integer omsType;

    /**
     * 订餐员id
     */
    private Integer userId;

    /**
     * 送餐员姓名
     */
    private String userName;

    /**
     * 用餐时间
     */
    private Date diningTime;

    /**
     * 创建订单时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 更新时间
     */
    private Integer updateBy;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCafeteriaId() {
        return cafeteriaId;
    }

    public void setCafeteriaId(Integer cafeteriaId) {
        this.cafeteriaId = cafeteriaId;
    }

    public String getCafeteriaName() {
        return cafeteriaName;
    }

    public void setCafeteriaName(String cafeteriaName) {
        this.cafeteriaName = cafeteriaName;
    }

    public Integer getOmsType() {
        return omsType;
    }

    public void setOmsType(Integer omsType) {
        this.omsType = omsType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDiningTime() {
        return diningTime;
    }

    public void setDiningTime(Date diningTime) {
        this.diningTime = diningTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
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
        HisOmsEntity other = (HisOmsEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getMealId() == null ? other.getMealId() == null : this.getMealId().equals(other.getMealId()))
            && (this.getMealName() == null ? other.getMealName() == null : this.getMealName().equals(other.getMealName()))
            && (this.getWardId() == null ? other.getWardId() == null : this.getWardId().equals(other.getWardId()))
            && (this.getWardName() == null ? other.getWardName() == null : this.getWardName().equals(other.getWardName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCafeteriaId() == null ? other.getCafeteriaId() == null : this.getCafeteriaId().equals(other.getCafeteriaId()))
            && (this.getCafeteriaName() == null ? other.getCafeteriaName() == null : this.getCafeteriaName().equals(other.getCafeteriaName()))
            && (this.getOmsType() == null ? other.getOmsType() == null : this.getOmsType().equals(other.getOmsType()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getDiningTime() == null ? other.getDiningTime() == null : this.getDiningTime().equals(other.getDiningTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getMealId() == null) ? 0 : getMealId().hashCode());
        result = prime * result + ((getMealName() == null) ? 0 : getMealName().hashCode());
        result = prime * result + ((getWardId() == null) ? 0 : getWardId().hashCode());
        result = prime * result + ((getWardName() == null) ? 0 : getWardName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCafeteriaId() == null) ? 0 : getCafeteriaId().hashCode());
        result = prime * result + ((getCafeteriaName() == null) ? 0 : getCafeteriaName().hashCode());
        result = prime * result + ((getOmsType() == null) ? 0 : getOmsType().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getDiningTime() == null) ? 0 : getDiningTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", patientId=").append(patientId);
        sb.append(", mealId=").append(mealId);
        sb.append(", mealName=").append(mealName);
        sb.append(", wardId=").append(wardId);
        sb.append(", wardName=").append(wardName);
        sb.append(", price=").append(price);
        sb.append(", cafeteriaId=").append(cafeteriaId);
        sb.append(", cafeteriaName=").append(cafeteriaName);
        sb.append(", omsType=").append(omsType);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", diningTime=").append(diningTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}