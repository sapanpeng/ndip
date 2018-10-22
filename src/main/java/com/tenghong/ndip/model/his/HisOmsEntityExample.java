package com.tenghong.ndip.model.his;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HisOmsEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public HisOmsEntityExample() {
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

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Integer value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Integer value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Integer value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Integer value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Integer value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Integer> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Integer> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Integer value1, Integer value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
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

        public Criteria andWardIdIsNull() {
            addCriterion("ward_id is null");
            return (Criteria) this;
        }

        public Criteria andWardIdIsNotNull() {
            addCriterion("ward_id is not null");
            return (Criteria) this;
        }

        public Criteria andWardIdEqualTo(Integer value) {
            addCriterion("ward_id =", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdNotEqualTo(Integer value) {
            addCriterion("ward_id <>", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdGreaterThan(Integer value) {
            addCriterion("ward_id >", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ward_id >=", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdLessThan(Integer value) {
            addCriterion("ward_id <", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdLessThanOrEqualTo(Integer value) {
            addCriterion("ward_id <=", value, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdIn(List<Integer> values) {
            addCriterion("ward_id in", values, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdNotIn(List<Integer> values) {
            addCriterion("ward_id not in", values, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdBetween(Integer value1, Integer value2) {
            addCriterion("ward_id between", value1, value2, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ward_id not between", value1, value2, "wardId");
            return (Criteria) this;
        }

        public Criteria andWardNameIsNull() {
            addCriterion("ward_name is null");
            return (Criteria) this;
        }

        public Criteria andWardNameIsNotNull() {
            addCriterion("ward_name is not null");
            return (Criteria) this;
        }

        public Criteria andWardNameEqualTo(String value) {
            addCriterion("ward_name =", value, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameNotEqualTo(String value) {
            addCriterion("ward_name <>", value, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameGreaterThan(String value) {
            addCriterion("ward_name >", value, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameGreaterThanOrEqualTo(String value) {
            addCriterion("ward_name >=", value, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameLessThan(String value) {
            addCriterion("ward_name <", value, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameLessThanOrEqualTo(String value) {
            addCriterion("ward_name <=", value, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameLike(String value) {
            addCriterion("ward_name like", value, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameNotLike(String value) {
            addCriterion("ward_name not like", value, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameIn(List<String> values) {
            addCriterion("ward_name in", values, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameNotIn(List<String> values) {
            addCriterion("ward_name not in", values, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameBetween(String value1, String value2) {
            addCriterion("ward_name between", value1, value2, "wardName");
            return (Criteria) this;
        }

        public Criteria andWardNameNotBetween(String value1, String value2) {
            addCriterion("ward_name not between", value1, value2, "wardName");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdIsNull() {
            addCriterion("cafeteria_id is null");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdIsNotNull() {
            addCriterion("cafeteria_id is not null");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdEqualTo(Integer value) {
            addCriterion("cafeteria_id =", value, "cafeteriaId");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdNotEqualTo(Integer value) {
            addCriterion("cafeteria_id <>", value, "cafeteriaId");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdGreaterThan(Integer value) {
            addCriterion("cafeteria_id >", value, "cafeteriaId");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cafeteria_id >=", value, "cafeteriaId");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdLessThan(Integer value) {
            addCriterion("cafeteria_id <", value, "cafeteriaId");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdLessThanOrEqualTo(Integer value) {
            addCriterion("cafeteria_id <=", value, "cafeteriaId");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdIn(List<Integer> values) {
            addCriterion("cafeteria_id in", values, "cafeteriaId");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdNotIn(List<Integer> values) {
            addCriterion("cafeteria_id not in", values, "cafeteriaId");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdBetween(Integer value1, Integer value2) {
            addCriterion("cafeteria_id between", value1, value2, "cafeteriaId");
            return (Criteria) this;
        }

        public Criteria andCafeteriaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cafeteria_id not between", value1, value2, "cafeteriaId");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameIsNull() {
            addCriterion("cafeteria_name is null");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameIsNotNull() {
            addCriterion("cafeteria_name is not null");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameEqualTo(String value) {
            addCriterion("cafeteria_name =", value, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameNotEqualTo(String value) {
            addCriterion("cafeteria_name <>", value, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameGreaterThan(String value) {
            addCriterion("cafeteria_name >", value, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameGreaterThanOrEqualTo(String value) {
            addCriterion("cafeteria_name >=", value, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameLessThan(String value) {
            addCriterion("cafeteria_name <", value, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameLessThanOrEqualTo(String value) {
            addCriterion("cafeteria_name <=", value, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameLike(String value) {
            addCriterion("cafeteria_name like", value, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameNotLike(String value) {
            addCriterion("cafeteria_name not like", value, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameIn(List<String> values) {
            addCriterion("cafeteria_name in", values, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameNotIn(List<String> values) {
            addCriterion("cafeteria_name not in", values, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameBetween(String value1, String value2) {
            addCriterion("cafeteria_name between", value1, value2, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andCafeteriaNameNotBetween(String value1, String value2) {
            addCriterion("cafeteria_name not between", value1, value2, "cafeteriaName");
            return (Criteria) this;
        }

        public Criteria andOmsTypeIsNull() {
            addCriterion("oms_type is null");
            return (Criteria) this;
        }

        public Criteria andOmsTypeIsNotNull() {
            addCriterion("oms_type is not null");
            return (Criteria) this;
        }

        public Criteria andOmsTypeEqualTo(Integer value) {
            addCriterion("oms_type =", value, "omsType");
            return (Criteria) this;
        }

        public Criteria andOmsTypeNotEqualTo(Integer value) {
            addCriterion("oms_type <>", value, "omsType");
            return (Criteria) this;
        }

        public Criteria andOmsTypeGreaterThan(Integer value) {
            addCriterion("oms_type >", value, "omsType");
            return (Criteria) this;
        }

        public Criteria andOmsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("oms_type >=", value, "omsType");
            return (Criteria) this;
        }

        public Criteria andOmsTypeLessThan(Integer value) {
            addCriterion("oms_type <", value, "omsType");
            return (Criteria) this;
        }

        public Criteria andOmsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("oms_type <=", value, "omsType");
            return (Criteria) this;
        }

        public Criteria andOmsTypeIn(List<Integer> values) {
            addCriterion("oms_type in", values, "omsType");
            return (Criteria) this;
        }

        public Criteria andOmsTypeNotIn(List<Integer> values) {
            addCriterion("oms_type not in", values, "omsType");
            return (Criteria) this;
        }

        public Criteria andOmsTypeBetween(Integer value1, Integer value2) {
            addCriterion("oms_type between", value1, value2, "omsType");
            return (Criteria) this;
        }

        public Criteria andOmsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("oms_type not between", value1, value2, "omsType");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andDiningTimeIsNull() {
            addCriterion("dining_time is null");
            return (Criteria) this;
        }

        public Criteria andDiningTimeIsNotNull() {
            addCriterion("dining_time is not null");
            return (Criteria) this;
        }

        public Criteria andDiningTimeEqualTo(Date value) {
            addCriterion("dining_time =", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeNotEqualTo(Date value) {
            addCriterion("dining_time <>", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeGreaterThan(Date value) {
            addCriterion("dining_time >", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dining_time >=", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeLessThan(Date value) {
            addCriterion("dining_time <", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeLessThanOrEqualTo(Date value) {
            addCriterion("dining_time <=", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeIn(List<Date> values) {
            addCriterion("dining_time in", values, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeNotIn(List<Date> values) {
            addCriterion("dining_time not in", values, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeBetween(Date value1, Date value2) {
            addCriterion("dining_time between", value1, value2, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeNotBetween(Date value1, Date value2) {
            addCriterion("dining_time not between", value1, value2, "diningTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Integer value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Integer value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Integer value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Integer value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Integer value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Integer> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Integer> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Integer value1, Integer value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Integer value1, Integer value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
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