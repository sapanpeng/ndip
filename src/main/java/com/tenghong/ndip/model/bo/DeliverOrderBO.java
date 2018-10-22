package com.tenghong.ndip.model.bo;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Created by Lewis on 2018/7/4.
 */
public class DeliverOrderBO implements Serializable {

    private String name;

    private String bedNo;

    private String hisNo;

    private String advice;

    private String ovenName;

    private Integer type;

    private Integer number;

    private String user;

    private String memo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getHisNo() {
        return hisNo;
    }

    public void setHisNo(String hisNo) {
        this.hisNo = hisNo;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getOvenName() {
        return ovenName;
    }

    public void setOvenName(String ovenName) {
        this.ovenName = ovenName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("bedNo", bedNo)
                .add("hisNo", hisNo)
                .add("advice", advice)
                .add("ovenName", ovenName)
                .add("type", type)
                .add("number", number)
                .add("user", user)
                .add("memo", memo)
                .toString();
    }
}
