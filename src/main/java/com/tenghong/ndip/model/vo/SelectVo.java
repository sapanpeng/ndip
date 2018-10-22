package com.tenghong.ndip.model.vo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 11:33 2018/6/6
 */
public class SelectVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
