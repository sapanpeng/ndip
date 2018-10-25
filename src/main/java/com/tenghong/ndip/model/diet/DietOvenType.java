package com.tenghong.ndip.model.diet;

import com.tenghong.ndip.model.dto.ImageDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * diet_oven_type
 * @author 
 */
public class DietOvenType implements Serializable {
    private Integer id;

    /**
     * 灶类类别名称
     */
    private String ovenTypeName;

    /**
     * 灶类图片
     */
    private String ovenTypePic;

    /**
     * 描述
     */
    private String memo;

    /**
     * 排序
     */
    private Integer sort;

    private Integer cafeteriaId;

    /**
     * 食堂名称
     */
    private String cafeteriaName;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private List<ImageDto> ovenTypePicVo;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ImageDto> getOvenTypePicVo() {
        return ovenTypePicVo;
    }

    public void setOvenTypePicVo(List<ImageDto> ovenTypePicVo) {
        this.ovenTypePicVo = ovenTypePicVo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOvenTypeName() {
        return ovenTypeName;
    }

    public void setOvenTypeName(String ovenTypeName) {
        this.ovenTypeName = ovenTypeName;
    }

    public String getOvenTypePic() {
        return ovenTypePic;
    }

    public void setOvenTypePic(String ovenTypePic) {
        this.ovenTypePic = ovenTypePic;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
}