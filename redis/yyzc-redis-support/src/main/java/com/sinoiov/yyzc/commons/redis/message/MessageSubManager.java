package com.sinoiov.yyzc.commons.redis.message;

import com.sinoiov.yyzc.commons.redis.conn.ConnectionFactory;
import com.sinoiov.yyzc.commons.redis.exception.RedisException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

public class MessageSubManager extends Thread {
	
	private JedisPool jedisPool = null;
	
	public MessageSubManager(String host, int port) throws RedisException {
		this.jedisPool = ConnectionFactory.getJedisPool(host, port);
	}
	public void sub(final String[] channels, final JedisPubSub jedisPubSub) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Jedis jedis = null;
				try {
					jedis = jedisPool.getResource();
					jedis.subscribe(jedisPubSub, channels);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					if(jedis != null) {
						jedisPool.returnResource(jedis);
					}
				}
			}
		}).start();
	}
}
