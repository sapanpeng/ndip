package com.tenghong.ndip.model.command;

import com.google.common.base.MoreObjects;
import com.tenghong.ndip.model.his.HisOmsDetails;
import com.tenghong.ndip.model.his.HisOmsEntity;

import java.io.Serializable;

public class OrderReportCommand extends HisOmsEntity implements Serializable {

    private String date;

    private Integer departmentId;

    private Integer ovenId;

    private Integer pageNo;

    private Integer pageSize;

    private Integer hisNo;

    private Integer mealTimesId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getOvenId() {
        return ovenId;
    }

    public void setOvenId(Integer ovenId) {
        this.ovenId = ovenId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getHisNo() {
        return hisNo;
    }

    public void setHisNo(Integer hisNo) {
        this.hisNo = hisNo;
    }

    public Integer getMealTimesId() {
        return mealTimesId;
    }

    public void setMealTimesId(Integer mealTimesId) {
        this.mealTimesId = mealTimesId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", date)
                .add("departmentId", departmentId)
                .add("ovenId", ovenId)
                .add("pageNo", pageNo)
                .add("pageSize", pageSize)
                .add("hisNo", hisNo)
                .add("mealTimesId", mealTimesId)
                .toString();
    }
}
