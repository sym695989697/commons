package com.ctfo.upp.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractService{
	
	private static Log logger = LogFactory.getLog(AbstractService.class);
	
	
	/**
	 * 获取远程对象方法
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <X> X getRemoManager(Class<?> cls){
		//return (X)ServiceFactory.getFactory().getService(cls);
		return null;
	}
	
	public com.ctfo.csm.uaa.intf.support.Operator getOnlieOperator(){
		
		return null;
	}
	
	
}
