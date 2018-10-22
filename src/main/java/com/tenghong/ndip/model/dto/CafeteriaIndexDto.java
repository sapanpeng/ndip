package com.tenghong.ndip.model.dto;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:12 2018/7/18
 */
public class CafeteriaIndexDto {

    private Integer cafeteriaId;

    private String cafeteriaName;

    private Double value;

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
