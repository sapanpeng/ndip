package com.tenghong.ndip.model.his;

import com.tenghong.ndip.model.dto.ImageDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * his_meal_type
 * @author 
 */
public class HisMealType implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 菜谱类别名称
     */
    private String mealTypeName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 菜谱类别图片
     */
    private String mealTypePic;

    private List<ImageDto> mealTypePicVo;

    /**
     * 备注
     */
    private String memo;

    /**
     * 食堂id
     */
    private Integer cafeteriaId;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    /**
     * 0 删除 1存在
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public List<ImageDto> getMealTypePicVo() {
        return mealTypePicVo;
    }

    public void setMealTypePicVo(List<ImageDto> mealTypePicVo) {
        this.mealTypePicVo = mealTypePicVo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMealTypeName() {
        return mealTypeName;
    }

    public void setMealTypeName(String mealTypeName) {
        this.mealTypeName = mealTypeName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getMealTypePic() {
        return mealTypePic;
    }

    public void setMealTypePic(String mealTypePic) {
        this.mealTypePic = mealTypePic;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getCafeteriaId() {
        return cafeteriaId;
    }

    public void setCafeteriaId(Integer cafeteriaId) {
        this.cafeteriaId = cafeteriaId;
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