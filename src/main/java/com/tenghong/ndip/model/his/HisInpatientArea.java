package com.tenghong.ndip.model.his;

import com.tenghong.ndip.model.dto.ImageDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * his_inpatient_area
 * @author 
 */
public class HisInpatientArea implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 病区code
     */
    private String wardCode;

    /**
     * 病区名称
     */
    private String wardName;

    private String wardPic;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String memo;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    /**
     * 0 删除 1存在
     */
    private Integer status;

    private List<ImageDto> wardPicVo;

    private static final long serialVersionUID = 1L;

    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public List<ImageDto> getWardPicVo() {
        return wardPicVo;
    }

    public void setWardPicVo(List<ImageDto> wardPicVo) {
        this.wardPicVo = wardPicVo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getWardPic() {
        return wardPic;
    }

    public void setWardPic(String wardPic) {
        this.wardPic = wardPic;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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