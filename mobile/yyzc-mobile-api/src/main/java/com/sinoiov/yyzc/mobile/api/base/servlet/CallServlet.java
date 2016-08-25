package com.sinoiov.yyzc.mobile.api.base.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinoiov.yyzc.common.utils.SpringBUtils;
import com.sinoiov.yyzc.mobile.api.base.intf.ICallService;

public class CallServlet extends HttpServlet {

	private static Log logger = LogFactory.getLog(CallServlet.class);
	
	private static final long serialVersionUID = -1940819445399135681L;
	
	private String resultStr = "";
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		logger.info(">>>>>>>>>>>>>>>>> 处理客户端请求开始 <<<<<<<<<<<<<<<<<<<<");
		ICallService callService = (ICallService) SpringBUtils.getBean("callServiceImpl");
		resultStr = callService.call(request);
		logger.info(">>>>>>>>>>>>>>>>>>>> 返回客户端的内容为：" + resultStr + " <<<<<<<<<<<<<<<<<<<<");
		sendResponseJson(resultStr, response);
		logger.info(">>>>>>>>>>>>>>>>> 处理接受客户端请求结束 <<<<<<<<<<<<<<<<<<<<");
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void sendResponseJson(String resultStr, HttpServletResponse response){
		ServletOutputStream outstream;
		try {
			outstream = response.getOutputStream();
			outstream.write(resultStr.getBytes());  
			outstream.close();  
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
