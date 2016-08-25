package com.sinoiov.yyzc.commons.redis.handle;

import com.sinoiov.yyzc.commons.redis.Constant;
import com.sinoiov.yyzc.commons.redis.Constant.LIST_REDIS_TYPE;
import com.sinoiov.yyzc.commons.redis.control.BasicControl;
import com.sinoiov.yyzc.commons.redis.control.ClusterControlImpl;
import com.sinoiov.yyzc.commons.redis.control.ShardControlImpl;
import com.sinoiov.yyzc.commons.redis.exception.RedisException;

public class DBManagerImpl implements DBManager {
	
	private BasicControl control = null;
	
	public DBManagerImpl() {
		
	}
	
	public DBManagerImpl(String host, int port, LIST_REDIS_TYPE type) throws RedisException {
		if(type.name().equals("CLUSTER")) {
			this.control = new ClusterControlImpl(host, port);
		}
		if(type.name().equals("SHARDED")) {
			this.control = new ShardControlImpl(host, port);
		}
	}

	@Override
	public TableManager selectDB(String dbName) throws RedisException {
		// TODO Auto-generated method stub
		this.control.setAdd(Constant.DB_KEY, dbName);
		return new TableManagerImpl(control, dbName);
	}

}
