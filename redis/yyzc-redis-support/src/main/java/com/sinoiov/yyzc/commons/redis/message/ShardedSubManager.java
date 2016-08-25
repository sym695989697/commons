package com.sinoiov.yyzc.commons.redis.message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sinoiov.yyzc.commons.redis.control.ShardControlImpl;
import com.sinoiov.yyzc.commons.redis.exception.RedisException;

public class ShardedSubManager {

	private static Map<String, String> map = new ConcurrentHashMap<String, String>();
	private static ShardControlImpl shardControlImpl = null;
	
	private static synchronized String init(String host, int port, String[] channels) throws RedisException {
		MessageSubManager messageSubManager = new MessageSubManager(host, port);
		String shardStatus = shardControlImpl.stringGet("cfg-sys-shardchannelstatus");
		if(shardStatus == null) {
			shardStatus = "0";
		}
		messageSubManager.sub(channels, new ShardedSubListener(host, port));
		map.put(host + ":" + port, shardStatus);
		return shardStatus;
	}

	public static String initShardStatus(String host, int port, String[] channels) throws RedisException {
		String shardstatus = (String) map.get(host + ":" + port);
		if (shardstatus == null) {
			return init(host, port, channels);
		}
		return shardstatus;
	}
	
	public static void setShardedControlImpl(ShardControlImpl impl) {
		shardControlImpl = impl;
	}

	public static void setShardStatus(String host, int port, String shardStatus) {
		map.put(host + ":" + port, shardStatus);
	}

	public static String getShardStatus(String host, int port) {
		return (String) map.get(host + ":" + port);
	}
}
