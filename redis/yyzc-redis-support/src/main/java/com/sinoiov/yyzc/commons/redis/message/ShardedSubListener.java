package com.sinoiov.yyzc.commons.redis.message;

import redis.clients.jedis.JedisPubSub;

public class ShardedSubListener extends JedisPubSub {
	
	private String host = null;
	private int port = 0;
	
	public ShardedSubListener(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	@Override
	public void onMessage(String channel, String message) {
		// TODO Auto-generated method stub
		if(channel.equals("shardchannel")) {
			if("1".equals(message)) {
				ShardedSubManager.setShardStatus(host, port, "1");
			}else if("0".equals(message)) {
				ShardedSubManager.setShardStatus(host, port, "6");
			}else if("R".equals(message)) {
				ShardedSubManager.setShardStatus(host, port, "R");
			}
		}
	}
}
