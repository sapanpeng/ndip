package com.tenghong.ndip.model.diet;

import java.io.Serializable;
import java.util.Date;

/**
 * diet_matl
 * @author 
 */
public class DietMatl implements Serializable {
    private Integer id;

    /**
     * 原材料名称
     */
    private String name;

    /**
     * 备注
     */
    private String memo;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 参考价格
     */
    private Double price;

    /**
     * 原材料类别id
     */
    private Integer typeId;

    /**
     * 等价食物id
     */
    private String standardId;

    /**
     * 等价食物名称
     */
    private String standardName;

    /**
     * 等价食物重量比
     */
    private Double standardWeight;

    /**
     * 0 删除  1存在
     */
    private Integer status;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private DietElement element;
    private static final long serialVersionUID = 1L;


    public DietElement getElement() {
        return element;
    }

    public void setElement(DietElement element) {
        this.element = element;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public Double getStandardWeight() {
        return standardWeight;
    }

    public void setStandardWeight(Double standardWeight) {
        this.standardWeight = standardWeight;
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
}