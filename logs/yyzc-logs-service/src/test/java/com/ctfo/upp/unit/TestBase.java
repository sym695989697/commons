package com.ctfo.upp.unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 测试基类,主要用来加载spring xml文件
 * 
 * @author malongqing
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring-all.xml","classpath*:/spring-datasource.xml" })
public abstract class TestBase extends AbstractJUnit4SpringContextTests{
	
	@Resource
	protected BasicDataSource dataSource;
	protected Connection conn;
	protected PreparedStatement  stat;
	protected ResultSet rs;
	
	@Before
	public void setUp() throws Exception {
		conn = 	dataSource.getConnection();
		stat = conn.prepareStatement("SELECT 1 FROM DUAL");
		stat.execute();
	}
	
	@After
	public void destroy() throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(stat!=null){
			stat.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	
}
