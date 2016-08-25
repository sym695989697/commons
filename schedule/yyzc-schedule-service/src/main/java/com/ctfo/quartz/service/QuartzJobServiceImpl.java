package com.ctfo.quartz.service;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.ctfo.generated_src.bean.InvokeLog;
import com.ctfo.generated_src.bean.InvokeLogExampleExtended;
import com.ctfo.generated_src.bean.Triggers;
import com.ctfo.generated_src.bean.TriggersExampleExtended;
import com.ctfo.quartz.bean.DynamicSqlParameter;
import com.ctfo.quartz.bean.PaginationResult;
import com.ctfo.quartz.bean.ScheduleJobBean;
import com.ctfo.quartz.dao.IQuartzDao;
import com.ctfo.quartz.job.QuartzJob;
import com.ctfo.utils.ParameterConver;

@Service("quartzJobService")
public class QuartzJobServiceImpl implements IQuartzJobService {
	
	@Autowired
	private IQuartzDao quartzDao;
	
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	@Override
	public PaginationResult triggerQuery(DynamicSqlParameter request) throws Exception {
		TriggersExampleExtended triggersExample = (TriggersExampleExtended) ParameterConver.paramToExampleExtended(request, new TriggersExampleExtended());
		PaginationResult p = quartzDao.paginateModels(triggersExample);
		List<Triggers> list = (List<Triggers>) p.getData();
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for(int i = 0 ; i < list.size() ; i++){
			Map<String, String> map = new HashMap<String, String>();
			map.put("jobName", list.get(i).getJobName());
			map.put("jobGroup", list.get(i).getJobGroup());
			map.put("triggerState", list.get(i).getTriggerState());
			map.put("startTime", String.valueOf(list.get(i).getStartTime()));
			map.put("nextFireTime", String.valueOf(list.get(i).getNextFireTime()));
			map.put("prevFireTime", String.valueOf(list.get(i).getPrevFireTime()));
			map.put("description", list.get(i).getDescription());
			if(list.get(i).getJobData()!=null){
				ByteArrayInputStream bi = new ByteArrayInputStream(list.get(i).getJobData());
		        ObjectInputStream oi = new ObjectInputStream(bi);
		        Map<String, Object> obj = (Map<String, Object>) oi.readObject();
		        bi.close();
		        oi.close();
				map.put("mistakeDo", ((ScheduleJobBean)obj.get("ScheduleJobBean")).getMistakeDo());
				map.put("waitPrev", ((ScheduleJobBean)obj.get("ScheduleJobBean")).getWaitPrev());
				map.put("invokeUrl", ((ScheduleJobBean)obj.get("ScheduleJobBean")).getUrl());
			}
	        
			
			result.add(map);
		}
		p.setData(result);
		return p;
	}
	
	/**
	 * 添加任务
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void addJob(ScheduleJobBean job) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("jobName", job.getJobName());
		map.put("jobGroup", job.getJobGroup());
		DynamicSqlParameter requestParam = new DynamicSqlParameter();
		requestParam.setEqual(map);
		PaginationResult p = this.triggerQuery(requestParam);
		if(p != null && p.getTotal() != 0){
			throw new SchedulerException("已存在相同名称和组的任务");
		}
		
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
		Trigger trigger = scheduler.getTrigger(triggerKey);
		JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class).withIdentity(job.getJobName(), job.getJobGroup()).build();
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
		trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).withDescription(job.getDescription()).build();
		trigger.getJobDataMap().put("ScheduleJobBean", job);
		scheduler.scheduleJob(jobDetail, trigger);
		//创建的任务默认暂停状态
		this.pauseJob(job);
	}
	/**
	 * 暂停一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void pauseJob(ScheduleJobBean scheduleJob) throws Exception {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.pauseJob(jobKey);
	}

	/**
	 * 恢复一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void resumeJob(ScheduleJobBean scheduleJob) throws Exception {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.resumeJob(jobKey);
	}

	/**
	 * 删除一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void deleteJob(ScheduleJobBean scheduleJob) throws Exception {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.deleteJob(jobKey);
		InvokeLogExampleExtended invokeExample = new InvokeLogExampleExtended();
		invokeExample.createCriteria().andTriggerNameEqualTo(scheduleJob.getJobName()).andTriggerGroupEqualTo(scheduleJob.getJobGroup());
		List<InvokeLog> list = quartzDao.getModels(invokeExample);
		quartzDao.removeModelBatch(list);
	}
	/**
	 * 立即运行一个job
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void executeOnceJob(ScheduleJobBean scheduleJob) throws Exception {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
		scheduler.triggerJob(jobKey);
	}

	/**
	 * 查询调度日志数据
	 * @return
	 */
	public PaginationResult logQuery(DynamicSqlParameter request) throws Exception {
		InvokeLogExampleExtended logExample = (InvokeLogExampleExtended) ParameterConver.paramToExampleExtended(request,  new InvokeLogExampleExtended());
		PaginationResult p = quartzDao.paginateModels(logExample);
		return p;
	}
}
