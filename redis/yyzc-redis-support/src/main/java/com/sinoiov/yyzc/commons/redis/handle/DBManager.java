package com.sinoiov.yyzc.commons.redis.handle;

import com.sinoiov.yyzc.commons.redis.exception.RedisException;

public abstract interface DBManager {
	
	public TableManager selectDB(String dbName) throws RedisException;
	
}
