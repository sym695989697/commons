package com.sinoiov.yyzc.commons.config.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class CacheManager {

	private static HashMap<String, Object> cacheMap = new HashMap<String, Object>();

	// 单实例构造方法
	private CacheManager() {
		super();
	}

	// 获取布尔值的缓存
	public static boolean getSimpleFlag(String key) {
		try {
			return (Boolean) cacheMap.get(key);
		} catch (NullPointerException e) {
			return false;
		}
	}

	public static long getServerStartdt(String key) {
		try {
			return (Long) cacheMap.get(key);
		} catch (Exception ex) {
			return 0;
		}
	}

	// 设置布尔值的缓存
	public synchronized static boolean setSimpleFlag(String key, boolean flag) {
		if (flag && getSimpleFlag(key)) {// 假如为真不允许被覆盖
			return false;
		} else {
			cacheMap.put(key, flag);
			return true;
		}
	}

	public synchronized static boolean setSimpleFlag(String key,
			long serverbegrundt) {
		if (cacheMap.get(key) == null) {
			cacheMap.put(key, serverbegrundt);
			return true;
		} else {
			return false;
		}
	}

	// 得到缓存。同步静态方法
	private synchronized static Cache getCache(String key) {
		return (Cache) cacheMap.get(key);
	}

	// 判断是否存在一个缓存
	private synchronized static boolean hasCache(String key) {
		return cacheMap.containsKey(key);
	}

	// 清除所有缓存
	public synchronized static void clearAll() {
		cacheMap.clear();
	}

	// 清除某一类特定缓存, 通过遍历HASHMAP下的所有对象，来判断它的KEY与传入的TYPE是否匹配
	public synchronized static void clearAll(String type) {
		Iterator<Entry<String, Object>> i = cacheMap.entrySet().iterator();
		String key;
		ArrayList<String> arr = new ArrayList<String>();
		try {
			while (i.hasNext()) {
				Entry<String, Object> entry = i.next();
				key = (String) entry.getKey();
				if (key.startsWith(type)) { // 如果匹配则删除掉
					arr.add(key);
				}
			}
			for (int k = 0; k < arr.size(); k++) {
				clearOnly(arr.get(k));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 清除指定的缓存
	public synchronized static void clearOnly(String key) {
		cacheMap.remove(key);
	}

	// 载入缓存
	public synchronized static void putCache(String key, Cache obj) {
		if(hasCache(key))clearOnly(key);
		cacheMap.put(key, obj);
	}

	// 获取缓存信息
	public static Cache getCacheInfo(String key) {

		if (hasCache(key)) {
			Cache cache = getCache(key);
			if (cacheExpired(cache)) { // 调用判断是否终止方法
				cache.setExpired(true);
			}
			return cache;
		}
		return null;
	}

	// 载入缓存信息
	public static void putCacheInfo(String key, Cache obj, long dt,
			boolean expired) {
		Cache cache = new Cache();
		cache.setKey(key);
		cache.setTimeOut(dt + System.currentTimeMillis()); // 设置多久后更新缓存
		cache.setValue(obj);
		cache.setExpired(expired); // 缓存默认载入时，终止状态为FALSE
		cacheMap.put(key, cache);
	}

	// 重写载入缓存信息方法
	public static void putCacheInfo(String key, Cache obj, long dt) {
		Cache cache = new Cache();
		cache.setKey(key);
		cache.setTimeOut(dt + System.currentTimeMillis());
		cache.setValue(obj);
		cache.setExpired(false);
		cacheMap.put(key, cache);
	}

	// 判断缓存是否终止
	public static boolean cacheExpired(Cache cache) {
		if (null == cache) { // 传入的缓存不存在
			return false;
		}
		long nowDt = System.currentTimeMillis(); // 系统当前的毫秒数
		long cacheDt = cache.getTimeOut(); // 缓存内的过期毫秒数
		if (cacheDt <= 0 || cacheDt > nowDt) { // 过期时间小于等于零时,或者过期时间大于当前时间时，则为FALSE
			return false;
		} else { // 大于过期时间 即过期
			return true;
		}
	}

	// 获取缓存中的大小
	public static int getCacheSize() {
		return cacheMap.size();
	}

	// 获取指定的类型的大小
	public static int getCacheSize(String type) {
		int k = 0;
		Iterator<Entry<String, Object>> i = cacheMap.entrySet().iterator();
		String key;
		try {
			while (i.hasNext()) {
				Entry<String, Object> entry = i.next();
				key = (String) entry.getKey();
				if (key.indexOf(type) != -1) { // 如果匹配则删除掉
					k++;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return k;
	}

	// 获取缓存对象中的所有键值名称
	public static List<String> getCacheAllkey() {
		List<String> a = new ArrayList<String>();
		Iterator<Entry<String, Object>> i = cacheMap.entrySet().iterator();
		while (i.hasNext()) {
			Entry<String, Object> entry = (Entry<String, Object>) i.next();
			a.add((String) entry.getKey());
		}
		return a;
	}

	// 获取缓存对象中指定类型的键值名称
	public static List<String> getCacheListkey(String type) {
		List<String> a = new ArrayList<String>();
		String key;
		Iterator<Entry<String, Object>> i = cacheMap.entrySet().iterator();
		while (i.hasNext()) {
			Entry<String, Object> entry = i.next();
			key = (String) entry.getKey();
			if (key.indexOf(type) != -1) {
				a.add(key);
			}
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(CacheManager.getSimpleFlag("alksd"));
		CacheManager.putCache("abc", new Cache());
		CacheManager.putCache("def", new Cache());
		CacheManager.putCache("ccc", new Cache());
		CacheManager.clearOnly("");
		Cache c = new Cache();
		for (int i = 0; i < 10; i++) {
			CacheManager.putCache("" + i, c);
		}
		CacheManager.putCache("aaaaaaaa", c);
		CacheManager.putCache("abchcy;alskd", c);
		CacheManager.putCache("cccccccc", c);
		CacheManager.putCache("abcoqiwhcy", c);
		System.out.println("删除前的大小：" + CacheManager.getCacheSize());
		CacheManager.getCacheAllkey();
		CacheManager.clearAll("aaaa");
		System.out.println("删除后的大小：" + CacheManager.getCacheSize());
		CacheManager.getCacheAllkey();

	}

}