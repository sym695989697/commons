package com.sinoiov.yyzc.commons.redis;

import com.sinoiov.yyzc.commons.redis.Constant.LIST_REDIS_TYPE;
import com.sinoiov.yyzc.commons.redis.exception.RedisException;
import com.sinoiov.yyzc.commons.redis.handle.DBManager;
import com.sinoiov.yyzc.commons.redis.handle.DBManagerImpl;

public class RedisCenter {
	
	public static DBManager newRedisInstance(String host, int port) throws RedisException {
		return newRedisInstance(host, port, LIST_REDIS_TYPE.CLUSTER);
	}
	
	public static DBManager newRedisInstance(String host, int port, LIST_REDIS_TYPE type) throws RedisException {
		return new DBManagerImpl(host, port, type);
	}
	
}
