package com.sinoiov.yyzc.common.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctfo.datacenter.cache.Constant;
import com.ctfo.datacenter.cache.exception.DataCenterException;
import com.ctfo.datacenter.cache.handle.CTFOCacheDB;
import com.ctfo.datacenter.cache.handle.CTFOCacheTable;
import com.ctfo.datacenter.cache.handle.CTFODBManager;
import com.ctfo.datacenter.cache.handle.DataCenter;

import net.sf.json.JSONObject;

public class DatacenterClient {

	private static final Log logger = LogFactory.getLog(DatacenterClient.class);

	private static CTFODBManager ctfoDBManager = null;

	private static ResourceBundle bundle = null;

	private static Map<String, CTFOCacheDB> dbMap = new HashMap<String, CTFOCacheDB>();

	private static Map<String, CTFOCacheTable> tableMap = new HashMap<String, CTFOCacheTable>();

	static {
		try {
			bundle = ResourceBundle.getBundle("redis");
			ctfoDBManager = DataCenter.newCTFOInstance(Constant.CACHE,
					bundle.getString("DATA_SOURCE"));
		} catch (DataCenterException e) {
			e.printStackTrace();
			logger.error("连接redis失败！", e);
		}
	}

	public static CTFODBManager getDBManager() {
		return ctfoDBManager;
	}

	/**
	 * 获取缓存表
	 * 
	 * @param dbName
	 *            数据库名称
	 * @param tableName
	 *            表名称
	 * @return
	 */
	public static CTFOCacheTable getDatacenterClient(String dbName,
			String tableName) {
		try {
			String key = dbName + '.' + tableName;
			if (!tableMap.containsKey(key)) {
				if (!dbMap.containsKey(dbName)) {
					CTFOCacheDB ctfoCacheDB = ctfoDBManager.openCacheDB(dbName);
					dbMap.put(dbName, ctfoCacheDB);
				}
				CTFOCacheTable ctfoCacheTable = dbMap.get(dbName).getTable(
						tableName);
				tableMap.put(key, ctfoCacheTable);
			}
			return tableMap.get(key);
		} catch (DataCenterException e) {
			e.printStackTrace();
			logger.error("redis 连接错误【getDataCenterClient】", e);
		}
		return null;
	}

	/**
	 * 缓存中插入Hash结构数据
	 * 
	 * @param hashName
	 * @param hashValue
	 * @param dbName
	 * @param tableName
	 * @throws Exception
	 */
	public static void insertCacheHash(String hashName,
			Map<String, String> hashValue, String dbName, String tableName)
			throws Exception {
		try {
			CTFOCacheTable cache = getDatacenterClient(dbName, tableName);
			cache.addHash(hashName, hashValue);
		} catch (Exception e) {
			logger.error("对象加入共享缓存发生错误【" + hashValue + "】", e);
			throw e;
		}
	}

	/**
	 * 把传入的对象转为JSON结构字符串并插入缓存
	 * 
	 * @param key
	 * @param obj
	 *            需要插入缓存的对象
	 * @param dbName
	 * @param tableName
	 * @throws Exception
	 */
	public static void insertCacheJSON(String key, Object obj, String dbName,
			String tableName) throws Exception {
		try {
			CTFOCacheTable cache = getDatacenterClient(dbName, tableName);
			cache.add(key, JSONObject.fromObject(obj).toString());
		} catch (Exception e) {
			logger.error("对象加入共享缓存发生错误【" + key + "】", e);
			throw e;
		}
	}
	
	public static void insertCacheString(String key, String s, String dbName,
			String tableName) throws Exception {
		try {
			CTFOCacheTable cache = getDatacenterClient(dbName, tableName);
			cache.add(key, s);
		} catch (Exception e) {
			logger.error("对象加入共享缓存发生错误【" + key + "】", e);
			throw e;
		}
	}

	/**
	 * 获取缓存中以JSON格式保存的对象
	 * 
	 * @param key
	 * @param clazz
	 *            转化后的对象类名称
	 * @param dbName
	 * @param tableName
	 * @return JSON转化为的对象
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Object getCacheJSON(String key, Class clazz, String dbName,
			String tableName) throws Exception {
		try {
			if (StringUtils.isBlank(key)) {
				return null;
			}
			CTFOCacheTable cache = getDatacenterClient(dbName, tableName);
			return JSONObject.toBean(JSONObject.fromObject(cache.query(key)),
					clazz);
		} catch (Exception e) {
			logger.error("从共享缓存读取对象发生错误【" + key + "】【" + clazz + "】", e);
			throw e;
		}
	}
	
	public static String getCacheString(String key, String dbName,
			String tableName) throws Exception {
		try {
			if (StringUtils.isBlank(key)) {
				return null;
			}
			CTFOCacheTable cache = getDatacenterClient(dbName, tableName);
			return cache.query(key);
		} catch (Exception e) {
			logger.error("从共享缓存读取对象发生错误【" + key + "】", e);
			throw e;
		}
	}

	/**
	 * 获取缓存的Hash结构数据
	 * 
	 * @param key
	 * @param dbName
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> getCacheHash(String key, String dbName,
			String tableName) throws Exception {
		try {
			CTFOCacheTable cache = getDatacenterClient(dbName, tableName);
			return cache.queryHash(key);
		} catch (Exception e) {
			logger.error("获取缓存发生错误【key:" + key + "】", e);
			throw e;
		}
	}

	/**
	 * 删除缓存
	 * 
	 * @param key
	 * @param dbName
	 * @param tableName
	 * @throws Exception
	 */
	public static void deleteFromCache(String key, String dbName,
			String tableName) throws Exception {
		try {
			CTFOCacheTable cache = getDatacenterClient(dbName, tableName);
			cache.delete(key);
		} catch (Exception e) {
			logger.error("从共享缓存删除对象发生错误【" + key + "】", e);
			throw e;
		}
	}

}