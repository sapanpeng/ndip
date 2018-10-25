package com.tenghong.ndip.model.his;

import com.tenghong.ndip.model.dto.ImageDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * his_cafeteria
 * @author 
 */
public class HisCafeteria implements Serializable {
    private Integer id;

    /**
     * 食堂code
     */
    private String cafeteriaCode;

    /**
     * 食堂名称
     */
    private String cafeteriaName;

    /**
     * 食堂图片
     */
    private String cafeteriaPic;

    private List<ImageDto> cafeteriaPicVo;

    /**
     * 食堂排序
     */
    private Integer sort;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ImageDto> getCafeteriaPicVo() {
        return cafeteriaPicVo;
    }

    public void setCafeteriaPicVo(List<ImageDto> cafeteriaPicVo) {
        this.cafeteriaPicVo = cafeteriaPicVo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCafeteriaCode() {
        return cafeteriaCode;
    }

    public void setCafeteriaCode(String cafeteriaCode) {
        this.cafeteriaCode = cafeteriaCode;
    }

    public String getCafeteriaName() {
        return cafeteriaName;
    }

    public void setCafeteriaName(String cafeteriaName) {
        this.cafeteriaName = cafeteriaName;
    }

    public String getCafeteriaPic() {
        return cafeteriaPic;
    }

    public void setCafeteriaPic(String cafeteriaPic) {
        this.cafeteriaPic = cafeteriaPic;
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
}