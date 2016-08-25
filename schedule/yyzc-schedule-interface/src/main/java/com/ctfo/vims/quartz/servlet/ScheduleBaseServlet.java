package com.ctfo.vims.quartz.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class ScheduleBaseServlet extends HttpServlet {

	private static final long serialVersionUID = 5684538061814847084L;
	
	private static Log logger = LogFactory.getLog(ScheduleBaseServlet.class);
	
	protected abstract boolean executeTask(Map<String, String> paramMap);
	
	@Override
	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		//接收调用参数
		logger.info(">>>>>>>>>>>>>>>>>定时服务开始调用>>>>>>>>>>>>>>>>>>>>");
		//获取请求参数
		Map<String, String[]> paramMap = request.getParameterMap();
		//接收成功，返回response给调用端QuartzService
		try {
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write("SUCCESS".getBytes());  
			outstream.close();  
		} catch (IOException e) {
			logger.error("返回response给调用端QuartzService出现异常：", e);
		}
		logger.info(">>>>>>>>>>>>>>>>>调用参数：" + paramMap + ">>>>>>>>>>>>>>>>>>>>");
		//获取其中的任务id和回调地址
		
		if(!paramMap.isEmpty()){
			String taskId = paramMap.get("quartzInvokeId")[0];
			String callbackURL = paramMap.get("callbackURL")[0];
			Map<String, String> map = new HashMap<String, String>();
			for(String key : paramMap.keySet()){
				if(!key.equals("quartzInvokeId") && !key.equals("callbackURL")){
					map.put(key, paramMap.get(key)[0]);
				}
			}
			//执行具体任务
			boolean result = false;
			try{
				result = this.executeTask(map);
			}catch(Exception e){
				logger.error("任务执行出现异常：" + e);
			}
			//返回执行结果给调用端QuartzService
			this.callback(result, taskId, callbackURL);
		}
		
	}
	
	private void callback(boolean message, String taskId, String callbackURL){
		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(callbackURL);
			// 以post方式请求
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			String param = "id=" + taskId + "&status=" + (message == true ? "1" : "0");
			conn.getOutputStream().write(param.getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();
			// 获取响应代码
			logger.info("\r\nresponse code : " + conn.getResponseCode());
			StringBuffer result = new StringBuffer("");
			InputStreamReader isr = new InputStreamReader(
					conn.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String inputLine;
			while (null != (inputLine = in.readLine())) {
				result.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
			logger.error("回调执行结果给quartz服务发生错误", e);
		}
	}
}
