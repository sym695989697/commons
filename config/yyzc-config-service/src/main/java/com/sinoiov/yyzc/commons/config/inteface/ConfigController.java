package com.sinoiov.yyzc.commons.config.inteface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctfo.csm.local.DynamicSqlParameter;
import com.sinoiov.cwza.server.common.model.PaginationResult;
import com.sinoiov.yyzc.common.utils.JsonUtil;
import com.sinoiov.yyzc.commons.config.entity.Parameter;
import com.sinoiov.yyzc.commons.config.service.IParameterService;

@Scope("prototype")
@Controller
@RequestMapping(value = "/config")
public class ConfigController {
	
	@Autowired
	private IParameterService parameterService;
	
	
	@RequestMapping(value = "/add", produces = "text/plain;charset=UTF-8")
	public String saveConfig(String json)throws Exception {
		
		return null;
	}
	@RequestMapping(value = "/update", produces = "text/plain;charset=UTF-8")
	public String updateConfig(String json)throws Exception {
		
		return null;
	}
	@RequestMapping(value = "/delete", produces = "text/plain;charset=UTF-8")
	public String deleteConfig(String json)throws Exception {
		
		return null;
	}
	
	@RequestMapping(value = "/get", produces = "text/plain;charset=UTF-8")
	public String getConfig(String json)throws Exception {
		
		return null;
	}
	@RequestMapping(value = "/queryParameterByPage", produces = "text/plain;charset=UTF-8")
	public String queryParameterByPage(String json)throws Exception {
	
		DynamicSqlParameter parameter = JsonUtil.getDynamicSqlParameter(json);

		PaginationResult<Parameter> result = parameterService.queryParameterByPage(parameter);
		
		return JsonUtil.getObjectJson(result);
		
	}

}
