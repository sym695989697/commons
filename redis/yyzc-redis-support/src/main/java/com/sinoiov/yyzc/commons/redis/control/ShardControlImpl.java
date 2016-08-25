package com.sinoiov.yyzc.commons.redis.control;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Tuple;

import com.sinoiov.yyzc.commons.redis.conn.ConnectionFactory;
import com.sinoiov.yyzc.commons.redis.exception.RedisException;
import com.sinoiov.yyzc.commons.redis.message.ShardedSubManager;

public class ShardControlImpl implements BasicControl {
	
	private JedisPool jedisPool = null;
	private ShardedJedisPool shardedJedisPool = null;
	
	public ShardControlImpl() {
		
	}
	
	public ShardControlImpl(String host, int port) throws RedisException {
		this.initConnection(host, port);
		this.initShardedConnection(host, port);
	}
	
	private void initConnection(String host, int port) throws RedisException {
		this.jedisPool = ConnectionFactory.getJedisPool(host, port);
		ShardedSubManager.setShardedControlImpl(this);
		ShardedSubManager.initShardStatus(host, port, new String[] {"shardchannel"});
	}
	
	private void initShardedConnection(String host, int port) throws RedisException {
		String key = "cfg-sys-address";
		String oldKey = "cfg-sys-oldaddress";
		if(!ShardedSubManager.getShardStatus(host, port).equals("0")) {
			
		}else {
			
		}
	}
	
	@Override
	public void setKeyPreix(String tableName) throws RedisException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws RedisException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String type(String key) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delKey(String key) throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isKeyExist(String key) throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean expireKey(String key, String type, String unit, long time)
			throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean persistKey(String key) throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long ttlKey(String key) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean stringAppend(String key, String value) throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long stringDecr(String key, long number) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String stringGet(String key) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long stringIncr(String key, long number) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean stringSetMore(String key, String value, String nxxx,
			String expx, long time) throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stringSet(String key, String value) throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long stringValueLen(String key) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long hashDel(String key, String... fields) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hashExist(String key, String field) throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String hashGet(String key, String field) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> hashGetAll(String key) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long hashIncr(String key, String field, long number)
			throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<String> hashFields(String key) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long hashFieldLen(String key) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> hashMGet(String key, String... fields)
			throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hashMSet(String key, Map<String, String> map)
			throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hashSet(String key, String field, String value)
			throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hashSetNx(String key, String field, String value)
			throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> hashValues(String key) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listGet(String key, long index) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long listInsert(String key, String value, String beforeOrAfter,
			String pivot) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long listLen(String key) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String listPopHead(String key) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long listPushHead(String key, String... values)
			throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long listPushxHead(String key, String... values)
			throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> listRange(String key, long start, long end)
			throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean listRemove(String key, long count, String value)
			throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean listSet(String key, long index, String value)
			throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean listTrim(String key, long start, long end)
			throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String listPopTail(String key) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long listPushTail(String key, String... values)
			throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long listPushxTail(String key, String value)
			throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long setAdd(String key, String... values) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long setSize(String key) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean setIsMember(String key, String member) throws RedisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> setMembers(String key) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long setRemove(String key, String... members) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String setPop(String key) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> setRandMember(String key, int count) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long zAdd(String key, Map<String, Double> scoreMembers) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long zSize(String key) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long zCount(String key, double scoreMin, double scoreMax) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double zIncrby(String key, String member, double score) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<String> zRange(String key, int start, int end, boolean sort) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Tuple> zRangeWithScores(String key, int start, int end, boolean sort) throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> zRangeByScore(String key, double min, double max, boolean sort)
			throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Tuple> zRangeByScoreWithScores(String key, double min, double max, boolean sort)
			throws RedisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long zRank(String key, String member, boolean sort) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long zRemove(String key, String... members) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long zRemoveByRank(String key, long start, long stop) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long zRemoveByScore(String key, double min, double max) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double zScore(String key, String member) throws RedisException {
		// TODO Auto-generated method stub
		return 0;
	}

}
