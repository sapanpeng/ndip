package com.tenghong.ndip.model.his;

import java.io.Serializable;
import java.util.Date;

/**
 * his_oms_status
 * @author 
 */
public class HisOmsStatus implements Serializable {
    private Integer id;

    private Integer orderId;

    /**
     * 订单状态
     */
    private Integer status;

    private Date createTime;

    /**
     * 创建人id  操作人  只记录工作人员id  user_id
     */
    private Integer createBy;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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