package com.tenghong.ndip.model.vo;

import com.tenghong.ndip.model.diet.DietElement;
import com.tenghong.ndip.model.dto.ImageDto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 11:33 2018/6/6
 */
public class MenuVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer relationId;

    private Integer menuId;

    private String name;

    private Double price;

    private Integer type;

    private Integer goalId;

    private Integer mealId;

    private Integer ovenId;

    private String icon;

    private List<ImageDto> iconVo;

    private String menuTime;

    private Integer elementGoalId;

    private DietElement element;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getElementGoalId() {
        return elementGoalId;
    }

    public void setElementGoalId(Integer elementGoalId) {
        this.elementGoalId = elementGoalId;
    }

    public DietElement getElement() {
        return element;
    }

    public void setElement(DietElement element) {
        this.element = element;
    }

    public String getMenuTime() {
        return menuTime;
    }

    public void setMenuTime(String menuTime) {
        this.menuTime = menuTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<ImageDto> getIconVo() {
        return iconVo;
    }

    public void setIconVo(List<ImageDto> iconVo) {
        this.iconVo = iconVo;
    }

    public Integer getOvenId() {
        return ovenId;
    }

    public void setOvenId(Integer ovenId) {
        this.ovenId = ovenId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public Integer getGoalId() {
        return goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
