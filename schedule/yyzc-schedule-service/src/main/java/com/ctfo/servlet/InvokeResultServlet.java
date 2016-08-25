package com.ctfo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctfo.generated_src.bean.InvokeLog;
import com.ctfo.quartz.dao.IQuartzDao;
import com.ctfo.utils.SpringBUtils;

public class InvokeResultServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(InvokeResultServlet.class);
	
	private IQuartzDao quartzDao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		quartzDao = (IQuartzDao) SpringBUtils.getBean("quartzDao");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("------------------ 接收到【" + this.getRequestIp(req) + "】的调用请求 -------------------");
		
		String logId = req.getParameter("id");
		String status = req.getParameter("status");
		
		try {
			if(status.equals("0")){
				InvokeLog bean = new InvokeLog();
				bean.setId(logId);
				bean.setStatus("3");
				quartzDao.updateModelPart(bean);
			}
			if(status.equals("1")){
				InvokeLog bean = new InvokeLog();
				bean.setId(logId);
				bean.setStatus("4");
				quartzDao.updateModelPart(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			if(status.equals("0")){
				logger.error("------------------ 无法将调用日志【" + logId + "】的状态修改为执行失败 -------------------");
			}
			if(status.equals("1")){
				logger.error("------------------ 无法将调用日志【" + logId + "】的状态修改为执行成功 -------------------");
			}
		}
	}
	
	private String getRequestIp(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
