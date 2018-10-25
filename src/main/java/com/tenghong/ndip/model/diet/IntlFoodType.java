package com.tenghong.ndip.model.diet;

import java.io.Serializable;
import java.util.List;

/**
 * intl_food_type
 * @author 
 */
public class IntlFoodType implements Serializable {
    /**
     * 没有主键
     */
    private Integer id;

    /**
     * 国标食物类别名称
     */
    private String intlTypeName;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 上级食物类别代码
     */
    private Integer pid;

    private List<IntlFoodType> list;

    private static final long serialVersionUID = 1L;

    public List<IntlFoodType> getList() {
        return list;
    }

    public void setList(List<IntlFoodType> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntlTypeName() {
        return intlTypeName;
    }

    public void setIntlTypeName(String intlTypeName) {
        this.intlTypeName = intlTypeName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}