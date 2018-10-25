package com.tenghong.ndip.model.dto;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:28 2018/6/7
 */
public class ImageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
