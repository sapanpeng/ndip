package com.tenghong.ndip.model.diet;

import com.tenghong.ndip.model.dto.ImageDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * diet_dish
 * @author 
 */
public class DietDish implements Serializable {
    private Integer id;

    /**
     * 菜谱类别id
     */
    private Integer typeId;

    /**
     * 菜谱名称
     */
    private String name;

    /**
     * 单价
     */
    private Double price;

    /**
     * 控制价格
     */
    private Double cotlPrice;

    /**
     * 餐具名称
     */
    private String tbWareName;

    /**
     * 餐具数量
     */
    private Integer tbWareNum;

    /**
     * 菜谱图片
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private String typeName;

    /**
     * 0 删除  1存在
     */
    private Integer status;

    private DietElement element;

    private List<ImageDto> iconVo;

    private Integer cafeteriaId;

    private static final long serialVersionUID = 1L;

    public Integer getCafeteriaId() {
        return cafeteriaId;
    }

    public void setCafeteriaId(Integer cafeteriaId) {
        this.cafeteriaId = cafeteriaId;
    }

    public List<ImageDto> getIconVo() {
        return iconVo;
    }

    public void setIconVo(List<ImageDto> iconVo) {
        this.iconVo = iconVo;
    }

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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCotlPrice() {
        return cotlPrice;
    }

    public void setCotlPrice(Double cotlPrice) {
        this.cotlPrice = cotlPrice;
    }

    public String getTbWareName() {
        return tbWareName;
    }

    public void setTbWareName(String tbWareName) {
        this.tbWareName = tbWareName;
    }

    public Integer getTbWareNum() {
        return tbWareNum;
    }

    public void setTbWareNum(Integer tbWareNum) {
        this.tbWareNum = tbWareNum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}