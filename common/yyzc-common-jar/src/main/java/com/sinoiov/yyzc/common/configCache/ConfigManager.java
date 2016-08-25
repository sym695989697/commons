package com.sinoiov.yyzc.common.configCache;

import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import com.sinoiov.yyzc.common.redis.DatacenterClient;
import com.sinoiov.yyzc.common.utils.EnvironmentUtil;

public class ConfigManager implements InitializingBean {
	
	private static String propertiesFile;
	
	private static String redis_db;
	
	private static String redis_table;
	
	private static Properties properties;
	
	private static ConfigAbstract configAbstract;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		try {
			//初始化本地文件的配置参数到缓存中
			properties = new EnvironmentUtil(getPropertiesFile()).getProperties();
			if(properties.isEmpty() == true) {
				System.out.println("加载配置文件" + getPropertiesFile() + "发生错误！");
			}else {
				for(Object o : properties.keySet()) {
					String key = (String) o;
					DatacenterClient.insertCacheString(key, properties.getProperty(key), getRedis_db(), getRedis_table());
				}
			}
			//初始化自定义方法的配置参数到缓存中
			if(getConfigAbstract() != null) {
				Map<String, String> map = getConfigAbstract().initValueFromOther();
				if(map != null) {
					for(String key : map.keySet()) {
						DatacenterClient.insertCacheString(key, map.get(key), getRedis_db(), getRedis_table());
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) throws Exception {
		String value = null;
		try {
			value = DatacenterClient.getCacheString(key, getRedis_db(), getRedis_table());//从缓存中读取
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(StringUtils.isBlank(value)) {
			if(getConfigAbstract() != null) {
				value = getConfigAbstract().getValueFromOther(key);//从自定义的方法里头读取
			}
			if(StringUtils.isBlank(value)) {
				value = properties.getProperty(key);//从本地文件中读取
			}
			if(StringUtils.isNotBlank(value)) {
				try {
					DatacenterClient.insertCacheString(key, value, getRedis_db(), getRedis_table());//放入缓存中
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	public static String getPropertiesFile() {
		return propertiesFile;
	}

	public static void setPropertiesFile(String propertiesFile) {
		ConfigManager.propertiesFile = propertiesFile;
	}

	public static String getRedis_db() {
		return redis_db;
	}

	public static void setRedis_db(String redis_db) {
		ConfigManager.redis_db = redis_db;
	}

	public static String getRedis_table() {
		return redis_table;
	}

	public static void setRedis_table(String redis_table) {
		ConfigManager.redis_table = redis_table;
	}

	public static ConfigAbstract getConfigAbstract() {
		return configAbstract;
	}

	public static void setConfigAbstract(ConfigAbstract configAbstract) {
		ConfigManager.configAbstract = configAbstract;
	}
}
