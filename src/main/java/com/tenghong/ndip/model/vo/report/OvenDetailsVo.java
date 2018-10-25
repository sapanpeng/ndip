package com.tenghong.ndip.model.vo.report;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:20 2018/7/28
 */
public class OvenDetailsVo {

    private String title;

    private String date;

    private List<String> wardNameList;

    private String mealTimeName;

    private List<OvenCountVo> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getWardNameList() {
        return wardNameList;
    }

    public void setWardNameList(List<String> wardNameList) {
        this.wardNameList = wardNameList;
    }

    public String getMealTimeName() {
        return mealTimeName;
    }

    public void setMealTimeName(String mealTimeName) {
        this.mealTimeName = mealTimeName;
    }

    public List<OvenCountVo> getList() {
        return list;
    }

    public void setList(List<OvenCountVo> list) {
        this.list = list;
    }
}
