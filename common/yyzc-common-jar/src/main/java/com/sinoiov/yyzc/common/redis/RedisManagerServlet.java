package com.sinoiov.yyzc.common.redis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctfo.datacenter.cache.Constant;
import com.ctfo.datacenter.cache.handle.CTFOCacheDB;
import com.ctfo.datacenter.cache.handle.CTFOCacheTable;
import com.ctfo.datacenter.cache.handle.CTFODBManager;
import com.ctfo.datacenter.cache.handle.DataCenter;

public class RedisManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Log logger = LogFactory.getLog(RedisManagerServlet.class);
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter outstream = null;
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
			outstream = resp.getWriter();
			String type = req.getParameter("type");
			String result = "";
			
			if(type == null) {
				result = "未知的操作";
			}else if(type.equals("1")) {//查询
				result = this.query(req);
			}else if(type.equals("2")) {//添加
				result = this.insert(req);
			}else if(type.equals("3")) {//删除
				result = this.delete(req);
			}
			outstream.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("操作redis缓存发生错误", e);
			outstream.println(e.getClass().getName() + ": " + ((e.getMessage() == null) ? "" : e.getMessage()));
			for(int i = 0 ; i < e.getStackTrace().length ; i++) {
				StackTraceElement trace = e.getStackTrace()[i];
				outstream.println("     " + trace.getClassName() + "." + trace.getMethodName() + "(" + trace.getFileName() + ":" + trace.getLineNumber() +")");
			}
			Throwable th = e.getCause();
			if(th != null) {
				outstream.println("Caused by: " + th.getClass().getName() + ": " + ((th.getMessage() == null) ? "" : th.getMessage()));
				for(int i = 0 ; i < th.getStackTrace().length ; i++) {
					StackTraceElement trace = th.getStackTrace()[i];
					outstream.println("     " + trace.getClassName() + "." + trace.getMethodName() + "(" + trace.getFileName() + ":" + trace.getLineNumber() +")");
				}
			}
		} finally {
			outstream.close();
		}
	}
	
	private String query(HttpServletRequest req) throws Exception {
		String ip = req.getParameter("ip");
		String key = req.getParameter("key");
		String tableName = req.getParameter("tableName");
		String dbName = req.getParameter("dbName");
		
		CTFODBManager ctfoDBManager = DataCenter.newCTFOInstance(Constant.CACHE, ip);
	    CTFOCacheDB ctfoCacheDB = ctfoDBManager.openCacheDB(dbName);
	    CTFOCacheTable ctfoCacheTable = ctfoCacheDB.getTable(tableName);
	    return ctfoCacheTable.query(key);
	}
	
	private String insert(HttpServletRequest req) throws Exception {
		String ip = req.getParameter("ip");
		String key = req.getParameter("key");
		String value = new String(req.getParameter("value").getBytes("ISO-8859-1"), "UTF-8");
		String tableName = req.getParameter("tableName");
		String dbName = req.getParameter("dbName");
		
		CTFODBManager ctfoDBManager = DataCenter.newCTFOInstance(Constant.CACHE, ip);
	    CTFOCacheDB ctfoCacheDB = ctfoDBManager.openCacheDB(dbName);
	    CTFOCacheTable ctfoCacheTable = ctfoCacheDB.getTable(tableName);
	    ctfoCacheTable.add(key, value);
	    return "添加成功";
	}
	
	private String delete(HttpServletRequest req) throws Exception {
		String ip = req.getParameter("ip");
		String key = req.getParameter("key");
		String tableName = req.getParameter("tableName");
		String dbName = req.getParameter("dbName");
		
		
		CTFODBManager ctfoDBManager = DataCenter.newCTFOInstance(Constant.CACHE, ip);
	    CTFOCacheDB ctfoCacheDB = ctfoDBManager.openCacheDB(dbName);
	    
		if(key == null && tableName == null && dbName != null){
			ctfoDBManager.deleteDB(dbName);
			return "清除所有数据的缓存成功";
		}
		if(key != null && tableName != null && dbName != null){
			CTFOCacheTable ctfoCacheTable = ctfoCacheDB.getTable(tableName);
			ctfoCacheTable.delete(key);
			return "清除" + tableName + "表的" + key + "缓存成功";
		}
		if(key == null && tableName != null && dbName != null) {
			ctfoCacheDB.deleteTable(tableName);
			return "清除" + tableName + "表的缓存成功";
		}
		return "未知的删除操作";
	}
}
