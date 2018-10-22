package com.tenghong.ndip.model.vo;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 19:50 2018/7/18
 */
public class OvenIndexVo {

    private Integer ovenId;

    private String ovenName;

    private Integer bookNum;

    private Double bookFees;

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

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Double getBookFees() {
        return bookFees;
    }

    public void setBookFees(Double bookFees) {
        this.bookFees = bookFees;
    }
}
