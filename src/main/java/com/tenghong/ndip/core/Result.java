package com.tenghong.ndip.core;

import java.io.Serializable;

/**
 * @description：操作结果集
 * @author：bynow
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 5576237395711742681L;

    private Integer state = 0;

    private String msg = "";

    private Object data = null;


    public Result() {
		super();
	}

	public Result(Integer state, String msg, Object data) {
		super();
		this.state = state;
		this.msg = msg;
		this.data = data;
	}

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
