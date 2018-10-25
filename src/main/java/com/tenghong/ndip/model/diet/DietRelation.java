package com.tenghong.ndip.model.diet;

import java.io.Serializable;

/**
 * diet_relation
 * @author 
 */
public class DietRelation implements Serializable {
    private Integer relationId;

    private Integer reGoalId;

    private Integer reGoalType;

    private Integer reGoalNum;

    private String reGoalName;

    private String reGoalTipsOne;

    private String reGoalTipsTwo;

    private Integer reParentId;

    private Integer reParentType;

    private DietElement element;

    private static final long serialVersionUID = 1L;

    public DietElement getElement() {
        return element;
    }

    public void setElement(DietElement element) {
        this.element = element;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getReGoalId() {
        return reGoalId;
    }

    public void setReGoalId(Integer reGoalId) {
        this.reGoalId = reGoalId;
    }

    public Integer getReGoalType() {
        return reGoalType;
    }

    public void setReGoalType(Integer reGoalType) {
        this.reGoalType = reGoalType;
    }

    public Integer getReGoalNum() {
        return reGoalNum;
    }

    public void setReGoalNum(Integer reGoalNum) {
        this.reGoalNum = reGoalNum;
    }

    public String getReGoalName() {
        return reGoalName;
    }

    public void setReGoalName(String reGoalName) {
        this.reGoalName = reGoalName;
    }

    public String getReGoalTipsOne() {
        return reGoalTipsOne;
    }

    public void setReGoalTipsOne(String reGoalTipsOne) {
        this.reGoalTipsOne = reGoalTipsOne;
    }

    public String getReGoalTipsTwo() {
        return reGoalTipsTwo;
    }

    public void setReGoalTipsTwo(String reGoalTipsTwo) {
        this.reGoalTipsTwo = reGoalTipsTwo;
    }

    public Integer getReParentId() {
        return reParentId;
    }

    public void setReParentId(Integer reParentId) {
        this.reParentId = reParentId;
    }

    public Integer getReParentType() {
        return reParentType;
    }

    public void setReParentType(Integer reParentType) {
        this.reParentType = reParentType;
    }
}