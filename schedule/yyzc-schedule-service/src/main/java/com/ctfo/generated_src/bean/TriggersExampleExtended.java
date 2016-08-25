package com.ctfo.generated_src.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriggersExampleExtended implements Serializable {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	protected List oredCriteria;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	protected String selectedField;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	protected int skipNum;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	protected int endNum;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	protected int limitNum;

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public TriggersExampleExtended() {
		oredCriteria = new ArrayList();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	protected TriggersExampleExtended(TriggersExampleExtended example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public List getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setSelectedField(String selectedField) {
		this.selectedField = selectedField;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getSelectedField() {
		return selectedField;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String tableName() {
		return "QRTZ_TRIGGERS";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String daoInterface() {
		return "com.ctfo.quartz.dao.TriggersDAO";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setSkipNum(int skipNum) {
		this.skipNum = skipNum;
		this.endNum = this.skipNum + this.limitNum + 1;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public int getSkipNum() {
		return this.skipNum;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setEndNum(int endNum) {
		this.endNum = endNum;
		this.limitNum = this.endNum - this.skipNum - 1;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public int getEndNum() {
		return this.endNum;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
		this.endNum = this.skipNum + this.limitNum + 1;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public int getLimitNum() {
		return this.limitNum;
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static class Criteria implements Serializable {
		protected List criteriaWithoutValue;
		protected List criteriaWithSingleValue;
		protected List criteriaWithListValue;
		protected List criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList();
			criteriaWithSingleValue = new ArrayList();
			criteriaWithListValue = new ArrayList();
			criteriaWithBetweenValue = new ArrayList();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition, List values,
				String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List list = new ArrayList();
			list.add(value1);
			list.add(value2);
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andSchedNameIsNull() {
			addCriterion("SCHED_NAME is null");
			return this;
		}

		public Criteria andSchedNameIsNotNull() {
			addCriterion("SCHED_NAME is not null");
			return this;
		}

		public Criteria andSchedNameEqualTo(String value) {
			addCriterion("SCHED_NAME =", value, "schedName");
			return this;
		}

		public Criteria andSchedNameNotEqualTo(String value) {
			addCriterion("SCHED_NAME <>", value, "schedName");
			return this;
		}

		public Criteria andSchedNameGreaterThan(String value) {
			addCriterion("SCHED_NAME >", value, "schedName");
			return this;
		}

		public Criteria andSchedNameGreaterThanOrEqualTo(String value) {
			addCriterion("SCHED_NAME >=", value, "schedName");
			return this;
		}

		public Criteria andSchedNameLessThan(String value) {
			addCriterion("SCHED_NAME <", value, "schedName");
			return this;
		}

		public Criteria andSchedNameLessThanOrEqualTo(String value) {
			addCriterion("SCHED_NAME <=", value, "schedName");
			return this;
		}

		public Criteria andSchedNameLike(String value) {
			addCriterion("SCHED_NAME like", value, "schedName");
			return this;
		}

		public Criteria andSchedNameNotLike(String value) {
			addCriterion("SCHED_NAME not like", value, "schedName");
			return this;
		}

		public Criteria andSchedNameIn(List values) {
			addCriterion("SCHED_NAME in", values, "schedName");
			return this;
		}

		public Criteria andSchedNameNotIn(List values) {
			addCriterion("SCHED_NAME not in", values, "schedName");
			return this;
		}

		public Criteria andSchedNameBetween(String value1, String value2) {
			addCriterion("SCHED_NAME between", value1, value2, "schedName");
			return this;
		}

		public Criteria andSchedNameNotBetween(String value1, String value2) {
			addCriterion("SCHED_NAME not between", value1, value2, "schedName");
			return this;
		}

		public Criteria andTriggerGroupIsNull() {
			addCriterion("TRIGGER_GROUP is null");
			return this;
		}

		public Criteria andTriggerGroupIsNotNull() {
			addCriterion("TRIGGER_GROUP is not null");
			return this;
		}

		public Criteria andTriggerGroupEqualTo(String value) {
			addCriterion("TRIGGER_GROUP =", value, "triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupNotEqualTo(String value) {
			addCriterion("TRIGGER_GROUP <>", value, "triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupGreaterThan(String value) {
			addCriterion("TRIGGER_GROUP >", value, "triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupGreaterThanOrEqualTo(String value) {
			addCriterion("TRIGGER_GROUP >=", value, "triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupLessThan(String value) {
			addCriterion("TRIGGER_GROUP <", value, "triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupLessThanOrEqualTo(String value) {
			addCriterion("TRIGGER_GROUP <=", value, "triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupLike(String value) {
			addCriterion("TRIGGER_GROUP like", value, "triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupNotLike(String value) {
			addCriterion("TRIGGER_GROUP not like", value, "triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupIn(List values) {
			addCriterion("TRIGGER_GROUP in", values, "triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupNotIn(List values) {
			addCriterion("TRIGGER_GROUP not in", values, "triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupBetween(String value1, String value2) {
			addCriterion("TRIGGER_GROUP between", value1, value2,
					"triggerGroup");
			return this;
		}

		public Criteria andTriggerGroupNotBetween(String value1, String value2) {
			addCriterion("TRIGGER_GROUP not between", value1, value2,
					"triggerGroup");
			return this;
		}

		public Criteria andTriggerNameIsNull() {
			addCriterion("TRIGGER_NAME is null");
			return this;
		}

		public Criteria andTriggerNameIsNotNull() {
			addCriterion("TRIGGER_NAME is not null");
			return this;
		}

		public Criteria andTriggerNameEqualTo(String value) {
			addCriterion("TRIGGER_NAME =", value, "triggerName");
			return this;
		}

		public Criteria andTriggerNameNotEqualTo(String value) {
			addCriterion("TRIGGER_NAME <>", value, "triggerName");
			return this;
		}

		public Criteria andTriggerNameGreaterThan(String value) {
			addCriterion("TRIGGER_NAME >", value, "triggerName");
			return this;
		}

		public Criteria andTriggerNameGreaterThanOrEqualTo(String value) {
			addCriterion("TRIGGER_NAME >=", value, "triggerName");
			return this;
		}

		public Criteria andTriggerNameLessThan(String value) {
			addCriterion("TRIGGER_NAME <", value, "triggerName");
			return this;
		}

		public Criteria andTriggerNameLessThanOrEqualTo(String value) {
			addCriterion("TRIGGER_NAME <=", value, "triggerName");
			return this;
		}

		public Criteria andTriggerNameLike(String value) {
			addCriterion("TRIGGER_NAME like", value, "triggerName");
			return this;
		}

		public Criteria andTriggerNameNotLike(String value) {
			addCriterion("TRIGGER_NAME not like", value, "triggerName");
			return this;
		}

		public Criteria andTriggerNameIn(List values) {
			addCriterion("TRIGGER_NAME in", values, "triggerName");
			return this;
		}

		public Criteria andTriggerNameNotIn(List values) {
			addCriterion("TRIGGER_NAME not in", values, "triggerName");
			return this;
		}

		public Criteria andTriggerNameBetween(String value1, String value2) {
			addCriterion("TRIGGER_NAME between", value1, value2, "triggerName");
			return this;
		}

		public Criteria andTriggerNameNotBetween(String value1, String value2) {
			addCriterion("TRIGGER_NAME not between", value1, value2,
					"triggerName");
			return this;
		}

		public Criteria andJobNameIsNull() {
			addCriterion("JOB_NAME is null");
			return this;
		}

		public Criteria andJobNameIsNotNull() {
			addCriterion("JOB_NAME is not null");
			return this;
		}

		public Criteria andJobNameEqualTo(String value) {
			addCriterion("JOB_NAME =", value, "jobName");
			return this;
		}

		public Criteria andJobNameNotEqualTo(String value) {
			addCriterion("JOB_NAME <>", value, "jobName");
			return this;
		}

		public Criteria andJobNameGreaterThan(String value) {
			addCriterion("JOB_NAME >", value, "jobName");
			return this;
		}

		public Criteria andJobNameGreaterThanOrEqualTo(String value) {
			addCriterion("JOB_NAME >=", value, "jobName");
			return this;
		}

		public Criteria andJobNameLessThan(String value) {
			addCriterion("JOB_NAME <", value, "jobName");
			return this;
		}

		public Criteria andJobNameLessThanOrEqualTo(String value) {
			addCriterion("JOB_NAME <=", value, "jobName");
			return this;
		}

		public Criteria andJobNameLike(String value) {
			addCriterion("JOB_NAME like", value, "jobName");
			return this;
		}

		public Criteria andJobNameNotLike(String value) {
			addCriterion("JOB_NAME not like", value, "jobName");
			return this;
		}

		public Criteria andJobNameIn(List values) {
			addCriterion("JOB_NAME in", values, "jobName");
			return this;
		}

		public Criteria andJobNameNotIn(List values) {
			addCriterion("JOB_NAME not in", values, "jobName");
			return this;
		}

		public Criteria andJobNameBetween(String value1, String value2) {
			addCriterion("JOB_NAME between", value1, value2, "jobName");
			return this;
		}

		public Criteria andJobNameNotBetween(String value1, String value2) {
			addCriterion("JOB_NAME not between", value1, value2, "jobName");
			return this;
		}

		public Criteria andJobGroupIsNull() {
			addCriterion("JOB_GROUP is null");
			return this;
		}

		public Criteria andJobGroupIsNotNull() {
			addCriterion("JOB_GROUP is not null");
			return this;
		}

		public Criteria andJobGroupEqualTo(String value) {
			addCriterion("JOB_GROUP =", value, "jobGroup");
			return this;
		}

		public Criteria andJobGroupNotEqualTo(String value) {
			addCriterion("JOB_GROUP <>", value, "jobGroup");
			return this;
		}

		public Criteria andJobGroupGreaterThan(String value) {
			addCriterion("JOB_GROUP >", value, "jobGroup");
			return this;
		}

		public Criteria andJobGroupGreaterThanOrEqualTo(String value) {
			addCriterion("JOB_GROUP >=", value, "jobGroup");
			return this;
		}

		public Criteria andJobGroupLessThan(String value) {
			addCriterion("JOB_GROUP <", value, "jobGroup");
			return this;
		}

		public Criteria andJobGroupLessThanOrEqualTo(String value) {
			addCriterion("JOB_GROUP <=", value, "jobGroup");
			return this;
		}

		public Criteria andJobGroupLike(String value) {
			addCriterion("JOB_GROUP like", value, "jobGroup");
			return this;
		}

		public Criteria andJobGroupNotLike(String value) {
			addCriterion("JOB_GROUP not like", value, "jobGroup");
			return this;
		}

		public Criteria andJobGroupIn(List values) {
			addCriterion("JOB_GROUP in", values, "jobGroup");
			return this;
		}

		public Criteria andJobGroupNotIn(List values) {
			addCriterion("JOB_GROUP not in", values, "jobGroup");
			return this;
		}

		public Criteria andJobGroupBetween(String value1, String value2) {
			addCriterion("JOB_GROUP between", value1, value2, "jobGroup");
			return this;
		}

		public Criteria andJobGroupNotBetween(String value1, String value2) {
			addCriterion("JOB_GROUP not between", value1, value2, "jobGroup");
			return this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("DESCRIPTION is null");
			return this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("DESCRIPTION is not null");
			return this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("DESCRIPTION =", value, "description");
			return this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("DESCRIPTION <>", value, "description");
			return this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("DESCRIPTION >", value, "description");
			return this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("DESCRIPTION >=", value, "description");
			return this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("DESCRIPTION <", value, "description");
			return this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("DESCRIPTION <=", value, "description");
			return this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("DESCRIPTION like", value, "description");
			return this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("DESCRIPTION not like", value, "description");
			return this;
		}

		public Criteria andDescriptionIn(List values) {
			addCriterion("DESCRIPTION in", values, "description");
			return this;
		}

		public Criteria andDescriptionNotIn(List values) {
			addCriterion("DESCRIPTION not in", values, "description");
			return this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("DESCRIPTION between", value1, value2, "description");
			return this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("DESCRIPTION not between", value1, value2,
					"description");
			return this;
		}

		public Criteria andNextFireTimeIsNull() {
			addCriterion("NEXT_FIRE_TIME is null");
			return this;
		}

		public Criteria andNextFireTimeIsNotNull() {
			addCriterion("NEXT_FIRE_TIME is not null");
			return this;
		}

		public Criteria andNextFireTimeEqualTo(Long value) {
			addCriterion("NEXT_FIRE_TIME =", value, "nextFireTime");
			return this;
		}

		public Criteria andNextFireTimeNotEqualTo(Long value) {
			addCriterion("NEXT_FIRE_TIME <>", value, "nextFireTime");
			return this;
		}

		public Criteria andNextFireTimeGreaterThan(Long value) {
			addCriterion("NEXT_FIRE_TIME >", value, "nextFireTime");
			return this;
		}

		public Criteria andNextFireTimeGreaterThanOrEqualTo(Long value) {
			addCriterion("NEXT_FIRE_TIME >=", value, "nextFireTime");
			return this;
		}

		public Criteria andNextFireTimeLessThan(Long value) {
			addCriterion("NEXT_FIRE_TIME <", value, "nextFireTime");
			return this;
		}

		public Criteria andNextFireTimeLessThanOrEqualTo(Long value) {
			addCriterion("NEXT_FIRE_TIME <=", value, "nextFireTime");
			return this;
		}

		public Criteria andNextFireTimeIn(List values) {
			addCriterion("NEXT_FIRE_TIME in", values, "nextFireTime");
			return this;
		}

		public Criteria andNextFireTimeNotIn(List values) {
			addCriterion("NEXT_FIRE_TIME not in", values, "nextFireTime");
			return this;
		}

		public Criteria andNextFireTimeBetween(Long value1, Long value2) {
			addCriterion("NEXT_FIRE_TIME between", value1, value2,
					"nextFireTime");
			return this;
		}

		public Criteria andNextFireTimeNotBetween(Long value1, Long value2) {
			addCriterion("NEXT_FIRE_TIME not between", value1, value2,
					"nextFireTime");
			return this;
		}

		public Criteria andPrevFireTimeIsNull() {
			addCriterion("PREV_FIRE_TIME is null");
			return this;
		}

		public Criteria andPrevFireTimeIsNotNull() {
			addCriterion("PREV_FIRE_TIME is not null");
			return this;
		}

		public Criteria andPrevFireTimeEqualTo(Long value) {
			addCriterion("PREV_FIRE_TIME =", value, "prevFireTime");
			return this;
		}

		public Criteria andPrevFireTimeNotEqualTo(Long value) {
			addCriterion("PREV_FIRE_TIME <>", value, "prevFireTime");
			return this;
		}

		public Criteria andPrevFireTimeGreaterThan(Long value) {
			addCriterion("PREV_FIRE_TIME >", value, "prevFireTime");
			return this;
		}

		public Criteria andPrevFireTimeGreaterThanOrEqualTo(Long value) {
			addCriterion("PREV_FIRE_TIME >=", value, "prevFireTime");
			return this;
		}

		public Criteria andPrevFireTimeLessThan(Long value) {
			addCriterion("PREV_FIRE_TIME <", value, "prevFireTime");
			return this;
		}

		public Criteria andPrevFireTimeLessThanOrEqualTo(Long value) {
			addCriterion("PREV_FIRE_TIME <=", value, "prevFireTime");
			return this;
		}

		public Criteria andPrevFireTimeIn(List values) {
			addCriterion("PREV_FIRE_TIME in", values, "prevFireTime");
			return this;
		}

		public Criteria andPrevFireTimeNotIn(List values) {
			addCriterion("PREV_FIRE_TIME not in", values, "prevFireTime");
			return this;
		}

		public Criteria andPrevFireTimeBetween(Long value1, Long value2) {
			addCriterion("PREV_FIRE_TIME between", value1, value2,
					"prevFireTime");
			return this;
		}

		public Criteria andPrevFireTimeNotBetween(Long value1, Long value2) {
			addCriterion("PREV_FIRE_TIME not between", value1, value2,
					"prevFireTime");
			return this;
		}

		public Criteria andPriorityIsNull() {
			addCriterion("PRIORITY is null");
			return this;
		}

		public Criteria andPriorityIsNotNull() {
			addCriterion("PRIORITY is not null");
			return this;
		}

		public Criteria andPriorityEqualTo(Long value) {
			addCriterion("PRIORITY =", value, "priority");
			return this;
		}

		public Criteria andPriorityNotEqualTo(Long value) {
			addCriterion("PRIORITY <>", value, "priority");
			return this;
		}

		public Criteria andPriorityGreaterThan(Long value) {
			addCriterion("PRIORITY >", value, "priority");
			return this;
		}

		public Criteria andPriorityGreaterThanOrEqualTo(Long value) {
			addCriterion("PRIORITY >=", value, "priority");
			return this;
		}

		public Criteria andPriorityLessThan(Long value) {
			addCriterion("PRIORITY <", value, "priority");
			return this;
		}

		public Criteria andPriorityLessThanOrEqualTo(Long value) {
			addCriterion("PRIORITY <=", value, "priority");
			return this;
		}

		public Criteria andPriorityIn(List values) {
			addCriterion("PRIORITY in", values, "priority");
			return this;
		}

		public Criteria andPriorityNotIn(List values) {
			addCriterion("PRIORITY not in", values, "priority");
			return this;
		}

		public Criteria andPriorityBetween(Long value1, Long value2) {
			addCriterion("PRIORITY between", value1, value2, "priority");
			return this;
		}

		public Criteria andPriorityNotBetween(Long value1, Long value2) {
			addCriterion("PRIORITY not between", value1, value2, "priority");
			return this;
		}

		public Criteria andTriggerStateIsNull() {
			addCriterion("TRIGGER_STATE is null");
			return this;
		}

		public Criteria andTriggerStateIsNotNull() {
			addCriterion("TRIGGER_STATE is not null");
			return this;
		}

		public Criteria andTriggerStateEqualTo(String value) {
			addCriterion("TRIGGER_STATE =", value, "triggerState");
			return this;
		}

		public Criteria andTriggerStateNotEqualTo(String value) {
			addCriterion("TRIGGER_STATE <>", value, "triggerState");
			return this;
		}

		public Criteria andTriggerStateGreaterThan(String value) {
			addCriterion("TRIGGER_STATE >", value, "triggerState");
			return this;
		}

		public Criteria andTriggerStateGreaterThanOrEqualTo(String value) {
			addCriterion("TRIGGER_STATE >=", value, "triggerState");
			return this;
		}

		public Criteria andTriggerStateLessThan(String value) {
			addCriterion("TRIGGER_STATE <", value, "triggerState");
			return this;
		}

		public Criteria andTriggerStateLessThanOrEqualTo(String value) {
			addCriterion("TRIGGER_STATE <=", value, "triggerState");
			return this;
		}

		public Criteria andTriggerStateLike(String value) {
			addCriterion("TRIGGER_STATE like", value, "triggerState");
			return this;
		}

		public Criteria andTriggerStateNotLike(String value) {
			addCriterion("TRIGGER_STATE not like", value, "triggerState");
			return this;
		}

		public Criteria andTriggerStateIn(List values) {
			addCriterion("TRIGGER_STATE in", values, "triggerState");
			return this;
		}

		public Criteria andTriggerStateNotIn(List values) {
			addCriterion("TRIGGER_STATE not in", values, "triggerState");
			return this;
		}

		public Criteria andTriggerStateBetween(String value1, String value2) {
			addCriterion("TRIGGER_STATE between", value1, value2,
					"triggerState");
			return this;
		}

		public Criteria andTriggerStateNotBetween(String value1, String value2) {
			addCriterion("TRIGGER_STATE not between", value1, value2,
					"triggerState");
			return this;
		}

		public Criteria andTriggerTypeIsNull() {
			addCriterion("TRIGGER_TYPE is null");
			return this;
		}

		public Criteria andTriggerTypeIsNotNull() {
			addCriterion("TRIGGER_TYPE is not null");
			return this;
		}

		public Criteria andTriggerTypeEqualTo(String value) {
			addCriterion("TRIGGER_TYPE =", value, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeNotEqualTo(String value) {
			addCriterion("TRIGGER_TYPE <>", value, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeGreaterThan(String value) {
			addCriterion("TRIGGER_TYPE >", value, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeGreaterThanOrEqualTo(String value) {
			addCriterion("TRIGGER_TYPE >=", value, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeLessThan(String value) {
			addCriterion("TRIGGER_TYPE <", value, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeLessThanOrEqualTo(String value) {
			addCriterion("TRIGGER_TYPE <=", value, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeLike(String value) {
			addCriterion("TRIGGER_TYPE like", value, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeNotLike(String value) {
			addCriterion("TRIGGER_TYPE not like", value, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeIn(List values) {
			addCriterion("TRIGGER_TYPE in", values, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeNotIn(List values) {
			addCriterion("TRIGGER_TYPE not in", values, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeBetween(String value1, String value2) {
			addCriterion("TRIGGER_TYPE between", value1, value2, "triggerType");
			return this;
		}

		public Criteria andTriggerTypeNotBetween(String value1, String value2) {
			addCriterion("TRIGGER_TYPE not between", value1, value2,
					"triggerType");
			return this;
		}

		public Criteria andStartTimeIsNull() {
			addCriterion("START_TIME is null");
			return this;
		}

		public Criteria andStartTimeIsNotNull() {
			addCriterion("START_TIME is not null");
			return this;
		}

		public Criteria andStartTimeEqualTo(Long value) {
			addCriterion("START_TIME =", value, "startTime");
			return this;
		}

		public Criteria andStartTimeNotEqualTo(Long value) {
			addCriterion("START_TIME <>", value, "startTime");
			return this;
		}

		public Criteria andStartTimeGreaterThan(Long value) {
			addCriterion("START_TIME >", value, "startTime");
			return this;
		}

		public Criteria andStartTimeGreaterThanOrEqualTo(Long value) {
			addCriterion("START_TIME >=", value, "startTime");
			return this;
		}

		public Criteria andStartTimeLessThan(Long value) {
			addCriterion("START_TIME <", value, "startTime");
			return this;
		}

		public Criteria andStartTimeLessThanOrEqualTo(Long value) {
			addCriterion("START_TIME <=", value, "startTime");
			return this;
		}

		public Criteria andStartTimeIn(List values) {
			addCriterion("START_TIME in", values, "startTime");
			return this;
		}

		public Criteria andStartTimeNotIn(List values) {
			addCriterion("START_TIME not in", values, "startTime");
			return this;
		}

		public Criteria andStartTimeBetween(Long value1, Long value2) {
			addCriterion("START_TIME between", value1, value2, "startTime");
			return this;
		}

		public Criteria andStartTimeNotBetween(Long value1, Long value2) {
			addCriterion("START_TIME not between", value1, value2, "startTime");
			return this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("END_TIME is null");
			return this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("END_TIME is not null");
			return this;
		}

		public Criteria andEndTimeEqualTo(Long value) {
			addCriterion("END_TIME =", value, "endTime");
			return this;
		}

		public Criteria andEndTimeNotEqualTo(Long value) {
			addCriterion("END_TIME <>", value, "endTime");
			return this;
		}

		public Criteria andEndTimeGreaterThan(Long value) {
			addCriterion("END_TIME >", value, "endTime");
			return this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Long value) {
			addCriterion("END_TIME >=", value, "endTime");
			return this;
		}

		public Criteria andEndTimeLessThan(Long value) {
			addCriterion("END_TIME <", value, "endTime");
			return this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Long value) {
			addCriterion("END_TIME <=", value, "endTime");
			return this;
		}

		public Criteria andEndTimeIn(List values) {
			addCriterion("END_TIME in", values, "endTime");
			return this;
		}

		public Criteria andEndTimeNotIn(List values) {
			addCriterion("END_TIME not in", values, "endTime");
			return this;
		}

		public Criteria andEndTimeBetween(Long value1, Long value2) {
			addCriterion("END_TIME between", value1, value2, "endTime");
			return this;
		}

		public Criteria andEndTimeNotBetween(Long value1, Long value2) {
			addCriterion("END_TIME not between", value1, value2, "endTime");
			return this;
		}

		public Criteria andCalendarNameIsNull() {
			addCriterion("CALENDAR_NAME is null");
			return this;
		}

		public Criteria andCalendarNameIsNotNull() {
			addCriterion("CALENDAR_NAME is not null");
			return this;
		}

		public Criteria andCalendarNameEqualTo(String value) {
			addCriterion("CALENDAR_NAME =", value, "calendarName");
			return this;
		}

		public Criteria andCalendarNameNotEqualTo(String value) {
			addCriterion("CALENDAR_NAME <>", value, "calendarName");
			return this;
		}

		public Criteria andCalendarNameGreaterThan(String value) {
			addCriterion("CALENDAR_NAME >", value, "calendarName");
			return this;
		}

		public Criteria andCalendarNameGreaterThanOrEqualTo(String value) {
			addCriterion("CALENDAR_NAME >=", value, "calendarName");
			return this;
		}

		public Criteria andCalendarNameLessThan(String value) {
			addCriterion("CALENDAR_NAME <", value, "calendarName");
			return this;
		}

		public Criteria andCalendarNameLessThanOrEqualTo(String value) {
			addCriterion("CALENDAR_NAME <=", value, "calendarName");
			return this;
		}

		public Criteria andCalendarNameLike(String value) {
			addCriterion("CALENDAR_NAME like", value, "calendarName");
			return this;
		}

		public Criteria andCalendarNameNotLike(String value) {
			addCriterion("CALENDAR_NAME not like", value, "calendarName");
			return this;
		}

		public Criteria andCalendarNameIn(List values) {
			addCriterion("CALENDAR_NAME in", values, "calendarName");
			return this;
		}

		public Criteria andCalendarNameNotIn(List values) {
			addCriterion("CALENDAR_NAME not in", values, "calendarName");
			return this;
		}

		public Criteria andCalendarNameBetween(String value1, String value2) {
			addCriterion("CALENDAR_NAME between", value1, value2,
					"calendarName");
			return this;
		}

		public Criteria andCalendarNameNotBetween(String value1, String value2) {
			addCriterion("CALENDAR_NAME not between", value1, value2,
					"calendarName");
			return this;
		}

		public Criteria andMisfireInstrIsNull() {
			addCriterion("MISFIRE_INSTR is null");
			return this;
		}

		public Criteria andMisfireInstrIsNotNull() {
			addCriterion("MISFIRE_INSTR is not null");
			return this;
		}

		public Criteria andMisfireInstrEqualTo(Short value) {
			addCriterion("MISFIRE_INSTR =", value, "misfireInstr");
			return this;
		}

		public Criteria andMisfireInstrNotEqualTo(Short value) {
			addCriterion("MISFIRE_INSTR <>", value, "misfireInstr");
			return this;
		}

		public Criteria andMisfireInstrGreaterThan(Short value) {
			addCriterion("MISFIRE_INSTR >", value, "misfireInstr");
			return this;
		}

		public Criteria andMisfireInstrGreaterThanOrEqualTo(Short value) {
			addCriterion("MISFIRE_INSTR >=", value, "misfireInstr");
			return this;
		}

		public Criteria andMisfireInstrLessThan(Short value) {
			addCriterion("MISFIRE_INSTR <", value, "misfireInstr");
			return this;
		}

		public Criteria andMisfireInstrLessThanOrEqualTo(Short value) {
			addCriterion("MISFIRE_INSTR <=", value, "misfireInstr");
			return this;
		}

		public Criteria andMisfireInstrIn(List values) {
			addCriterion("MISFIRE_INSTR in", values, "misfireInstr");
			return this;
		}

		public Criteria andMisfireInstrNotIn(List values) {
			addCriterion("MISFIRE_INSTR not in", values, "misfireInstr");
			return this;
		}

		public Criteria andMisfireInstrBetween(Short value1, Short value2) {
			addCriterion("MISFIRE_INSTR between", value1, value2,
					"misfireInstr");
			return this;
		}

		public Criteria andMisfireInstrNotBetween(Short value1, Short value2) {
			addCriterion("MISFIRE_INSTR not between", value1, value2,
					"misfireInstr");
			return this;
		}
	}
}