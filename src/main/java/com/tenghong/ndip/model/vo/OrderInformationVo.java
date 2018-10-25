package com.tenghong.ndip.model.vo;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 21:39 2018/7/25
 */
public class OrderInformationVo {

    private String hisNo;

    private String name;

    private String bookDate;

    private String mealTimeName;

    private String dietName;

    private Integer number;

    private Double perPrice;

    private Double price;

    private String cafeteriaName;

    private String sickRoom;

    private String bedNo;

    private String operator;

    private Date operaterTime;

    public String getHisNo() {
        return hisNo;
    }

    public void setHisNo(String hisNo) {
        this.hisNo = hisNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getMealTimeName() {
        return mealTimeName;
    }

    public void setMealTimeName(String mealTimeName) {
        this.mealTimeName = mealTimeName;
    }

    public String getDietName() {
        return dietName;
    }

    public void setDietName(String dietName) {
        this.dietName = dietName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPerPrice() {
        return perPrice;
    }

    public void setPerPrice(Double perPrice) {
        this.perPrice = perPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCafeteriaName() {
        return cafeteriaName;
    }

    public void setCafeteriaName(String cafeteriaName) {
        this.cafeteriaName = cafeteriaName;
    }

    public String getSickRoom() {
        return sickRoom;
    }

    public void setSickRoom(String sickRoom) {
        this.sickRoom = sickRoom;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperaterTime() {
        return operaterTime;
    }

    public void setOperaterTime(Date operaterTime) {
        this.operaterTime = operaterTime;
    }
}
