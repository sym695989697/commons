package com.sinoiov.yyzc.commons.redis.conn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sinoiov.yyzc.commons.redis.exception.RedisException;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

public class ConnectionFactory {

	public static ShardedJedisPool getShardedJedisPool(Map<String, String> map) throws RedisException {
		List<JedisShardInfo> jedisShardInfoList = new ArrayList<JedisShardInfo>();
		for (String name : map.keySet()) {
			String[] ip_port = ((String) map.get(name)).split(":");
			JedisShardInfo jedisShardInfo = new JedisShardInfo(ip_port[0], Integer.parseInt(ip_port[1]), name);
			jedisShardInfoList.add(jedisShardInfo);
		}

		ShardedJedisPool shardedJedisPool = new ShardedJedisPool(new JedisPoolConfig(), jedisShardInfoList, Hashing.MD5, Sharded.DEFAULT_KEY_TAG_PATTERN);
		return shardedJedisPool;
	}
	public static JedisPool getJedisPool(String host, int port) throws RedisException {
		return new JedisPool(new JedisPoolConfig(), host, port, 10000);
	}
	public static JedisCluster getJedisCluster(String host, int port) throws RedisException {
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort(host, port));
		return new JedisCluster(nodes);
	}
}
