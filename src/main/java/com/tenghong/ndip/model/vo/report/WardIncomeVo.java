package com.tenghong.ndip.model.vo.report;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:09 2018/7/19
 */
public class WardIncomeVo {

    private String wardName;

    private Integer wardId;

    private String wardCode;

    private Double finalSettlementAmount;

    private Double thisPeriodAmount;

    private Double thisPeriodSettlementAmount;

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public Double getFinalSettlementAmount() {
        return finalSettlementAmount;
    }

    public void setFinalSettlementAmount(Double finalSettlementAmount) {
        this.finalSettlementAmount = finalSettlementAmount;
    }

    public Double getThisPeriodAmount() {
        return thisPeriodAmount;
    }

    public void setThisPeriodAmount(Double thisPeriodAmount) {
        this.thisPeriodAmount = thisPeriodAmount;
    }

    public Double getThisPeriodSettlementAmount() {
        return thisPeriodSettlementAmount;
    }

    public void setThisPeriodSettlementAmount(Double thisPeriodSettlementAmount) {
        this.thisPeriodSettlementAmount = thisPeriodSettlementAmount;
    }
}
