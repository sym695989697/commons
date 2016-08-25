package com.sinoiov.yyzc.common.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctfo.file.boss.IMongoService;
import com.sinoiov.yyzc.common.utils.SpringBUtils;

public class LogServiceUtils {
	
	protected static final Log log = LogFactory.getLog(LogServiceUtils.class);
			
	private static IMongoService mongoService = null;
	
	private static ExecutorService es = null;
	
	public static void saveLog(final Object obj) {
		try {
			if(mongoService == null) {
				mongoService = (IMongoService)SpringBUtils.getBean("mongoService");
				mongoService.setDatasource("LOGS");
			}
			if(es == null) {
				es = Executors.newFixedThreadPool(5);
			}
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						mongoService.save(obj);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.error(">>>>>>>>>> 存储日志发生错误  <<<<<<<<<<", e);
					}
				}
			});
		} catch (Exception e) {
			log.error(">>>>>>>>>> 记录日志发生错误  <<<<<<<<<<", e);
		}
	}
	

}
