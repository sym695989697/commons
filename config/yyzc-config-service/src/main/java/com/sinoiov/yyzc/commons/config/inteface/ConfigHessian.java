package com.sinoiov.yyzc.commons.config.inteface;

import org.springframework.beans.factory.annotation.Autowired;

import com.ctfo.csm.local.DynamicSqlParameter;
import com.sinoiov.cwza.server.common.model.PaginationResult;
import com.sinoiov.yyzc.commons.config.entity.Parameter;
import com.sinoiov.yyzc.commons.config.service.IParameterService;

public class ConfigHessian {

	@Autowired
	private IParameterService parameterService;
	
	
	public String saveConfig(String key, String value, String system)throws Exception {
		
		parameterService.insert(key, value, system);
		
		return "SUCCESS";
	}
	
	public String updateConfig(String key, String value, String system)throws Exception {
		
		parameterService.update(key, value, system);
		
		return "SUCCESS";
	}
	
	public String deleteConfig(String key, String system)throws Exception {
		parameterService.remove(key, system);
		
		return "SUCCESS";
	}
	
	
	public Parameter getConfig(String key, String sign)throws Exception {
		Parameter parameter = null;
		parameter = (Parameter) parameterService.getByKey(key, sign);
		return parameter;
	}
	
	
	public PaginationResult<Parameter> queryParameterByPage(DynamicSqlParameter parameter)throws Exception {
		
		return parameterService.queryParameterByPage(parameter);
		
	}
	
	
}
