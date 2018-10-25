package com.tenghong.ndip.model.dto;

import com.tenghong.ndip.model.his.HisOmsDetails;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 10:21 2018/7/6
 */
public class OmsAppDto implements Serializable {

    private String patientId;

    private Integer mealId;

    private String mealName;

    private Date diningTime;

    private Integer omsId;

    private Integer omsType;

    private String token;

    private Integer id;

    private List<HisOmsDetails> detailDto;

    public Integer getOmsType() {
        return omsType;
    }

    public void setOmsType(Integer omsType) {
        this.omsType = omsType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOmsId() {
        return omsId;
    }

    public void setOmsId(Integer omsId) {
        this.omsId = omsId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Date getDiningTime() {
        return diningTime;
    }

    public void setDiningTime(Date diningTime) {
        this.diningTime = diningTime;
    }

    public List<HisOmsDetails> getDetailDto() {
        return detailDto;
    }

    public void setDetailDto(List<HisOmsDetails> detailDto) {
        this.detailDto = detailDto;
    }
}
