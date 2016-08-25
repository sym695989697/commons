/**
 * @Title: Redis3ServiceImpl.java
 * @Prject: yyzc-redis-web
 * @Package: com.sinoiov.yyzc.commons.redis.web.service
 * @Copyright: Copyright © 2015. All rights reserved.
 * @Company: 中交兴路车联网
 *
 * @author: CSY
 * @date: 2015年12月3日 下午4:05:20
 * @version: V1.0
 */
package com.sinoiov.yyzc.commons.redis.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: Redis3ServiceImpl 
 * @Description: TODO
 * @author: CSY
 * @date: 2015年12月3日 下午4:05:20  
 */
public class Redis3ServiceImpl implements IService{
	
	private Logger logger = LoggerFactory.getLogger(Redis3ServiceImpl.class);

	/* (non Javadoc) 
	 * @Title: getAllTables
	 * @Description: TODO
	 * @return 
	 * @see com.sinoiov.yyzc.commons.redis.web.service.IService#getAllTables() 
	 */
	@Override
	public List<String> getAllTables() {
		// TODO Auto-generated method stub
		logger.info("", "");
		
		
		logger.info("", "");
		return null;
	}
	
}
