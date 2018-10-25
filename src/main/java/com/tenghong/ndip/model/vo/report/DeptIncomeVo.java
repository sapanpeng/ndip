package com.tenghong.ndip.model.vo.report;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:34 2018/7/19
 */
public class DeptIncomeVo {

    private List<String> thList;

    private List<DeptWardVo> wardList;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getThList() {
        return thList;
    }

    public void setThList(List<String> thList) {
        this.thList = thList;
    }

    public List<DeptWardVo> getWardList() {
        return wardList;
    }

    public void setWardList(List<DeptWardVo> wardList) {
        this.wardList = wardList;
    }
}
