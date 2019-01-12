package com.tenghong.ndip.model.his;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ReportHisOms
 * @author 
 */
public class ReportHisOms implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 病人ID
	 */
    private String patientId;
    
    /**
     * 病人姓名
     */
    private String patientName;
    
    /**
     * 病人医嘱
     */
    private String orderName;
    
    /**
     * 病区id
     */
    private Integer wardId;

    /**
     * 病区名称
     */
    private String wardName;
    
    /**
     * 住院号
     */
    private String inpNo;

    /**
     * 床号
     */
    private String bedNo;
    
    /**
     * 食堂id
     */
    private Integer cafeteriaId;

    /**
     * 食堂名称
     */
    private String cafeteriaName;
    
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
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 创建人ID
     */
    private Integer createBy;
    
    /**
     * 创建人姓名
     */
    private String createByName;
    
    /**
     * 订单状态      1待支付  2已支付  3已退款
     */
    private Integer omsType;
    
    /**
     * 灶类ID
     */
    private Integer ovenId;
    
    /**
     * 灶类名称
     */
    private String ovenName;

    /**
     * 餐次id
     */
    private Integer mealId;

    /**
     * 餐次名称
     */
    private String mealName;
    
    /**
     * 2菜谱  3套餐
     */
    private Integer goalType;

    /**
     * 单价
     */
    private Double price;
    
    /**
     * 菜ID
     */
    private Integer goalId;
    
    /**
     * 单价
     */
    private String goalName;
    
    
    
    /**
     * 数量
     */
    private Double num;
    
    /**
     * 金额
     */
    private Double amount;
    
    /**
     * 上期金额
     */
    private Double lastAmount;
    
    /**
     * 总金额
     */
    private Double totalAmount;
    
    
    private List<ReportHisOms>  mealList;
    
    private List<ReportHisOms>  menuList;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
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

	public String getInpNo() {
		return inpNo;
	}

	public void setInpNo(String inpNo) {
		this.inpNo = inpNo;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
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

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}

	public Integer getOmsType() {
		return omsType;
	}

	public void setOmsType(Integer omsType) {
		this.omsType = omsType;
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

	public Integer getGoalType() {
		return goalType;
	}

	public void setGoalType(Integer goalType) {
		this.goalType = goalType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public Double getNum() {
		return num;
	}

	public void setNum(Double num) {
		this.num = num;
	}

	public Double getAmount() {
		return amount;
	}
	public Double getLastAmount() {
		return lastAmount;
	}

	public void setLastAmount(Double lastAmount) {
		this.lastAmount = lastAmount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<ReportHisOms> getMealList() {
		if (mealList  == null)
			mealList = new ArrayList<ReportHisOms>();
		return mealList;
	}

	public void setMealList(List<ReportHisOms> mealList) {
		this.mealList = mealList;
	}

	public List<ReportHisOms> getMenuList() {
		if (menuList  == null)
			menuList = new ArrayList<ReportHisOms>();
		return menuList;
	}

	public void setMenuList(List<ReportHisOms> menuList) {
		this.menuList = menuList;
	}
	
}