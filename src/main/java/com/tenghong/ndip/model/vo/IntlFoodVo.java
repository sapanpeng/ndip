package com.tenghong.ndip.model.vo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 16:44 2018/6/12
 */
public class IntlFoodVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
