package com.sinoiov.yyzc.commons.config.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.ctfo.csm.local.DynamicSqlParameter;
import com.ctfo.file.boss.IMongoService;
import com.ctfo.util.DateUtil;
import com.mongodb.WriteConcern;
import com.sinoiov.cwza.server.common.model.PaginationResult;
import com.sinoiov.yyzc.commons.config.entity.Parameter;
import com.sinoiov.yyzc.commons.config.entity.ParameterOperLogs;
import com.sinoiov.yyzc.commons.config.producer.MessageSendService;

public class ParameterServiceImpl implements IParameterService {
	
	private final static Log logger = LogFactory.getLog(ParameterServiceImpl.class);
	
	private static ExecutorService es = null;
	
	private Parameter param;
	
	private IMongoService<Parameter> mongoService;
	
	private IMongoService<ParameterOperLogs> log_mongoService;
	
	static {
		if(es==null){
			es = Executors.newFixedThreadPool(5);
			logger.info("----->> init ParameterServiceImpl thread Pool [5]");
		}
	}

	@Override
	public void insert(String key, Object value, String system)
			throws Exception {
		if (this.getByKey(key, system) != null)
			throw new RuntimeException("The parameter with key '" + key
					+ "' and system '" + system + "' already exists. ");
		param = new Parameter();
		param.setParam_key(key);
		param.setParam_value(value);
		param.setSystem(system);
		try{
			mongoService.save(param, WriteConcern.SAFE);
			MessageSendService.sendToKafka(param);
		}catch(Exception e){
			logger.error("Saving parameter error: " + e.getLocalizedMessage(), e);
			throw e;
		}
	}

	@Override
	public void update(String key, Object value, String system)
			throws Exception {
		// TODO Auto-generated method stub
		try{
			Query<Parameter> query = mongoService.getQuery(Parameter.class);
			query.field("param_key").equal(key);
			query.field("system").equal(system);
			
			UpdateOperations<Parameter> ops = mongoService.createUpdateOperations(Parameter.class);
			ops.set("param_value", value);
			mongoService.update(query, ops);
			MessageSendService.sendToKafka(param);
		}catch(Exception e){
			logger.error("Updating parameter error: " + e.getLocalizedMessage(), e);
			throw e;
		}
		//保存变更日志
		es.execute(new ParamLogsHandler(log_mongoService, key, value, getByKey(key, system), system));
	}

	@Override
	public Map<String, Object> get(String system, int offset, int limit) throws Exception {
		// TODO Auto-generated method stub
		Query<Parameter> query = mongoService.getQuery(Parameter.class);
		query.field("system").equal(system);
		query.offset(offset);
		query.limit(limit);
		query.order("param_key");
		List<Parameter> result = mongoService.query(Parameter.class, query);
		Map<String, Object> map = new HashMap<String, Object>();
		for(Parameter param : result){
			map.put(param.getParam_key(), param.getParam_value());
		}
		return map;
	}

	@Override
	public Object getByKey(String key, String system) throws Exception {
		// TODO Auto-generated method stub
		Query<Parameter> query = mongoService.getQuery(Parameter.class);
		query.field("param_key").equal(key);
		query.field("system").equal(system);
		List<Parameter> result = mongoService.query(Parameter.class, query);
		if(result!=null && result.size()>0) return result.get(0).getParam_value();
		return null;
	}

	@Override
	public void remove(String key, String system) throws Exception {
		// TODO Auto-generated method stub
		mongoService.delete(Parameter.class, "");
	}

	@Override
	public PaginationResult<Parameter> queryParameterByPage(DynamicSqlParameter parameter)
			throws Exception {
		PaginationResult<Parameter> result = null;
		try{
			List<Parameter> list = mongoService.query(Parameter.class, parameter);
			Long count = mongoService.getCount(Parameter.class, parameter);
			result = new PaginationResult<Parameter>();
			result.setTotal(count.intValue());
			result.setData(list);
		}catch(Exception e){
			logger.error("查询参数分页对象时异常: " + e.getLocalizedMessage(), e);
			throw e;
		}
		return result;
	}

}

class ParamLogsHandler implements Runnable {
	
	private IMongoService<ParameterOperLogs> log_mongoService;
	
	private String key, system;
	
	private Object value;
	
	private Object old_value;
	
	public ParamLogsHandler(IMongoService<ParameterOperLogs> log_mongoService, String key, Object value, Object old_value, String system){
		this.key = key;
		this.system = system;
		this.value = value;
		this.old_value = old_value;
		this.log_mongoService = log_mongoService;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ParameterOperLogs log = new ParameterOperLogs();
		log.setParam_key(key);
		log.setSystem(system);
		log.setNew_value(value);
		log.setOperateTime(DateUtil.getDateStr(DateUtil.DEFAULT_FORMATSTR, new Date()));
		
		log.setOld_value(old_value);
		try {
			log_mongoService.save(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}
	
}