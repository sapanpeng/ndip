package com.tenghong.ndip.model.vo;

import com.tenghong.ndip.model.diet.DietOven;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 23:54 2018/6/20
 */
public class OvenTreeVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer typeId;

    private String name;

    private List<DietOven> oven;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DietOven> getOven() {
        return oven;
    }

    public void setOven(List<DietOven> oven) {
        this.oven = oven;
    }
}
