package com.sinoiov.yyzc.commons.config;

import org.apache.commons.lang.StringUtils;

import com.sinoiov.yyzc.commons.config.cache.Cache;
import com.sinoiov.yyzc.commons.config.cache.CacheManager;
import com.sinoiov.yyzc.commons.config.properties.PropertiesUtil;
import com.sinoiov.yyzc.commons.config.remote.RemoteManager;

public class ConfigHelper {
	
	public static final String CONFIG_SPACE = "___";
	
	/**
	 * 1.从缓存中取值
	 * 2.远程调用配置中心接口取值
	 * 3.从本地配置文件中取值
	 * @param key
	 * @return
	 */
	public static String get(String key){
		//从缓存中取值
		String value = null;
		Cache cache = getCache(key);
		if(cache!=null){
			value = (String)cache.getValue();
		}else{
			//远程从配置中心取值
			value = RemoteManager.get(key);
			if(StringUtils.isBlank(value)){//从配置文件中取值
				value = PropertiesUtil.getInstance().getPropertyValue(key);
			}
			//存入缓存中
			if(StringUtils.isNotBlank(value)){
				cache = new Cache();	
				cache.setKey(key);
				cache.setValue(value);
				//cache.setExpired(b);
				//cache.setTimeOut(l);
				CacheManager.putCache(key, cache);
			}
		}		
		return value;
	}
	/**
	 * 获到私有配置参数，私有配置以（关键字+分隔+标识）做为新的关键字
	 * @param key
	 * @param sign
	 * @return
	 */
	public static String get(String key, String sign){
		
		return StringUtils.isNotBlank(sign)?get(key+CONFIG_SPACE+sign):get(key);
	}
	
	public static Cache getCache(String key){
		
		return CacheManager.getCacheInfo(key);
	}
	public static Cache getCache(String key, String sign){
		
		return StringUtils.isNotBlank(sign)?getCache(key+CONFIG_SPACE+sign):getCache(key);
	}

	
}
