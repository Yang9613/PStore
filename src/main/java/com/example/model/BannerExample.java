package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class BannerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BannerExample() {
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

        public Criteria andFavcategoryIsNull() {
            addCriterion("favcategory is null");
            return (Criteria) this;
        }

        public Criteria andFavcategoryIsNotNull() {
            addCriterion("favcategory is not null");
            return (Criteria) this;
        }

        public Criteria andFavcategoryEqualTo(String value) {
            addCriterion("favcategory =", value, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryNotEqualTo(String value) {
            addCriterion("favcategory <>", value, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryGreaterThan(String value) {
            addCriterion("favcategory >", value, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryGreaterThanOrEqualTo(String value) {
            addCriterion("favcategory >=", value, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryLessThan(String value) {
            addCriterion("favcategory <", value, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryLessThanOrEqualTo(String value) {
            addCriterion("favcategory <=", value, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryLike(String value) {
            addCriterion("favcategory like", value, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryNotLike(String value) {
            addCriterion("favcategory not like", value, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryIn(List<String> values) {
            addCriterion("favcategory in", values, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryNotIn(List<String> values) {
            addCriterion("favcategory not in", values, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryBetween(String value1, String value2) {
            addCriterion("favcategory between", value1, value2, "favcategory");
            return (Criteria) this;
        }

        public Criteria andFavcategoryNotBetween(String value1, String value2) {
            addCriterion("favcategory not between", value1, value2, "favcategory");
            return (Criteria) this;
        }

        public Criteria andBannernameIsNull() {
            addCriterion("bannername is null");
            return (Criteria) this;
        }

        public Criteria andBannernameIsNotNull() {
            addCriterion("bannername is not null");
            return (Criteria) this;
        }

        public Criteria andBannernameEqualTo(String value) {
            addCriterion("bannername =", value, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameNotEqualTo(String value) {
            addCriterion("bannername <>", value, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameGreaterThan(String value) {
            addCriterion("bannername >", value, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameGreaterThanOrEqualTo(String value) {
            addCriterion("bannername >=", value, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameLessThan(String value) {
            addCriterion("bannername <", value, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameLessThanOrEqualTo(String value) {
            addCriterion("bannername <=", value, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameLike(String value) {
            addCriterion("bannername like", value, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameNotLike(String value) {
            addCriterion("bannername not like", value, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameIn(List<String> values) {
            addCriterion("bannername in", values, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameNotIn(List<String> values) {
            addCriterion("bannername not in", values, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameBetween(String value1, String value2) {
            addCriterion("bannername between", value1, value2, "bannername");
            return (Criteria) this;
        }

        public Criteria andBannernameNotBetween(String value1, String value2) {
            addCriterion("bannername not between", value1, value2, "bannername");
            return (Criteria) this;
        }
    }

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