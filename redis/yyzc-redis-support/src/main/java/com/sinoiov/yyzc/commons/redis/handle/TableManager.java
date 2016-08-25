package com.sinoiov.yyzc.commons.redis.handle;

import com.sinoiov.yyzc.commons.redis.control.BasicControl;
import com.sinoiov.yyzc.commons.redis.exception.RedisException;

public interface TableManager {
	
	public BasicControl selectTable(String tableName) throws RedisException;
}
