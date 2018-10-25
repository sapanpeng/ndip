package com.tenghong.ndip.model.bo;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class ReceiveOrderBO implements Serializable {

    private Integer omsId;

    private String ovenName;

    private String name;

    private Integer type;

    private Integer number;

    public Integer getOmsId() {
        return omsId;
    }

    public void setOmsId(Integer omsId) {
        this.omsId = omsId;
    }

    public String getOvenName() {
        return ovenName;
    }

    public void setOvenName(String ovenName) {
        this.ovenName = ovenName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("omsId", omsId)
                .add("ovenName", ovenName)
                .add("name", name)
                .add("type", type)
                .add("number", number)
                .toString();
    }
}
