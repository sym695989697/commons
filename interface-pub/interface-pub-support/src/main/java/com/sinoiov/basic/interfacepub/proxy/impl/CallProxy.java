package com.sinoiov.basic.interfacepub.proxy.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sinoiov.basic.interfacepub.annotations.ExecutorMethodCode;
import com.sinoiov.basic.interfacepub.beans.common.Param;
import com.sinoiov.basic.interfacepub.beans.request.Request;
import com.sinoiov.basic.interfacepub.beans.response.Response;
import com.sinoiov.basic.interfacepub.exception.InterfacePubException;
import com.sinoiov.basic.interfacepub.executor.IExecutor;
import com.sinoiov.basic.interfacepub.interceptors.Interceptor;
import com.sinoiov.basic.interfacepub.plugins.IPlugin;
import com.sinoiov.basic.interfacepub.proxy.ICallProxy;
import com.sinoiov.basic.interfacepub.utils.SpringContextsUtil;

@Service("proxy")
@Scope("prototype")
public class CallProxy implements ICallProxy {
	
	private final static Log logger = LogFactory.getLog(CallProxy.class);
	
	private final static String SUCCESS = "Success";

	private final static String FAILED = "Failed";
	
	@Autowired
	private List<Interceptor> filters;
	
	@Autowired
	private List<IPlugin> plugins;
	
	public Response process(Request request){
		Response response = new Response();
		String command = null;
		try{
			this.validate(request);
			for (Interceptor filter : filters) {
				filter.doFilter(request);
			}
			command = request.getServCode();
			IExecutor executor = this.getExecutor(command);
			if(executor == null) throw new InterfacePubException("ERROR CODE:100006", 
					"所调用服务'" + request.getServCode() + "'未定义！");
			executor.validate(request.getParam());
			Param param = this.execute(executor, request.getParam(), command);
			response.setResult(SUCCESS);
			response.setParam(param);
		}catch(InterfacePubException e){
			logger.error(e.getMessage(), e);
			response.setResult(FAILED);
			response.setErrorMessage("[" + e.getErrorCode() + "]" + e.getMessage());
		}catch (Throwable e) {
			logger.error(e.getMessage(), e);
			response.setResult(FAILED);
			response.setErrorMessage("ERROR CODE:00");
		} finally {
			for(IPlugin plugin : plugins){
				plugin.process(request, response);
			}
		}
		return response;
	}
	
	protected void validate(Request request) {
		if(request == null)
			throw new InterfacePubException("ERROR CODE:100001", "请求request不能为空！");
		if(StringUtils.isBlank(request.getServCode()))
			throw new InterfacePubException("ERROR CODE:100002", "服务编码servCode不能为空！");
		if(StringUtils.isBlank(request.getSequenceNum()))
			throw new InterfacePubException("ERROR CODE:100003", "请求流水号sequenceNum不能为空！");
		if(StringUtils.isBlank(request.getSign()))
			throw new InterfacePubException("ERROR CODE:100004", "参数签名sign不能为空！");
		if(request.getParam() == null)
			throw new InterfacePubException("ERROR CODE:100005", "请求参数param不能为空！");
	}
	
	protected Param execute(IExecutor executor, Param param, String command) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Param result = null;
		if(command.indexOf("!") >= 0){
			Method [] methods = executor.getClass().getMethods();
			for(Method method : methods){
				if(method.getAnnotation(ExecutorMethodCode.class) !=null 
						&& method.getAnnotation(ExecutorMethodCode.class).value().equals(command.split("!")[1])){
					result = (Param)method.invoke(param);
				}
			}
		}else{
			result = executor.execute(param);
		}
		return result;
	}
	
	protected IExecutor getExecutor(String command){
		if(command.indexOf("!") >= 0){
			return (IExecutor)SpringContextsUtil.getBean(command.split("!")[0]);
		}else{
			return (IExecutor)SpringContextsUtil.getBean(command);
		}
		
	}
}
