package com.ctfo.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ctfo.quartz.service.IExecTaskService;
import com.ctfo.utils.SpringBUtils;


public class QuartzJob extends QuartzJobBean {
	
	protected void executeInternal(JobExecutionContext jobexecutioncontext) throws JobExecutionException {
		IExecTaskService execTaskService = (IExecTaskService) SpringBUtils.getBean("execTaskService");
		Trigger trigger = jobexecutioncontext.getTrigger();
		execTaskService.execTask(trigger);
	}
}
