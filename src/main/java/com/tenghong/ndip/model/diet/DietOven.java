package com.tenghong.ndip.model.diet;

import java.io.Serializable;
import java.util.Date;

/**
 * diet_oven
 * @author 
 */
public class DietOven implements Serializable {
    private Integer id;

    private String ovenCode;

    /**
     * 灶类名称
     */
    private String ovenName;

    private Integer ovenTypeId;

    /**
     * 1 包伙制  2 点餐制
     */
    private Integer feeType;

    /**
     * 是否共享  0否 1是
     */
    private Integer isPublic;

    /**
     * 是否治疗膳食  0否 1是
     */
    private Integer isTreatment;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 食堂id
     */
    private Integer cafeteriaId;

    /**
     * 食堂名称
     */
    private String cafeteriaName;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    /**
     * 0 删除 1存在
     */
    private Integer status;

    private String ovenTypeName;

    private static final long serialVersionUID = 1L;

    public String getOvenTypeName() {
        return ovenTypeName;
    }

    public void setOvenTypeName(String ovenTypeName) {
        this.ovenTypeName = ovenTypeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOvenCode() {
        return ovenCode;
    }

    public void setOvenCode(String ovenCode) {
        this.ovenCode = ovenCode;
    }

    public String getOvenName() {
        return ovenName;
    }

    public void setOvenName(String ovenName) {
        this.ovenName = ovenName;
    }

    public Integer getOvenTypeId() {
        return ovenTypeId;
    }

    public void setOvenTypeId(Integer ovenTypeId) {
        this.ovenTypeId = ovenTypeId;
    }

    public Integer getFeeType() {
        return feeType;
    }

    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getIsTreatment() {
        return isTreatment;
    }

    public void setIsTreatment(Integer isTreatment) {
        this.isTreatment = isTreatment;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCafeteriaId() {
        return cafeteriaId;
    }

    public void setCafeteriaId(Integer cafeteriaId) {
        this.cafeteriaId = cafeteriaId;
    }

    public String getCafeteriaName() {
        return cafeteriaName;
    }

    public void setCafeteriaName(String cafeteriaName) {
        this.cafeteriaName = cafeteriaName;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}