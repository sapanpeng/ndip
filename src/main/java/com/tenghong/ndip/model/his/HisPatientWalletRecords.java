package com.tenghong.ndip.model.his;

import java.io.Serializable;
import java.util.Date;

/**
 * his_patient_wallet_records
 * @author 
 */
public class HisPatientWalletRecords implements Serializable {
    private Integer id;

    private String patientId;

    /**
     * 当前记录金额
     */
    private Double currentAmount;

    /**
     * 金额变动状态  0 减少   1增加
     */
    private Integer flag;

    /**
     * 备注
     */
    private String memo;

    private Date createTime;

    /**
     * 增加金额的操作员id, 不记录消费金额的用户id
     */
    private Integer createBy;

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

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
}