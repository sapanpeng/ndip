package com.tenghong.ndip.model.vo.report;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 14:22 2018/7/28
 */
public class OvenCountVo {

    private String ovenName;

    private Integer ovenId;

    private String name;

    private List<Integer> numbers;

    private Integer sum;

    private Integer goalId;

    private Integer goalType;

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

    public Integer getOvenId() {
        return ovenId;
    }

    public void setOvenId(Integer ovenId) {
        this.ovenId = ovenId;
    }

    public String getOvenName() {
        return ovenName;
    }

    public void setOvenName(String ovenName) {
        this.ovenName = ovenName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
