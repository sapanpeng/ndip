package com.tenghong.ndip.model.his;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * his_oms
 * @author 
 */
public class HisOms implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    private String patientId;

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

    private String bedNo;

    private String inpNo;

    private String patientName;

    private String ovenName;
    
    private List<HisOmsDetails> hisOmsDetails;

    private static final long serialVersionUID = 1L;

    public String getOvenName() {
        return ovenName;
    }

    public void setOvenName(String ovenName) {
        this.ovenName = ovenName;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
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

	public List<HisOmsDetails> getHisOmsDetails() {
		if (hisOmsDetails == null) {
			hisOmsDetails = new ArrayList<HisOmsDetails>();
		}
		return hisOmsDetails;
	}

	public void setHisOmsDetails(List<HisOmsDetails> hisOmsDetails) {
		this.hisOmsDetails = hisOmsDetails;
	}
}