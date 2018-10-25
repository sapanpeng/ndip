package com.tenghong.ndip.model.vo;

import com.google.common.base.MoreObjects;
import com.tenghong.ndip.model.bo.DeliverOrderBO;

import java.io.Serializable;
import java.util.List;


/**
 * Created by Lewis on 2018/7/4.
 */
public class DeliverOrderVO implements Serializable {

    private String title;

    private String wardName;

    private String date;

    private Integer pageCount;

    List<DeliverOrderBO> list;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<DeliverOrderBO> getList() {
        return list;
    }

    public void setList(List<DeliverOrderBO> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("wardName", wardName)
                .add("date", date)
                .add("pageCount", pageCount)
                .add("list", list)
                .toString();
    }
}
