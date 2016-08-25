package com.sinoiov.yyzc.commons.config;

import java.util.Map;

import com.ctfo.csm.local.DynamicSqlParameter;
import com.sinoiov.cwza.server.common.model.PaginationResult;

public interface IConfigService {
	
	public void save(String key, Object value, String system) throws Exception;
	
	public void update(String key, Object value, String system) throws Exception;
	
	public void remove(String key, String system) throws Exception;
	
	public Map<String, Object> get(String system, int offset, int limit) throws Exception;
	
	public Object getByKey(String key, String system) throws Exception;
	
	public PaginationResult<?> queryParameterByPage(DynamicSqlParameter parameter) throws Exception;
	
}
