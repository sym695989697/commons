package com.sinoiov.yyzc.commons.config.executor;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Service;

import com.sinoiov.yyzc.commons.config.cache.Cache;
import com.sinoiov.yyzc.commons.config.cache.CacheManager;
import com.sinoiov.yyzc.commons.kafka.YyzcKafkaMessageExecutor;
import com.sinoiov.yyzc.commons.kafka.exceptions.YyzcKafkaException;

@Service("config_update_executor")
public class ConfigUpdateExecutor implements YyzcKafkaMessageExecutor{
	
	private static final Log logger = LogFactory.getLog(ConfigUpdateExecutor.class);
	
	@Override
	public void execute(Object message) throws YyzcKafkaException {
		try {
			
			Cache cache = (Cache) message;
			//处理逻辑
			if(cache!=null && cache.getValue()!=null && StringUtils.isNotBlank(cache.getKey())){
				//cache.setExpired(b);
				//cache.setTimeOut(l);
				CacheManager.putCache(cache.getKey(), cache);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new YyzcKafkaException("处理消息时异常:"+e.getMessage());
		}
	}

	@Override
	public TypeReference<Cache> transferToObjectClass() throws Exception {
		try {
			TypeReference<Cache> tr = new TypeReference<Cache>() {};
			return tr;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new YyzcKafkaException("将消息json转成订单对象时异常:"+e.getMessage());
		}
	}

}
