package com.sinoiov.yyzc.commons.redis;

public class Constant {
	public enum LIST_REDIS_TYPE {
		CLUSTER, SHARDED
	}
	
	public static final String DB_KEY = "sinoiov_redis_db_list";
	
	public static final String TABLE_KEY_PRE = "sinoiov_redis_table_list";
}
