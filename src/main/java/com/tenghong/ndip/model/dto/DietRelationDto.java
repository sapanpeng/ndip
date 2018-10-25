package com.tenghong.ndip.model.dto;

import java.io.Serializable;

/**
 * diet_relation
 * @author 
 */
public class DietRelationDto implements Serializable {

    /**
     * 目标id
     */
    private Integer goalId;

    /**
     * 目标类型  1原材料 2菜谱 dish  3 套餐  4 菜单  
     */
    private Integer goalType;

    /**
     * 上级id   0代表无
     */
    private Integer pid;

    /**
     * 数量
     */
    private Integer num;

    private static final long serialVersionUID = 1L;

    public Integer getGoalId() {
        return goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public Integer getGoalType() {
        return goalType;
    }

    public void setGoalType(Integer goalType) {
        this.goalType = goalType;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}