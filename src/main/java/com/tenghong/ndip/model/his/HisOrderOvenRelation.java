package com.tenghong.ndip.model.his;

import java.io.Serializable;

/**
 * his_order_oven_relation
 * @author 
 */
public class HisOrderOvenRelation implements Serializable {
    private Integer id;

    private String orderName;

    private String orderCode;

    private String memo;

    private String ovenName;

    private Integer ovenId;

    private String ovenTypeName;

    private Integer ovenTypeId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOvenName() {
        return ovenName;
    }

    public void setOvenName(String ovenName) {
        this.ovenName = ovenName;
    }

    public Integer getOvenId() {
        return ovenId;
    }

    public void setOvenId(Integer ovenId) {
        this.ovenId = ovenId;
    }

    public String getOvenTypeName() {
        return ovenTypeName;
    }

    public void setOvenTypeName(String ovenTypeName) {
        this.ovenTypeName = ovenTypeName;
    }

    public Integer getOvenTypeId() {
        return ovenTypeId;
    }

    public void setOvenTypeId(Integer ovenTypeId) {
        this.ovenTypeId = ovenTypeId;
    }
}