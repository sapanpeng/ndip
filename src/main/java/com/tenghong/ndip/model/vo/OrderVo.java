package com.tenghong.ndip.model.vo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 0:18 2018/6/21
 */
public class OrderVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderCode;

    private String orderName;

    private String orderClassCode;

    private String orderClassName;

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
}
