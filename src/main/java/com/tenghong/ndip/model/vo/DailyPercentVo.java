package com.tenghong.ndip.model.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 15:36 2018/7/18
 */
public class DailyPercentVo {

    @JSONField(format = "yyyy-MM-dd")
    private Date date;

    private List<BigDecimal> value;

    private List<String>  label;

    public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<BigDecimal> getValue() {
        return value;
    }

    public void setValue(List<BigDecimal> value) {
        this.value = value;
    }
}
