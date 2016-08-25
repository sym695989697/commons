package com.ctfo.quartz.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ScheduleJobBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5437794261248753153L;
	
	public static final String STATUS_RUNNING = "1";
	public static final String STATUS_NOT_RUNNING = "0";
	public static final String WATING_IS = "1";
	public static final String WATING_NOT = "0";
	public static final String MISTAKE_DO = "1";
	public static final String MISTAKE_NOT_DO = "0";
	public static final String METHOD_TYPE_1 = "1";//时间
	public static final String METHOD_TYPE_2 = "2";//级联

	/**
	 * 任务名称
	 */
	private String jobName;
	/**
	 * 任务分组
	 */
	private String jobGroup;
	/**
	 * 任务状态 是否启动任务
	 */
	private String jobStatus;
	/**
	 * cron表达式
	 */
	private String cronExpression;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 任务是否有状态
	 */
	private String isConcurrent;
	/**
	 * trigger类型
	 */
	private String triggerType;
	/**
	 * 启动时间
	 */
	private String startTime;
	/**
	 * 间隔时间
	 */
	private String intervalTime;
	/**
	 * 执行次数
	 */
	private String repeatCount;
	
	/**
	 * 错误处理
	 */
	private String mistakeDo;
	
	/**
	 * 调用地址
	 */
	private String url;
	
	/**
	 * 是否等待上一次执行完成
	 */
	private String waitPrev;
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsConcurrent() {
		return isConcurrent;
	}
	public void setIsConcurrent(String isConcurrent) {
		this.isConcurrent = isConcurrent;
	}
	public String getTriggerType() {
		return triggerType;
	}
	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getIntervalTime() {
		return intervalTime;
	}
	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}
	public String getRepeatCount() {
		return repeatCount;
	}
	public void setRepeatCount(String repeatCount) {
		this.repeatCount = repeatCount;
	}
	/**
	 * @return the mistakeDo
	 */
	public String getMistakeDo() {
		return mistakeDo;
	}
	/**
	 * @param mistakeDo the mistakeDo to set
	 */
	public void setMistakeDo(String mistakeDo) {
		this.mistakeDo = mistakeDo;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the waitPrev
	 */
	public String getWaitPrev() {
		return waitPrev;
	}
	/**
	 * @param waitPrev the waitPrev to set
	 */
	public void setWaitPrev(String waitPrev) {
		this.waitPrev = waitPrev;
	}
}
