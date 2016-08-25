package com.ctfo.generated_src.bean;

import javax.xml.bind.annotation.XmlElement;

import com.ctfo.quartz.bean.BaseSerializable;

public class Triggers extends BaseSerializable {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.SCHED_NAME DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private String schedName;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_GROUP DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private String triggerGroup;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_NAME DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private String triggerName;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.JOB_NAME DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private String jobName;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.JOB_GROUP DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private String jobGroup;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.DESCRIPTION DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private String description;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.NEXT_FIRE_TIME DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private Long nextFireTime;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.PREV_FIRE_TIME DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private Long prevFireTime;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.PRIORITY DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private Long priority;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_STATE DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private String triggerState;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_TYPE DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private String triggerType;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.START_TIME DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private Long startTime;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.END_TIME DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private Long endTime;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.CALENDAR_NAME DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private String calendarName;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.MISFIRE_INSTR DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private Short misfireInstr;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database column QUARTZ.QRTZ_TRIGGERS.JOB_DATA DB Comment: 
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	@XmlElement(name = "", required = false)
	private byte[] jobData;

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.SCHED_NAME
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.SCHED_NAME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getSchedName() {
		return schedName;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.SCHED_NAME
	 * @param schedName  the value for QUARTZ.QRTZ_TRIGGERS.SCHED_NAME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldSchedName() {
		return "SCHED_NAME";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_GROUP
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.TRIGGER_GROUP
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getTriggerGroup() {
		return triggerGroup;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_GROUP
	 * @param triggerGroup  the value for QUARTZ.QRTZ_TRIGGERS.TRIGGER_GROUP
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldTriggerGroup() {
		return "TRIGGER_GROUP";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_NAME
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.TRIGGER_NAME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getTriggerName() {
		return triggerName;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_NAME
	 * @param triggerName  the value for QUARTZ.QRTZ_TRIGGERS.TRIGGER_NAME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldTriggerName() {
		return "TRIGGER_NAME";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.JOB_NAME
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.JOB_NAME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.JOB_NAME
	 * @param jobName  the value for QUARTZ.QRTZ_TRIGGERS.JOB_NAME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldJobName() {
		return "JOB_NAME";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.JOB_GROUP
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.JOB_GROUP
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getJobGroup() {
		return jobGroup;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.JOB_GROUP
	 * @param jobGroup  the value for QUARTZ.QRTZ_TRIGGERS.JOB_GROUP
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldJobGroup() {
		return "JOB_GROUP";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.DESCRIPTION
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.DESCRIPTION
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.DESCRIPTION
	 * @param description  the value for QUARTZ.QRTZ_TRIGGERS.DESCRIPTION
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldDescription() {
		return "DESCRIPTION";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.NEXT_FIRE_TIME
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.NEXT_FIRE_TIME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public Long getNextFireTime() {
		return nextFireTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.NEXT_FIRE_TIME
	 * @param nextFireTime  the value for QUARTZ.QRTZ_TRIGGERS.NEXT_FIRE_TIME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setNextFireTime(Long nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldNextFireTime() {
		return "NEXT_FIRE_TIME";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.PREV_FIRE_TIME
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.PREV_FIRE_TIME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public Long getPrevFireTime() {
		return prevFireTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.PREV_FIRE_TIME
	 * @param prevFireTime  the value for QUARTZ.QRTZ_TRIGGERS.PREV_FIRE_TIME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setPrevFireTime(Long prevFireTime) {
		this.prevFireTime = prevFireTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldPrevFireTime() {
		return "PREV_FIRE_TIME";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.PRIORITY
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.PRIORITY
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public Long getPriority() {
		return priority;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.PRIORITY
	 * @param priority  the value for QUARTZ.QRTZ_TRIGGERS.PRIORITY
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setPriority(Long priority) {
		this.priority = priority;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldPriority() {
		return "PRIORITY";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_STATE
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.TRIGGER_STATE
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getTriggerState() {
		return triggerState;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_STATE
	 * @param triggerState  the value for QUARTZ.QRTZ_TRIGGERS.TRIGGER_STATE
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setTriggerState(String triggerState) {
		this.triggerState = triggerState;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldTriggerState() {
		return "TRIGGER_STATE";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_TYPE
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.TRIGGER_TYPE
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getTriggerType() {
		return triggerType;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.TRIGGER_TYPE
	 * @param triggerType  the value for QUARTZ.QRTZ_TRIGGERS.TRIGGER_TYPE
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldTriggerType() {
		return "TRIGGER_TYPE";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.START_TIME
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.START_TIME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.START_TIME
	 * @param startTime  the value for QUARTZ.QRTZ_TRIGGERS.START_TIME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldStartTime() {
		return "START_TIME";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.END_TIME
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.END_TIME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public Long getEndTime() {
		return endTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.END_TIME
	 * @param endTime  the value for QUARTZ.QRTZ_TRIGGERS.END_TIME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldEndTime() {
		return "END_TIME";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.CALENDAR_NAME
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.CALENDAR_NAME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public String getCalendarName() {
		return calendarName;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.CALENDAR_NAME
	 * @param calendarName  the value for QUARTZ.QRTZ_TRIGGERS.CALENDAR_NAME
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldCalendarName() {
		return "CALENDAR_NAME";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.MISFIRE_INSTR
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.MISFIRE_INSTR
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public Short getMisfireInstr() {
		return misfireInstr;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.MISFIRE_INSTR
	 * @param misfireInstr  the value for QUARTZ.QRTZ_TRIGGERS.MISFIRE_INSTR
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setMisfireInstr(Short misfireInstr) {
		this.misfireInstr = misfireInstr;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public static String fieldMisfireInstr() {
		return "MISFIRE_INSTR";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column QUARTZ.QRTZ_TRIGGERS.JOB_DATA
	 * @return  the value of QUARTZ.QRTZ_TRIGGERS.JOB_DATA
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public byte[] getJobData() {
		return jobData;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column QUARTZ.QRTZ_TRIGGERS.JOB_DATA
	 * @param jobData  the value for QUARTZ.QRTZ_TRIGGERS.JOB_DATA
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public void setJobData(byte[] jobData) {
		this.jobData = jobData;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_TRIGGERS
	 * @abatorgenerated  Tue Mar 03 16:40:14 CST 2015
	 */
	public Triggers() {
		super();
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
}