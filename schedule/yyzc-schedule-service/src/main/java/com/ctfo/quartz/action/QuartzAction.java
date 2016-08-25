package com.ctfo.quartz.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctfo.quartz.bean.DynamicSqlParameter;
import com.ctfo.quartz.bean.PaginationResult;
import com.ctfo.quartz.bean.ScheduleJobBean;
import com.ctfo.quartz.bean.SchedulePageBean;
import com.ctfo.quartz.service.IQuartzJobService;

@Controller
public class QuartzAction{
	
	private static Log logger = LogFactory.getLog(QuartzAction.class);
	
	@Autowired
	private IQuartzJobService quartzJobService;
	/**
	 * 主页跳转方法
	 * @param request
	 * @return
	 */
	@RequestMapping(value="")
	public String index(HttpServletRequest request) {
		return "/index/index";
	}
	/**
	 * 跳转到所有任务页面
	 * @return
	 */
	@RequestMapping(value="quartzAllGrid")
	public String quartzAllGrid() {
		return "/quartz/quartzAllGrid";
	}
	/**
	 * 跳转到日志页面
	 * @return
	 */
	@RequestMapping(value="logGrid")
	public String logGrid() {
		return "/quartz/logGrid";
	}
	/**
	 * 获取所有任务页面的任务数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value="quartzJobAllGrid")
	@ResponseBody
	public PaginationResult quartzJobAllGrid(@RequestBody DynamicSqlParameter request) {
		PaginationResult result = new PaginationResult();
		try {
			result = quartzJobService.triggerQuery(request);
		} catch (Exception e) {
			logger.error("获取job数据发生错误：", e);
		}
		return result;
	}
	/**
	 * 增加一个任务
	 * @param pageBean
	 * @param request
	 * @return
	 */
	@RequestMapping(value="addJobAction")
	@ResponseBody
	public PaginationResult addJobAction(SchedulePageBean pageBean) {
		PaginationResult result = new PaginationResult();
		ScheduleJobBean jobBean = changeBean(pageBean);
		try {
			quartzJobService.addJob(jobBean);
			result.setMessage("1");
		} catch (Exception e) {
			logger.error("添加job任务发生错误：", e);
			result.setMessage("0");
		}
		return result;
	}
	
	/**
	 * 暂停任务
	 * @param request
	 * @return
	 */
	@RequestMapping(value="pauseJobAction")
	@ResponseBody
	public PaginationResult pauseJob(ScheduleJobBean scheduleJob) {
		PaginationResult result = new PaginationResult();
		try {
			quartzJobService.pauseJob(scheduleJob);
			result.setMessage("1");
		} catch (Exception e) {
			result.setMessage("0");
			logger.error("暂停任务发生错误：", e);
		}
		return result;
	}
	
	/**
	 * 恢复任务
	 * @param request
	 * @return
	 */
	@RequestMapping(value="resumeJobAction")
	@ResponseBody
	public PaginationResult resumeJob(ScheduleJobBean scheduleJob) {
		PaginationResult result = new PaginationResult();
		try {
			quartzJobService.resumeJob(scheduleJob);
			result.setMessage("1");
		} catch (Exception e) {
			result.setMessage("0");
			logger.error("恢复任务发生错误：", e);
		}
		return result;
	}
	
	/**
	 * 删除任务
	 * @param request
	 * @return
	 */
	@RequestMapping(value="deleteJobAction")
	@ResponseBody
	public PaginationResult deleteJob(ScheduleJobBean scheduleJob) {
		PaginationResult result = new PaginationResult();
		try {
			quartzJobService.deleteJob(scheduleJob);
			result.setMessage("1");
		} catch (Exception e) {
			result.setMessage("0");
			logger.error("删除任务发生错误：", e);
		}
		return result;
	}
	
	/**
	 * 执行一次任务
	 * @param request
	 * @return
	 */
	@RequestMapping(value="executeOnceJobAction")
	@ResponseBody
	public PaginationResult executeOnceJob(ScheduleJobBean scheduleJob) {
		PaginationResult result = new PaginationResult();
		try {
			quartzJobService.executeOnceJob(scheduleJob);
			result.setMessage("1");
		} catch (Exception e) {
			result.setMessage("0");
			logger.error("运行任务发生错误：", e);
		}
		return result;
	}
	
	/**
	 * 查询调度日志数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value="queryLogGrid")
	@ResponseBody
	public PaginationResult queryLogGrid(@RequestBody DynamicSqlParameter request) {
		PaginationResult result = new PaginationResult();
		try {
			result = quartzJobService.logQuery(request);
		} catch (Exception e) {
			logger.error("查询调度日志数据发生错误：", e);
		}
		return result;
	}
	
	private ScheduleJobBean changeBean(SchedulePageBean schedulePageBean) {
		ScheduleJobBean jobBean = new ScheduleJobBean();
		jobBean.setJobName(schedulePageBean.getJobName());
		jobBean.setJobGroup(schedulePageBean.getJobGroup());
		jobBean.setCronExpression(schedulePageBean.getCronExpression());
		jobBean.setDescription(schedulePageBean.getDescription());
		jobBean.setStartTime(String.valueOf(new Date().getTime()));
		jobBean.setUrl(schedulePageBean.getUrl());
		jobBean.setMistakeDo(schedulePageBean.getMistakeDo());
		jobBean.setWaitPrev(schedulePageBean.getWaitPrev());
		return jobBean;
	}
}
