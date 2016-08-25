package com.ctfo.quartz.service;

import org.quartz.SchedulerException;

import com.ctfo.quartz.bean.DynamicSqlParameter;
import com.ctfo.quartz.bean.PaginationResult;
import com.ctfo.quartz.bean.ScheduleJobBean;

public interface IQuartzJobService {
	
	/**
	 * 获取数据库里的Job集合
	 * @return
	 */
	public PaginationResult triggerQuery(DynamicSqlParameter request) throws Exception;
	
	/**
	 * 添加任务
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void addJob(ScheduleJobBean job) throws Exception;
	/**
	 * 暂停一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void pauseJob(ScheduleJobBean scheduleJob) throws Exception;
	/**
	 * 恢复一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void resumeJob(ScheduleJobBean scheduleJob) throws Exception;
	/**
	 * 删除一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void deleteJob(ScheduleJobBean scheduleJob) throws Exception;
	/**
	 * 立即运行一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void executeOnceJob(ScheduleJobBean scheduleJob) throws Exception;
	
	/**
	 * 查询调度日志数据
	 * @return
	 */
	public PaginationResult logQuery(DynamicSqlParameter request) throws Exception;
}
