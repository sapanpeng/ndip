package com.tenghong.ndip.model.his;

import java.io.Serializable;

/**
 * his_patient_wallet
 * @author 
 */
public class HisPatientWallet implements Serializable {
    private Integer id;

    /**
     * 病人id
     */
    private String patientId;

    /**
     * 当前钱包余额
     */
    private Double totalWallet;

    /**
     * 历史消费   用户在膳食系统中充值的金额
     */
    private Double hisWallet;

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

    public Double getTotalWallet() {
        return totalWallet;
    }

    public void setTotalWallet(Double totalWallet) {
        this.totalWallet = totalWallet;
    }

    public Double getHisWallet() {
        return hisWallet;
    }

    public void setHisWallet(Double hisWallet) {
        this.hisWallet = hisWallet;
    }
}