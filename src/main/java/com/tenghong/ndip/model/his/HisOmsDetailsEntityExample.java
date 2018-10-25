package com.tenghong.ndip.model.his;

import java.util.ArrayList;
import java.util.List;

public class HisOmsDetailsEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public HisOmsDetailsEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOmsIdIsNull() {
            addCriterion("oms_id is null");
            return (Criteria) this;
        }

        public Criteria andOmsIdIsNotNull() {
            addCriterion("oms_id is not null");
            return (Criteria) this;
        }

        public Criteria andOmsIdEqualTo(Integer value) {
            addCriterion("oms_id =", value, "omsId");
            return (Criteria) this;
        }

        public Criteria andOmsIdNotEqualTo(Integer value) {
            addCriterion("oms_id <>", value, "omsId");
            return (Criteria) this;
        }

        public Criteria andOmsIdGreaterThan(Integer value) {
            addCriterion("oms_id >", value, "omsId");
            return (Criteria) this;
        }

        public Criteria andOmsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oms_id >=", value, "omsId");
            return (Criteria) this;
        }

        public Criteria andOmsIdLessThan(Integer value) {
            addCriterion("oms_id <", value, "omsId");
            return (Criteria) this;
        }

        public Criteria andOmsIdLessThanOrEqualTo(Integer value) {
            addCriterion("oms_id <=", value, "omsId");
            return (Criteria) this;
        }

        public Criteria andOmsIdIn(List<Integer> values) {
            addCriterion("oms_id in", values, "omsId");
            return (Criteria) this;
        }

        public Criteria andOmsIdNotIn(List<Integer> values) {
            addCriterion("oms_id not in", values, "omsId");
            return (Criteria) this;
        }

        public Criteria andOmsIdBetween(Integer value1, Integer value2) {
            addCriterion("oms_id between", value1, value2, "omsId");
            return (Criteria) this;
        }

        public Criteria andOmsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oms_id not between", value1, value2, "omsId");
            return (Criteria) this;
        }

        public Criteria andMealIdIsNull() {
            addCriterion("meal_id is null");
            return (Criteria) this;
        }

        public Criteria andMealIdIsNotNull() {
            addCriterion("meal_id is not null");
            return (Criteria) this;
        }

        public Criteria andMealIdEqualTo(Integer value) {
            addCriterion("meal_id =", value, "mealId");
            return (Criteria) this;
        }

        public Criteria andMealIdNotEqualTo(Integer value) {
            addCriterion("meal_id <>", value, "mealId");
            return (Criteria) this;
        }

        public Criteria andMealIdGreaterThan(Integer value) {
            addCriterion("meal_id >", value, "mealId");
            return (Criteria) this;
        }

        public Criteria andMealIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("meal_id >=", value, "mealId");
            return (Criteria) this;
        }

        public Criteria andMealIdLessThan(Integer value) {
            addCriterion("meal_id <", value, "mealId");
            return (Criteria) this;
        }

        public Criteria andMealIdLessThanOrEqualTo(Integer value) {
            addCriterion("meal_id <=", value, "mealId");
            return (Criteria) this;
        }

        public Criteria andMealIdIn(List<Integer> values) {
            addCriterion("meal_id in", values, "mealId");
            return (Criteria) this;
        }

        public Criteria andMealIdNotIn(List<Integer> values) {
            addCriterion("meal_id not in", values, "mealId");
            return (Criteria) this;
        }

        public Criteria andMealIdBetween(Integer value1, Integer value2) {
            addCriterion("meal_id between", value1, value2, "mealId");
            return (Criteria) this;
        }

        public Criteria andMealIdNotBetween(Integer value1, Integer value2) {
            addCriterion("meal_id not between", value1, value2, "mealId");
            return (Criteria) this;
        }

        public Criteria andMealNameIsNull() {
            addCriterion("meal_name is null");
            return (Criteria) this;
        }

        public Criteria andMealNameIsNotNull() {
            addCriterion("meal_name is not null");
            return (Criteria) this;
        }

        public Criteria andMealNameEqualTo(String value) {
            addCriterion("meal_name =", value, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameNotEqualTo(String value) {
            addCriterion("meal_name <>", value, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameGreaterThan(String value) {
            addCriterion("meal_name >", value, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameGreaterThanOrEqualTo(String value) {
            addCriterion("meal_name >=", value, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameLessThan(String value) {
            addCriterion("meal_name <", value, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameLessThanOrEqualTo(String value) {
            addCriterion("meal_name <=", value, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameLike(String value) {
            addCriterion("meal_name like", value, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameNotLike(String value) {
            addCriterion("meal_name not like", value, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameIn(List<String> values) {
            addCriterion("meal_name in", values, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameNotIn(List<String> values) {
            addCriterion("meal_name not in", values, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameBetween(String value1, String value2) {
            addCriterion("meal_name between", value1, value2, "mealName");
            return (Criteria) this;
        }

        public Criteria andMealNameNotBetween(String value1, String value2) {
            addCriterion("meal_name not between", value1, value2, "mealName");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIsNull() {
            addCriterion("current_price is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIsNotNull() {
            addCriterion("current_price is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceEqualTo(Double value) {
            addCriterion("current_price =", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotEqualTo(Double value) {
            addCriterion("current_price <>", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThan(Double value) {
            addCriterion("current_price >", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("current_price >=", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThan(Double value) {
            addCriterion("current_price <", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThanOrEqualTo(Double value) {
            addCriterion("current_price <=", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIn(List<Double> values) {
            addCriterion("current_price in", values, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotIn(List<Double> values) {
            addCriterion("current_price not in", values, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceBetween(Double value1, Double value2) {
            addCriterion("current_price between", value1, value2, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotBetween(Double value1, Double value2) {
            addCriterion("current_price not between", value1, value2, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andOvenIdIsNull() {
            addCriterion("oven_id is null");
            return (Criteria) this;
        }

        public Criteria andOvenIdIsNotNull() {
            addCriterion("oven_id is not null");
            return (Criteria) this;
        }

        public Criteria andOvenIdEqualTo(Integer value) {
            addCriterion("oven_id =", value, "ovenId");
            return (Criteria) this;
        }

        public Criteria andOvenIdNotEqualTo(Integer value) {
            addCriterion("oven_id <>", value, "ovenId");
            return (Criteria) this;
        }

        public Criteria andOvenIdGreaterThan(Integer value) {
            addCriterion("oven_id >", value, "ovenId");
            return (Criteria) this;
        }

        public Criteria andOvenIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oven_id >=", value, "ovenId");
            return (Criteria) this;
        }

        public Criteria andOvenIdLessThan(Integer value) {
            addCriterion("oven_id <", value, "ovenId");
            return (Criteria) this;
        }

        public Criteria andOvenIdLessThanOrEqualTo(Integer value) {
            addCriterion("oven_id <=", value, "ovenId");
            return (Criteria) this;
        }

        public Criteria andOvenIdIn(List<Integer> values) {
            addCriterion("oven_id in", values, "ovenId");
            return (Criteria) this;
        }

        public Criteria andOvenIdNotIn(List<Integer> values) {
            addCriterion("oven_id not in", values, "ovenId");
            return (Criteria) this;
        }

        public Criteria andOvenIdBetween(Integer value1, Integer value2) {
            addCriterion("oven_id between", value1, value2, "ovenId");
            return (Criteria) this;
        }

        public Criteria andOvenIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oven_id not between", value1, value2, "ovenId");
            return (Criteria) this;
        }

        public Criteria andOvenNameIsNull() {
            addCriterion("oven_name is null");
            return (Criteria) this;
        }

        public Criteria andOvenNameIsNotNull() {
            addCriterion("oven_name is not null");
            return (Criteria) this;
        }

        public Criteria andOvenNameEqualTo(String value) {
            addCriterion("oven_name =", value, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameNotEqualTo(String value) {
            addCriterion("oven_name <>", value, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameGreaterThan(String value) {
            addCriterion("oven_name >", value, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameGreaterThanOrEqualTo(String value) {
            addCriterion("oven_name >=", value, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameLessThan(String value) {
            addCriterion("oven_name <", value, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameLessThanOrEqualTo(String value) {
            addCriterion("oven_name <=", value, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameLike(String value) {
            addCriterion("oven_name like", value, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameNotLike(String value) {
            addCriterion("oven_name not like", value, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameIn(List<String> values) {
            addCriterion("oven_name in", values, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameNotIn(List<String> values) {
            addCriterion("oven_name not in", values, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameBetween(String value1, String value2) {
            addCriterion("oven_name between", value1, value2, "ovenName");
            return (Criteria) this;
        }

        public Criteria andOvenNameNotBetween(String value1, String value2) {
            addCriterion("oven_name not between", value1, value2, "ovenName");
            return (Criteria) this;
        }

        public Criteria andGoalIdIsNull() {
            addCriterion("goal_id is null");
            return (Criteria) this;
        }

        public Criteria andGoalIdIsNotNull() {
            addCriterion("goal_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoalIdEqualTo(Integer value) {
            addCriterion("goal_id =", value, "goalId");
            return (Criteria) this;
        }

        public Criteria andGoalIdNotEqualTo(Integer value) {
            addCriterion("goal_id <>", value, "goalId");
            return (Criteria) this;
        }

        public Criteria andGoalIdGreaterThan(Integer value) {
            addCriterion("goal_id >", value, "goalId");
            return (Criteria) this;
        }

        public Criteria andGoalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goal_id >=", value, "goalId");
            return (Criteria) this;
        }

        public Criteria andGoalIdLessThan(Integer value) {
            addCriterion("goal_id <", value, "goalId");
            return (Criteria) this;
        }

        public Criteria andGoalIdLessThanOrEqualTo(Integer value) {
            addCriterion("goal_id <=", value, "goalId");
            return (Criteria) this;
        }

        public Criteria andGoalIdIn(List<Integer> values) {
            addCriterion("goal_id in", values, "goalId");
            return (Criteria) this;
        }

        public Criteria andGoalIdNotIn(List<Integer> values) {
            addCriterion("goal_id not in", values, "goalId");
            return (Criteria) this;
        }

        public Criteria andGoalIdBetween(Integer value1, Integer value2) {
            addCriterion("goal_id between", value1, value2, "goalId");
            return (Criteria) this;
        }

        public Criteria andGoalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goal_id not between", value1, value2, "goalId");
            return (Criteria) this;
        }

        public Criteria andGoalNameIsNull() {
            addCriterion("goal_name is null");
            return (Criteria) this;
        }

        public Criteria andGoalNameIsNotNull() {
            addCriterion("goal_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoalNameEqualTo(String value) {
            addCriterion("goal_name =", value, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameNotEqualTo(String value) {
            addCriterion("goal_name <>", value, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameGreaterThan(String value) {
            addCriterion("goal_name >", value, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameGreaterThanOrEqualTo(String value) {
            addCriterion("goal_name >=", value, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameLessThan(String value) {
            addCriterion("goal_name <", value, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameLessThanOrEqualTo(String value) {
            addCriterion("goal_name <=", value, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameLike(String value) {
            addCriterion("goal_name like", value, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameNotLike(String value) {
            addCriterion("goal_name not like", value, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameIn(List<String> values) {
            addCriterion("goal_name in", values, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameNotIn(List<String> values) {
            addCriterion("goal_name not in", values, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameBetween(String value1, String value2) {
            addCriterion("goal_name between", value1, value2, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalNameNotBetween(String value1, String value2) {
            addCriterion("goal_name not between", value1, value2, "goalName");
            return (Criteria) this;
        }

        public Criteria andGoalPriceIsNull() {
            addCriterion("goal_price is null");
            return (Criteria) this;
        }

        public Criteria andGoalPriceIsNotNull() {
            addCriterion("goal_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoalPriceEqualTo(Double value) {
            addCriterion("goal_price =", value, "goalPrice");
            return (Criteria) this;
        }

        public Criteria andGoalPriceNotEqualTo(Double value) {
            addCriterion("goal_price <>", value, "goalPrice");
            return (Criteria) this;
        }

        public Criteria andGoalPriceGreaterThan(Double value) {
            addCriterion("goal_price >", value, "goalPrice");
            return (Criteria) this;
        }

        public Criteria andGoalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("goal_price >=", value, "goalPrice");
            return (Criteria) this;
        }

        public Criteria andGoalPriceLessThan(Double value) {
            addCriterion("goal_price <", value, "goalPrice");
            return (Criteria) this;
        }

        public Criteria andGoalPriceLessThanOrEqualTo(Double value) {
            addCriterion("goal_price <=", value, "goalPrice");
            return (Criteria) this;
        }

        public Criteria andGoalPriceIn(List<Double> values) {
            addCriterion("goal_price in", values, "goalPrice");
            return (Criteria) this;
        }

        public Criteria andGoalPriceNotIn(List<Double> values) {
            addCriterion("goal_price not in", values, "goalPrice");
            return (Criteria) this;
        }

        public Criteria andGoalPriceBetween(Double value1, Double value2) {
            addCriterion("goal_price between", value1, value2, "goalPrice");
            return (Criteria) this;
        }

        public Criteria andGoalPriceNotBetween(Double value1, Double value2) {
            addCriterion("goal_price not between", value1, value2, "goalPrice");
            return (Criteria) this;
        }

        public Criteria andGoalNumIsNull() {
            addCriterion("goal_num is null");
            return (Criteria) this;
        }

        public Criteria andGoalNumIsNotNull() {
            addCriterion("goal_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoalNumEqualTo(Integer value) {
            addCriterion("goal_num =", value, "goalNum");
            return (Criteria) this;
        }

        public Criteria andGoalNumNotEqualTo(Integer value) {
            addCriterion("goal_num <>", value, "goalNum");
            return (Criteria) this;
        }

        public Criteria andGoalNumGreaterThan(Integer value) {
            addCriterion("goal_num >", value, "goalNum");
            return (Criteria) this;
        }

        public Criteria andGoalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goal_num >=", value, "goalNum");
            return (Criteria) this;
        }

        public Criteria andGoalNumLessThan(Integer value) {
            addCriterion("goal_num <", value, "goalNum");
            return (Criteria) this;
        }

        public Criteria andGoalNumLessThanOrEqualTo(Integer value) {
            addCriterion("goal_num <=", value, "goalNum");
            return (Criteria) this;
        }

        public Criteria andGoalNumIn(List<Integer> values) {
            addCriterion("goal_num in", values, "goalNum");
            return (Criteria) this;
        }

        public Criteria andGoalNumNotIn(List<Integer> values) {
            addCriterion("goal_num not in", values, "goalNum");
            return (Criteria) this;
        }

        public Criteria andGoalNumBetween(Integer value1, Integer value2) {
            addCriterion("goal_num between", value1, value2, "goalNum");
            return (Criteria) this;
        }

        public Criteria andGoalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goal_num not between", value1, value2, "goalNum");
            return (Criteria) this;
        }

        public Criteria andGoalTypeIsNull() {
            addCriterion("goal_type is null");
            return (Criteria) this;
        }

        public Criteria andGoalTypeIsNotNull() {
            addCriterion("goal_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoalTypeEqualTo(Integer value) {
            addCriterion("goal_type =", value, "goalType");
            return (Criteria) this;
        }

        public Criteria andGoalTypeNotEqualTo(Integer value) {
            addCriterion("goal_type <>", value, "goalType");
            return (Criteria) this;
        }

        public Criteria andGoalTypeGreaterThan(Integer value) {
            addCriterion("goal_type >", value, "goalType");
            return (Criteria) this;
        }

        public Criteria andGoalTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goal_type >=", value, "goalType");
            return (Criteria) this;
        }

        public Criteria andGoalTypeLessThan(Integer value) {
            addCriterion("goal_type <", value, "goalType");
            return (Criteria) this;
        }

        public Criteria andGoalTypeLessThanOrEqualTo(Integer value) {
            addCriterion("goal_type <=", value, "goalType");
            return (Criteria) this;
        }

        public Criteria andGoalTypeIn(List<Integer> values) {
            addCriterion("goal_type in", values, "goalType");
            return (Criteria) this;
        }

        public Criteria andGoalTypeNotIn(List<Integer> values) {
            addCriterion("goal_type not in", values, "goalType");
            return (Criteria) this;
        }

        public Criteria andGoalTypeBetween(Integer value1, Integer value2) {
            addCriterion("goal_type between", value1, value2, "goalType");
            return (Criteria) this;
        }

        public Criteria andGoalTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("goal_type not between", value1, value2, "goalType");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}