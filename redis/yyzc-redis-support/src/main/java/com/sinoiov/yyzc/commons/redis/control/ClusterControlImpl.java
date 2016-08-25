package com.sinoiov.yyzc.commons.redis.control;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.Tuple;

import com.sinoiov.yyzc.commons.redis.conn.ConnectionFactory;
import com.sinoiov.yyzc.commons.redis.exception.RedisException;

public class ClusterControlImpl implements BasicControl {
	
	private JedisCluster jc = null;
	private String keyPre = "";
	
	public ClusterControlImpl() {
		
	}
	
	public ClusterControlImpl(String host, int port)  throws RedisException  {
		this.jc = ConnectionFactory.getJedisCluster(host, port);
	}
	
	@Override
	public void setKeyPreix(String tableName) throws RedisException {
		// TODO Auto-generated method stub
		keyPre = tableName;
	}

	@Override
	public void close() throws RedisException {
		// TODO Auto-generated method stub
		try {
			jc.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}
	
	@Override
	public String type(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.type(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}
	
	@Override
	public boolean delKey(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(jc.del(keyPre + key) != 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}
	
	@Override
	public boolean isKeyExist(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.exists(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}
	
	@Override
	public boolean expireKey(String key, String type, String unit, long time) throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(type.equals("1")) {
				if(unit.equals("1")) {
					if(jc.expire(keyPre + key, (int) time) == 1) {
						return true;
					}else {
						return false;
					}
				}else {
					if(jc.pexpire(keyPre + key, (int) time) == 1) {
						return true;
					}else {
						return false;
					}
				}
			}else if(type.equals("2")) {
				if(unit.equals("1")) {
					if(jc.expireAt(keyPre + key, time) == 1) {
						return true;
					}else {
						return false;
					}
				}else {
					if(jc.pexpireAt(keyPre + key, time) == 1) {
						return true;
					}else {
						return false;
					}
				}
			}else {
				throw new Exception("type is illegal");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}
	
	@Override
	public boolean persistKey(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(jc.persist(keyPre + key) == 1) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}
	
	@Override
	public long ttlKey(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.ttl(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean stringAppend(String key, String value) throws RedisException {
		// TODO Auto-generated method stub
		try {
			jc.append(keyPre + key, value);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long stringDecr(String key, long number) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.decrBy(keyPre + key, number);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public String stringGet(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.get(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long stringIncr(String key, long number) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.incrBy(keyPre + key, number);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean stringSetMore(String key, String value, String nxxx,
			String expx, long time) throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(nxxx != null) {
				nxxx = (nxxx.equals("1")) ? "XX" : "NX";
			}
			if(expx != null) {
				expx = (expx.equals("1")) ? "EX" : "PX";
			}
			String result = jc.set(keyPre + key, value, nxxx, expx, time);
			if(result == null) {
				return false;
			}
			if(result.equalsIgnoreCase("ok")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean stringSet(String key, String value) throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(jc.set(keyPre + key, value).equalsIgnoreCase("ok")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long stringValueLen(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.strlen(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long hashDel(String key, String... fields) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.hdel(keyPre + key, fields);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean hashExist(String key, String field) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.hexists(keyPre + key, field);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public String hashGet(String key, String field) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.hget(keyPre + key, field);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public Map<String, String> hashGetAll(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.hgetAll(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long hashIncr(String key, String field, long number)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.hincrBy(keyPre + key, field, number);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public Set<String> hashFields(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.hkeys(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long hashFieldLen(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.hlen(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public List<String> hashMGet(String key, String... fields) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.hmget(keyPre + key, fields);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean hashMSet(String key, Map<String, String> map)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(jc.hmset(keyPre + key, map).equalsIgnoreCase("ok")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean hashSet(String key, String field, String value)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			jc.hset(keyPre + key, field, value);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean hashSetNx(String key, String field, String value)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(jc.hsetnx(keyPre + key, field, value) == 1) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public List<String> hashValues(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.hvals(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public String listGet(String key, long index) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.lindex(keyPre + key, index);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long listInsert(String key, String value, String beforeOrAfter,
			String pivot) throws RedisException {
		// TODO Auto-generated method stub
		try {
			LIST_POSITION where =(beforeOrAfter.equals("1")) ? LIST_POSITION.BEFORE : LIST_POSITION.AFTER;
			return jc.linsert(keyPre + key, where, pivot, value);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long listLen(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.llen(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public String listPopHead(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.lpop(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long listPushHead(String key, String... values) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.lpush(keyPre + key, values);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long listPushxHead(String key, String... values) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.lpushx(keyPre + key, values);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public List<String> listRange(String key, long start, long end)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.lrange(keyPre + key, start, end);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean listRemove(String key, long count, String value)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(jc.lrem(keyPre + key, count, value) > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean listSet(String key, long index, String value)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(jc.lset(keyPre + key, index, value).equalsIgnoreCase("ok")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean listTrim(String key, long start, long end)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(jc.ltrim(keyPre + key, start, end).equalsIgnoreCase("ok")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public String listPopTail(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.rpop(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long listPushTail(String key, String... values)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.rpush(keyPre + key, values);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long listPushxTail(String key, String value)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.rpushx(keyPre + key, value);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long setAdd(String key, String... values) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.sadd(keyPre + key, values);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long setSize(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.scard(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public boolean setIsMember(String key, String member) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.sismember(keyPre + key, member);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public Set<String> setMembers(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.smembers(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long setRemove(String key, String... members)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.srem(keyPre + key, members);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public String setPop(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.spop(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public List<String> setRandMember(String key, int count) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.srandmember(keyPre + key, count);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long zAdd(String key, Map<String, Double> scoreMembers) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.zadd(keyPre + key, scoreMembers);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long zSize(String key) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.zcard(keyPre + key);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long zCount(String key, double scoreMin, double scoreMax) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.zcount(keyPre + key, scoreMin, scoreMax);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public double zIncrby(String key, String member, double score) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.zincrby(keyPre + key, score, member);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public Set<String> zRange(String key, int start, int end, boolean sort) throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(sort == true) {
				return jc.zrange(keyPre + key, start, end);
			}else {
				return jc.zrevrange(keyPre + key, start, end);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public Set<Tuple> zRangeWithScores(String key, int start, int end, boolean sort) throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(sort == true) {
				return jc.zrangeWithScores(keyPre + key, start, end);
			}else {
				return jc.zrevrangeWithScores(keyPre + key, start, end);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public Set<String> zRangeByScore(String key, double min, double max, boolean sort)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(sort == true) {
				return jc.zrangeByScore(keyPre + key, min, max);
			}else {
				return jc.zrevrangeByScore(keyPre + key, min, max);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public Set<Tuple> zRangeByScoreWithScores(String key, double min, double max, boolean sort)
			throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(sort == true) {
				return jc.zrangeByScoreWithScores(keyPre + key, min, max);
			}else {
				return jc.zrevrangeByScoreWithScores(keyPre + key, min, max);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long zRank(String key, String member, boolean sort) throws RedisException {
		// TODO Auto-generated method stub
		try {
			if(sort == true) {
				return jc.zrank(keyPre + key, member);
			}else {
				return jc.zrevrank(keyPre + key, member);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long zRemove(String key, String... members) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.zrem(keyPre + key, members);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long zRemoveByRank(String key, long start, long end) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.zremrangeByRank(keyPre + key, start, end);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public long zRemoveByScore(String key, double min, double max) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.zremrangeByScore(keyPre + key, min, max);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}

	@Override
	public double zScore(String key, String member) throws RedisException {
		// TODO Auto-generated method stub
		try {
			return jc.zscore(keyPre + key, member);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RedisException(e);
		}
	}
}
