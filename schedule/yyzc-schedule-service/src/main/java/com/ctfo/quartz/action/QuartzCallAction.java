package com.ctfo.quartz.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctfo.quartz.bean.ScheduleJobBean;
import com.ctfo.quartz.service.IQuartzJobService;

@Controller
@RequestMapping(value = "/call")
public class QuartzCallAction {
	
	private static Log logger = LogFactory.getLog(QuartzCallAction.class);
	
	@Autowired
	private IQuartzJobService quartzJobService;
	
	/**
	 * 增加一个任务
	 * @param pageBean
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="addJob")
	@ResponseBody
	public void addJobAction(HttpServletRequest request) throws Exception {
		ScheduleJobBean scheduleJob = new ScheduleJobBean();
		if(StringUtils.isBlank(request.getParameter("jobName"))){
			throw new Exception("参数为空！");
		}
		if(StringUtils.isBlank(request.getParameter("jobGroup"))){
			throw new Exception("参数为空！");
		}
		if(StringUtils.isBlank(request.getParameter("cronExpression"))){
			throw new Exception("参数为空！");
		}
		if(StringUtils.isBlank(request.getParameter("waitPrev"))){
			throw new Exception("参数为空！");
		}
		if(StringUtils.isBlank(request.getParameter("mistakeDo"))){
			throw new Exception("参数为空！");
		}
		if(StringUtils.isBlank(request.getParameter("url"))){
			throw new Exception("参数为空！");
		}
		if(StringUtils.isNotBlank(request.getParameter("description"))){
			scheduleJob.setDescription(request.getParameter("description"));
		}
		scheduleJob.setJobName(request.getParameter("jobName"));
		scheduleJob.setJobGroup(request.getParameter("jobGroup"));
		scheduleJob.setCronExpression(request.getParameter("cronExpression"));
		scheduleJob.setWaitPrev(request.getParameter("waitPrev"));
		scheduleJob.setMistakeDo(request.getParameter("mistakeDo"));
		scheduleJob.setUrl(request.getParameter("url"));
		try {
			quartzJobService.addJob(scheduleJob);
		} catch (Exception e) {
			logger.error("添加job任务发生错误：", e);
			throw new Exception("添加job任务发生错误!");
		}
	}
	
	/**
	 * 暂停任务
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="pauseJob")
	@ResponseBody
	public void pauseJob(HttpServletRequest request) throws Exception {
		ScheduleJobBean scheduleJob = new ScheduleJobBean();
		if(StringUtils.isBlank(request.getParameter("jobName"))){
			throw new Exception("参数为空！");
		}
		if(StringUtils.isBlank(request.getParameter("jobGroup"))){
			throw new Exception("参数为空！");
		}
		scheduleJob.setJobName(request.getParameter("jobName"));
		scheduleJob.setJobGroup(request.getParameter("jobGroup"));
		try {
			quartzJobService.pauseJob(scheduleJob);
		} catch (Exception e) {
			logger.error("暂停任务发生错误：", e);
			throw new Exception("暂停任务发生错误!");
		}
	}
	
	/**
	 * 恢复任务
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="resumeJob")
	@ResponseBody
	public void resumeJob(HttpServletRequest request) throws Exception {
		ScheduleJobBean scheduleJob = new ScheduleJobBean();
		if(StringUtils.isBlank(request.getParameter("jobName"))){
			throw new Exception("参数为空！");
		}
		if(StringUtils.isBlank(request.getParameter("jobGroup"))){
			throw new Exception("参数为空！");
		}
		scheduleJob.setJobName(request.getParameter("jobName"));
		scheduleJob.setJobGroup(request.getParameter("jobGroup"));
		try {
			quartzJobService.resumeJob(scheduleJob);
		} catch (Exception e) {
			logger.error("恢复任务发生错误：", e);
			throw new Exception("恢复任务发生错误!");
		}
	}
	
	/**
	 * 删除任务
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="deleteJob")
	@ResponseBody
	public void deleteJob(HttpServletRequest request) throws Exception {
		ScheduleJobBean scheduleJob = new ScheduleJobBean();
		if(StringUtils.isBlank(request.getParameter("jobName"))){
			throw new Exception("参数为空！");
		}
		if(StringUtils.isBlank(request.getParameter("jobGroup"))){
			throw new Exception("参数为空！");
		}
		scheduleJob.setJobName(request.getParameter("jobName"));
		scheduleJob.setJobGroup(request.getParameter("jobGroup"));
		try {
			quartzJobService.deleteJob(scheduleJob);
		} catch (Exception e) {
			logger.error("删除任务发生错误：", e);
			throw new Exception("删除任务发生错误!");
		}
	}
	
	/**
	 * 执行一次任务
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="executeOnceJob")
	@ResponseBody
	public void executeOnceJob(HttpServletRequest request) throws Exception {
		ScheduleJobBean scheduleJob = new ScheduleJobBean();
		if(StringUtils.isBlank(request.getParameter("jobName"))){
			throw new Exception("参数为空！");
		}
		if(StringUtils.isBlank(request.getParameter("jobGroup"))){
			throw new Exception("参数为空！");
		}
		scheduleJob.setJobName(request.getParameter("jobName"));
		scheduleJob.setJobGroup(request.getParameter("jobGroup"));
		try {
			quartzJobService.executeOnceJob(scheduleJob);
		} catch (Exception e) {
			logger.error("运行任务发生错误：", e);
			throw new Exception("运行任务发生错误!");
		}
	}
}
