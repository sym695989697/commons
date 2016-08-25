package com.ctfo.quartz.service;

import java.util.List;

import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctfo.generated_src.bean.InvokeLog;
import com.ctfo.generated_src.bean.InvokeLogExampleExtended;
import com.ctfo.quartz.bean.ScheduleJobBean;
import com.ctfo.quartz.dao.IQuartzDao;
import com.ctfo.utils.EnvironmentUtil;
import com.ctfo.utils.HttpRequest;

@Service("execTaskService")
public class ExecTaskServiceImpl implements IExecTaskService {

	private static final Logger logger = LoggerFactory.getLogger(ExecTaskServiceImpl.class);
	
	@Autowired
	private IQuartzDao quartzDao;
	
	public void execTask(Trigger trigger) {
		try {
			InvokeLogExampleExtended invokeExample = new InvokeLogExampleExtended();
			invokeExample.createCriteria().andTriggerNameEqualTo(trigger.getJobKey().getName()).andTriggerGroupEqualTo(trigger.getJobKey().getGroup());
			invokeExample.setOrderByClause(InvokeLog.fieldTriggerTime() + " desc");
			invokeExample.setLimitNum(1);
			List<InvokeLog> list = quartzDao.getModels(invokeExample);
			
			boolean flag = false;
			if(list == null || list.size() ==0){
				flag = true;
			}else{
				ScheduleJobBean jobBean = (ScheduleJobBean) trigger.getJobDataMap().get("ScheduleJobBean");
				String status = list.get(0).getStatus();
				boolean flag1 = false;
				if(jobBean.getWaitPrev().equals("1")){
					if(status.equals("3") || status.equals("4")){//如果是等待上一次执行完成，则只有状态时‘3’或者‘4’的时候才进行
						flag1 = true;
					}
				}else{
					flag1 = true;
				}
				if(flag1 == true){
					if(jobBean.getMistakeDo().equals("1")){//如果是错误的时候继续，则不用再进一步判断状态
						flag = true;
					}else{
						if(status.equals("4")){//否则，需要进一步判断状态，只有‘4’的时候才进行
							flag = true;
						}
					}
				}
			}
			if(flag == true){
				this.privateExec(trigger);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("触发任务发生错误：", e);
		}
	}

	private void privateExec(Trigger trigger) throws Exception {
		String name = trigger.getJobKey().getName();
		String group = trigger.getJobKey().getGroup();
		if (trigger.getJobDataMap() == null || !trigger.getJobDataMap().containsKey("ScheduleJobBean")) {
			throw new Exception("jobBean为空：triggerName:" + name + ",triggerGroup:" + group);
		}
		ScheduleJobBean jobBean = (ScheduleJobBean) trigger.getJobDataMap().get("ScheduleJobBean");
		String url = jobBean.getUrl();
		if (url == null) {
			throw new Exception("url为空：triggerName:" + name + ",triggerGroup:" + group);
		}
		logger.info("------------------- 任务【" + name + "," + group + "】开始执行，调用的请求地址：" + url + " ----------------------");
		
		//插入调用日志
		String logId = null;
		try {
			InvokeLog bean = new InvokeLog();
			bean.setStatus("0");
			bean.setTriggerName(name);
			bean.setTriggerGroup(group);
			bean.setTriggerTime(trigger.getPreviousFireTime().getTime());
			logId = quartzDao.addModel(bean);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("插入记录日志发生错误：triggerName:" + name + ",triggerGroup:" + group, e);
			throw new Exception("插入记录日志发生错误：triggerName:" + name + ",triggerGroup:" + group);
		}
		int i = 0;
		for(; i < 6 ; i++){
			logger.info("------------------------ 【" + name + "," + group + "】尝试第【" + (i + 1) + "】调用 --------------------------------");
			String result = HttpRequest.sendPost(url, "quartzInvokeId=" + logId + "&callbackURL=" + EnvironmentUtil.getInstance().getPropertyValue("callbackURL"));
			if(!"SUCCESS".equals(result.toUpperCase())){
				if(i != 5){
					logger.info("----------------------------- 回复内容：" + result + "，非SUCCESS -------------------");
					try {
						Thread.sleep(5000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						logger.error("线程sleep发生错误：", e);
					}
				}
			}else{
				break;
			}
		}
		if(i == 6){
			logger.info("------------------------- 调用失败 -----------------------------------");
			try {
				InvokeLog bean1 = new InvokeLog();
				bean1.setId(logId);
				bean1.setStatus("1");
				InvokeLog bean2 = new InvokeLog();
				bean2.setId(logId);
				bean2.setStatus("0");
				quartzDao.updateModelByOtherModel(bean1, bean2);
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("无法将调用日志【" + logId + "】的状态修改为调用失败", e);
				throw new Exception("无法将调用日志【" + logId + "】的状态修改为调用失败");
			}
		}else{
			logger.info("------------------------- 调用成功 -----------------------------------");
			try {
				InvokeLog bean1 = new InvokeLog();
				bean1.setId(logId);
				bean1.setStatus("2");
				InvokeLog bean2 = new InvokeLog();
				bean2.setId(logId);
				bean2.setStatus("0");
				quartzDao.updateModelByOtherModel(bean1, bean2);
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("无法将调用日志【" + logId + "】的状态修改为调用成功", e);
				throw new Exception("无法将调用日志【" + logId + "】的状态修改为调用成功");
			}
		}
	}
}
