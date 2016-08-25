package com.ctfo.quartz.bean;

import org.springframework.stereotype.Component;

@Component
public class SchedulePageBean {
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
	 * 调用的方法路径全名
	 */
	private String url;
	/**
	 * 被调用次数
	 */
	private String repeatCount;
	/**
	 * 上次执行时间
	 */
	private String prevFireTime;
	/**
	 * 下次执行时间
	 */
	private String nextFireTime;
	/**
	 * 错误处理
	 */
	private String mistakeDo;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRepeatCount() {
		return repeatCount;
	}
	public void setRepeatCount(String repeatCount) {
		this.repeatCount = repeatCount;
	}
	public String getPrevFireTime() {
		return prevFireTime;
	}
	public void setPrevFireTime(String prevFireTime) {
		this.prevFireTime = prevFireTime;
	}
	public String getNextFireTime() {
		return nextFireTime;
	}
	public void setNextFireTime(String nextFireTime) {
		this.nextFireTime = nextFireTime;
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
