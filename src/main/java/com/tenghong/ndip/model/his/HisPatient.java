package com.tenghong.ndip.model.his;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * his_patient
 * @author 
 */
public class HisPatient implements Serializable {
    private Integer id;

    /**
     * HIS系统病人标识
     */
    private String patientId;

    /**
     * 住院号
     */
    private String inpNo;

    /**
     * 科室编号
     */
    private String deptCode;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 病区编号
     */
    private String wardCode;

    /**
     * 病区名称
     */
    private String wardName;

    /**
     * 床号
     */
    private String bedNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 参考数据  男 女
     */
    private String sex;

    private Date birthday;

    private Integer ageOfYear;

    private Integer ageOfMonth;

    private String height;

    private String weight;

    private String mobilePhone;

    private String address;

    /**
     * 身份证号
     */
    private String idNo;

    /**
     * 0-标准价格 1-优惠价格 2-外宾价格
     */
    private Integer chargeType;

    /**
     * 预交金余额
     */
    private Double balance;

    /**
     * 入院时间
     */
    private Date inHosDate;

    /**
     * 出院时间
     */
    private Date outHosDate;

    /**
     * 诊断备注
     */
    private String diagnosis;

    /**
     * 0 否 1是  出院结算标识
     */
    private Integer settledIndicator;

    /**
     * 病人出院情况
     */
    private String outStatus;

    private Double totalWallet;

    private Integer flag;

    private Date diningDate;

    private String orderName;

    private Integer ovenId;

    private List<Integer> cafeteriaList;

    private List<HisOmsDetails> detailsList;

    private Integer newPatient;

    private static final long serialVersionUID = 1L;

    public Integer getNewPatient() {
        return newPatient;
    }

    public void setNewPatient(Integer newPatient) {
        this.newPatient = newPatient;
    }

    public Integer getOvenId() {
        return ovenId;
    }

    public void setOvenId(Integer ovenId) {
        this.ovenId = ovenId;
    }

    public List<HisOmsDetails> getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(List<HisOmsDetails> detailsList) {
        this.detailsList = detailsList;
    }

    public List<Integer> getCafeteriaList() {
        return cafeteriaList;
    }

    public void setCafeteriaList(List<Integer> cafeteriaList) {
        this.cafeteriaList = cafeteriaList;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Double getTotalWallet() {
        return totalWallet;
    }

    public void setTotalWallet(Double totalWallet) {
        this.totalWallet = totalWallet;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getDiningDate() {
        return diningDate;
    }

    public void setDiningDate(Date diningDate) {
        this.diningDate = diningDate;
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

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAgeOfYear() {
        return ageOfYear;
    }

    public void setAgeOfYear(Integer ageOfYear) {
        this.ageOfYear = ageOfYear;
    }

    public Integer getAgeOfMonth() {
        return ageOfMonth;
    }

    public void setAgeOfMonth(Integer ageOfMonth) {
        this.ageOfMonth = ageOfMonth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getInHosDate() {
        return inHosDate;
    }

    public void setInHosDate(Date inHosDate) {
        this.inHosDate = inHosDate;
    }

    public Date getOutHosDate() {
        return outHosDate;
    }

    public void setOutHosDate(Date outHosDate) {
        this.outHosDate = outHosDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Integer getSettledIndicator() {
        return settledIndicator;
    }

    public void setSettledIndicator(Integer settledIndicator) {
        this.settledIndicator = settledIndicator;
    }

    public String getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(String outStatus) {
        this.outStatus = outStatus;
    }
}