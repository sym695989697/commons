package com.sinoiov.yyzc.commons.redis.control;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sinoiov.yyzc.commons.redis.exception.RedisException;

import redis.clients.jedis.Tuple;

public interface BasicControl {
	
	public void setKeyPreix(String tableName) throws RedisException;
	
	//base manager
	/**
	 * 关闭redis连接
	 * @throws RedisException
	 */
	public void close() throws RedisException;
	/**
	 * 查询key的类型
	 * @param key
	 * @return 返回类型
	 * @throws RedisException
	 */
	public String type(String key) throws RedisException;
	/**
	 * 删除key
	 * @param key
	 * @return true：操作成功，false：key不存在
	 * @throws RedisException
	 */
	public boolean delKey(String key) throws RedisException;
	/**
	 * 查询key是否存在
	 * @param key
	 * @return true：存在，false：不存在
	 * @throws RedisException
	 */
	public boolean isKeyExist(String key) throws RedisException;
	/**
	 * 设置key的过期时间
	 * @param key
	 * @param type 1：标准时间戳，2：unix时间戳
	 * @param unit 1: 秒，2：毫秒
	 * @param time
	 * @return true：操作成功，false：key不存在
	 * @throws RedisException
	 */
	public boolean expireKey(String key, String type, String unit, long time) throws RedisException;
	/**
	 * 移除key的过期时间
	 * @param key
	 * @return true：操作成功，false：key不存在或 key没有设置生存时间
	 * @throws RedisException
	 */
	public boolean persistKey(String key) throws RedisException;
	/**
	 * 获取key当前剩余的过期时间
	 * @param key
	 * @return -2：key不存在，-1：key没有设置过期时间，否则返回时间，单位是秒
	 * @throws RedisException
	 */
	public long ttlKey(String key) throws RedisException;
	
	//string manager
	/**
	 * 追加key对应的值的内容
	 * @param key
	 * @param value
	 * @return true：成功，false：失败
	 * @throws RedisException
	 */
	public boolean stringAppend(String key, String value) throws RedisException;
	/**
	 * 将key中储存的数字值减去某数值
	 * @param key
	 * @param number
	 * @return 操作之后key的值
	 * @throws RedisException key对应的值类型不正确
	 */
	public long stringDecr(String key, long number) throws RedisException;
	/**
	 * 获取key的值
	 * @param key
	 * @return key的值，key不存在返回null
	 * @throws RedisException
	 */
	public String stringGet(String key) throws RedisException;
	/**
	 * 将key中储存的数字值加上某数值
	 * @param key
	 * @param number
	 * @return 操作之后key的值
	 * @throws RedisException key对应的值类型不正确
	 */
	public long stringIncr(String key, long number) throws RedisException;
	/**
	 * 设置key的值
	 * @param key
	 * @param value
	 * @param nxxx 1：key存在的情况下才操作，2：key不存在的情况下才操作
	 * @param expx 1：过期时间单位是秒，2：过期时间单位是毫秒
	 * @param time 过期时间
	 * @return true：成功，false：失败
	 * @throws RedisException
	 */
	public boolean stringSetMore(String key, String value, String nxxx, String expx, long time) throws RedisException;
	/**
	 * 设置key的值
	 * @param key
	 * @param value
	 * @return true：成功，false：失败
	 * @throws RedisException
	 */
	public boolean stringSet(String key, String value) throws RedisException;
	/**
	 * 返回key对应的值的长度
	 * @param key
	 * @return 长度
	 * @throws RedisException
	 */
	public long stringValueLen(String key) throws RedisException;
	
	//hash manager
	/**
	 * 删除key对应的hash表中的多个指定域
	 * @param key
	 * @param field 支持多个
	 * @return 删除的个数
	 * @throws RedisException
	 */
	public long hashDel(String key, String... fields) throws RedisException;
	/**
	 * 查询key对应的hash表中是否存在指定域field
	 * @param key
	 * @param field
	 * @return true：存在，false：不存在
	 * @throws RedisException
	 */
	public boolean hashExist(String key, String field) throws RedisException;
	/**
	 * 查询key对应的hash表中指定域field的内容
	 * @param key
	 * @param field
	 * @return key或者field不存在，返回null
	 * @throws RedisException
	 */
	public String hashGet(String key, String field) throws RedisException;
	/**
	 * 查询key对应的hash表中的所有指定域和内容
	 * @param key
	 * @return key不存在，返回null
	 * @throws RedisException
	 */
	public Map<String, String> hashGetAll(String key) throws RedisException;
	/**
	 * 将key对应的hash表的指定域field加上number数值
	 * @param key
	 * @param field
	 * @param number
	 * @return 操作之后key的值
	 * @throws RedisException field对应的值类型不正确
	 */
	public long hashIncr(String key, String field, long number) throws RedisException;
	/**
	 * 返回key对应的hash表的所有指定域
	 * @param key
	 * @return key不存在返回null
	 * @throws Exception
	 */
	public Set<String> hashFields(String key) throws RedisException;
	/**
	 * 返回key对应的hash表的所有指定域的长度
	 * @param key
	 * @return key不存在返回0
	 * @throws Exception
	 */
	public long hashFieldLen(String key) throws RedisException;
	/**
	 * 返回key对应的hash表的多个指定域的内容
	 * @param key
	 * @param field 支持多个
	 * @return key不存在返回null
	 * @throws Exception
	 */
	public List<String> hashMGet(String key, String... fields) throws RedisException;
	/**
	 * 设置key对应的hash表的多个指定域的内容
	 * @param key
	 * @param map
	 * @return true：成功，false：失败
	 * @throws RedisException
	 */
	public boolean hashMSet(String key, Map<String, String> map) throws RedisException;
	/**
	 * 设置key对应的hash表的指定域的内容
	 * @param key
	 * @param field
	 * @param value
	 * @return true：成功，false：失败
	 * @throws RedisException
	 */
	public boolean hashSet(String key, String field, String value) throws RedisException;
	/**
	 * 设置key对应的hash表的指定域的内容，当且仅当指定域不存在
	 * @param key
	 * @param field
	 * @param value
	 * @return true：成功，false：指定域已经存在
	 * @throws RedisException
	 */
	public boolean hashSetNx(String key, String field, String value) throws RedisException;
	/**
	 * 返回key对应的hash表的所有指定域的所有值
	 * @param key
	 * @return key不存在返回null
	 * @throws Exception
	 */
	public List<String> hashValues(String key) throws RedisException;
	
	//list manager
	/**
	 * 返回key对应的list表中坐标为index的内容
	 * @param key
	 * @param index
	 * @return key不存在或者index超过列表范围，则返回null
	 * @throws RedisException
	 */
	public String listGet(String key, long index) throws RedisException;
	/**
	 * 往key对应的list中指定值的前后插入内容
	 * @param key
	 * @param value
	 * @param beforeOrAfter 1：之前，2：之后
	 * @param pivot
	 * @return 0：key对应的list不存在，-1：指定值不存在，否则返回list的大小
	 * @throws RedisException
	 */
	public long listInsert(String key, String value, String beforeOrAfter, String pivot) throws RedisException;
	/**
	 * 放回key对应的list的长度
	 * @param key
	 * @return key不存在，返回0
	 * @throws RedisException
	 */
	public long listLen(String key) throws RedisException;
	/**
	 * 移除并返回key对应的list的头元素
	 * @param key
	 * @return key不存在，返回null
	 * @throws RedisException
	 */
	public String listPopHead(String key) throws RedisException;
	/**
	 * 将一个或多个值从列表头插入到key对应的list中
	 * @param key
	 * @param values 支持多个值
	 * @return 插入值后list的大小
	 * @throws RedisException
	 */
	public long listPushHead(String key, String... values) throws RedisException;
	/**
	 * 当key对应的list存在的情况下，将一个或多个值从列表头进行插入
	 * @param key
	 * @param values 支持多个值
	 * @return key对应的list不存在，返回0
	 * @throws RedisException
	 */
	public long listPushxHead(String key, String... values) throws RedisException;
	/**
	 * 返回key对应的list中区间为start到end的值
	 * @param key
	 * @param start 大于等于，从0开始
	 * @param end 小于等于
	 * @return
	 * @throws RedisException
	 */
	public List<String> listRange(String key, long start, long end) throws RedisException;
	/**
	 * 根据count的值，移除key对应的list中与value相等的元素
	 * @param key
	 * @param count >0：从表头开始遍历，<0：从表尾开始遍历，=0：移除所有
	 * @param value
	 * @return
	 * @throws RedisException
	 */
	public boolean listRemove(String key, long count, String value) throws RedisException;
	/**
	 * 将key对应的list的坐标index的元素值设置为value
	 * @param key
	 * @param index
	 * @param value
	 * @return
	 * @throws RedisException
	 */
	public boolean listSet(String key, long index, String value) throws RedisException;
	/**
	 * 删除key对应的list在start到end之外元素
	 * @param key
	 * @param start 大于等于，从0开始
	 * @param end 小于等于
	 * @return
	 * @throws RedisException
	 */
	public boolean listTrim(String key, long start, long end) throws RedisException;
	/**
	 * 移除并返回key对应的list的尾元素
	 * @param key
	 * @return key不存在，返回null
	 * @throws RedisException
	 */
	public String listPopTail(String key) throws RedisException;
	/**
	 * 将一个或多个值从列表尾插入到key对应的list中
	 * @param key
	 * @param values 支持多个值
	 * @return 插入值后list的大小
	 * @throws RedisException
	 */
	public long listPushTail(String key, String... values) throws RedisException;
	/**
	 * 当key对应的list存在的情况下，将一个或多个值从列表尾进行插入
	 * @param key
	 * @param values 支持多个值
	 * @return key对应的list不存在，返回0
	 * @throws RedisException
	 */
	public long listPushxTail(String key, String value) throws RedisException;
	
	//set manager
	/**
	 * 将一个或者多个值插入到key对应的set中
	 * @param key
	 * @param values
	 * @return key对应的set的大小
	 * @throws RedisException
	 */
	public long setAdd(String key, String... values) throws RedisException;
	/**
	 * 返回key对应的set的大小
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public long setSize(String key) throws RedisException;
	/**
	 * 判断member是否是key对应的set的成员
	 * @param key
	 * @param member
	 * @return
	 * @throws RedisException
	 */
	public boolean setIsMember(String key, String member) throws RedisException;
	/**
	 * 返回key对应的set的所有成员
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public Set<String> setMembers(String key) throws RedisException;
	/**
	 * 移除key对应的set中的一个或者多个member
	 * @param key
	 * @param members
	 * @return 成功移除的数量
	 * @throws RedisException
	 */
	public long setRemove(String key, String... members) throws RedisException;
	/**
	 * 移除并返回集合中的一个随机元素
	 * @param key
	 * @return 集合中的随机元素
	 * @throws RedisException
	 */
	public String setPop(String key) throws RedisException;
	/**
	 * 返回集合中指定个数的随机元素
	 * @param key
	 * @return 集合中的随机元素
	 * @throws RedisException
	 */
	public List<String> setRandMember(String key, int count) throws RedisException;
	
	//sortedset manager
	/**
	 * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中
	 * @param key
	 * @param scoreMembers
	 * @return 操作成功数
	 * @throws RedisException
	 */
	public long zAdd(String key, Map<String, Double> scoreMembers) throws RedisException;
	/**
	 * 查询有序集的大小
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public long zSize(String key) throws RedisException;
	/**
	 * 查询有序集中指定score范围内的数量
	 * @param key
	 * @param scoreMin 包含
	 * @param scoreMax 包含
	 * @return
	 * @throws RedisException
	 */
	public long zCount(String key, double scoreMin, double scoreMax) throws RedisException;
	/**
	 * 为有序集内的对象member增加指定的score值
	 * @param key
	 * @param member
	 * @param score
	 * @return member对象的新score值
	 * @throws RedisException
	 */
	public double zIncrby(String key, String member, double score) throws RedisException;
	/**
	 * 返回有序集key中，指定区间内的成员
	 * @param key
	 * @param start
	 * @param stop
	 * @param sort true：从小到大，false：从大到小
	 * @return
	 * @throws RedisException
	 */
	public Set<String> zRange(String key, int start, int end, boolean sort) throws RedisException;
	/**
	 * 返回有序集key中，指定区间内的成员（包含score）
	 * @param key
	 * @param start
	 * @param stop
	 * @param sort true：从小到大，false：从大到小
	 * @return
	 * @throws RedisException
	 */
	public Set<Tuple> zRangeWithScores(String key, int start, int end, boolean sort) throws RedisException;
	/**
	 * 返回有序集key中，score在指定区间内的成员
	 * @param key
	 * @param start
	 * @param end
	 * @param sort true：从小到大，false：从大到小
	 * @return
	 * @throws RedisException
	 */
	public Set<String> zRangeByScore(String key, double min, double max, boolean sort) throws RedisException;
	/**
	 * 返回有序集key中，score在指定区间内的成员（包含score）
	 * @param key
	 * @param start
	 * @param end
	 * @param sort true：从小到大，false：从大到小
	 * @return
	 * @throws RedisException
	 */
	public Set<Tuple> zRangeByScoreWithScores(String key, double min, double max, boolean sort) throws RedisException;
	/**
	 * 返回有序集中member对象的排名
	 * @param key
	 * @param member
	 * @param sort true：从小到大，false：从大到小
	 * @return 从0开始
	 * @throws RedisException
	 */
	public long zRank(String key, String member, boolean sort) throws RedisException;
	/**
	 * 移除有序集中指定的多个对象
	 * @param key
	 * @param members
	 * @return 操作成功的数量
	 * @throws RedisException
	 */
	public long zRemove(String key, String... members) throws RedisException;
	/**
	 * 移除有序集内指定排名区间内的所有对象
	 * @param key
	 * @param start
	 * @param stop
	 * @return 操作成功的数量
	 * @throws RedisException
	 */
	public long zRemoveByRank(String key, long start, long stop) throws RedisException;
	/**
	 * 移除有序集key中，所有score值介于min和max之间(包括等于min或max)的成员
	 * @param key
	 * @param min 包含
	 * @param max 包含
	 * @return 操作成功的数量
	 * @throws RedisException
	 */
	public long zRemoveByScore(String key, double min, double max) throws RedisException;
	/**
	 * 查询有序集中member对象的score值
	 * @param key
	 * @param member
	 * @return
	 * @throws RedisException
	 */
	public double zScore(String key, String member) throws RedisException;
}
