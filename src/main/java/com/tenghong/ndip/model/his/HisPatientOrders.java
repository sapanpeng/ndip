package com.tenghong.ndip.model.his;

import java.io.Serializable;
import java.util.Date;

/**
 * his_patient_orders
 * @author 
 */
public class HisPatientOrders implements Serializable {
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
     * 医嘱开始时间
     */
    private Date startTime;

    /**
     * 医嘱结束时间
     */
    private Date endTime;

    /**
     * 医嘱类型code
     */
    private String orderClassCode;

    /**
     * 医嘱类型name
     */
    private String orderClassName;

    /**
     * 医嘱code
     */
    private String orderCode;

    /**
     * 医嘱name
     */
    private String orderName;

    /**
     * 病区code
     */
    private String wardCode;

    /**
     * 病区名称
     */
    private String wardName;

    private Integer isNew;

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    private static final long serialVersionUID = 1L;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOrderClassCode() {
        return orderClassCode;
    }

    public void setOrderClassCode(String orderClassCode) {
        this.orderClassCode = orderClassCode;
    }

    public String getOrderClassName() {
        return orderClassName;
    }

    public void setOrderClassName(String orderClassName) {
        this.orderClassName = orderClassName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
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
}