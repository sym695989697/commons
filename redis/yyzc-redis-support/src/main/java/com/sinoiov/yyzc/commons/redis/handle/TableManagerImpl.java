package com.sinoiov.yyzc.commons.redis.handle;

import com.sinoiov.yyzc.commons.redis.Constant;
import com.sinoiov.yyzc.commons.redis.control.BasicControl;
import com.sinoiov.yyzc.commons.redis.exception.RedisException;

public class TableManagerImpl implements TableManager {
	
	private BasicControl control = null;
	private String dbName = null;
	
	public TableManagerImpl() {
		
	}
	
	public TableManagerImpl(BasicControl control, String dbName) {
		this.control = control;
		this.dbName = dbName;
	}

	@Override
	public BasicControl selectTable(String tableName) throws RedisException {
		// TODO Auto-generated method stub
		this.control.setAdd(Constant.TABLE_KEY_PRE + "-" + this.dbName, tableName);
		this.control.setKeyPreix(this.dbName + "-" + tableName + "-");
		return this.control;
	}
	
}
