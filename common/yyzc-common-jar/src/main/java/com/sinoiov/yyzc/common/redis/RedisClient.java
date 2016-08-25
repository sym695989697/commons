package com.sinoiov.yyzc.common.redis;

import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinoiov.yyzc.commons.redis.RedisCenter;
import com.sinoiov.yyzc.commons.redis.control.BasicControl;
import com.sinoiov.yyzc.commons.redis.exception.RedisException;
import com.sinoiov.yyzc.commons.redis.handle.DBManager;
import com.sinoiov.yyzc.commons.redis.handle.TableManager;

public class RedisClient {
	
	private static final Log logger = LogFactory.getLog(RedisClient.class);

	private static DBManager dbManager = null;
	
	private static ResourceBundle bundle = null;
	
	static {
		try {
			bundle = ResourceBundle.getBundle("redis");
			dbManager = RedisCenter.newRedisInstance(bundle.getString("REDIS_HOST"), Integer.valueOf(bundle.getString("REDIS_PORT")));
		} catch (RedisException e) {
			logger.error("连接redis失败！", e);
		}
	}
	
	public static BasicControl getControl(String dbName, String tableName) throws Exception {
		BasicControl control = null;
		try {
			TableManager tableManager = dbManager.selectDB(dbName);
			control = tableManager.selectTable(tableName);
		} catch (RedisException e) {
			// TODO: handle exception
			logger.error("连接redis失败！", e);
			throw new Exception(e);
		}
		return control;
	}
	
}
