package com.sinoiov.yyzc.commons.kafka.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <h3>EnvironmentUtil</h3>
 * <h4>配置文件的基本操作</h4>
 * <h4>Special Notes</h4>
 * 
 * @ver 0.1
 * @author tommy
 */
public class EnvironmentUtil
{

	private Properties propertie;

	private InputStream inputFile;

	private FileOutputStream outputFile;

	private static Map<String,EnvironmentUtil> ecMap = new HashMap<String,EnvironmentUtil>();
	
	private final static String ENVIRONMENT_PROPERTIES_PATH = "system.properties";

	public EnvironmentUtil()
	{
		this(ENVIRONMENT_PROPERTIES_PATH);
	}

	/**
	 * 
	 * @param filePath
	 */
	public EnvironmentUtil(String filePath)
	{
		loaderProperties( filePath );
	}

	private synchronized void loaderProperties(String filePath)
	{
		propertie = new Properties();
		setProperties( filePath );
	}


	/**
	 * 获得唯一的EnvironmentUtil实例
	 * @param filePath
	 * @return
	 */
	public static EnvironmentUtil getInstance(String filePath)
	{
		EnvironmentUtil ec;
		if(ecMap.get(filePath) == null){
			ec = new EnvironmentUtil(filePath);
			ecMap.put(filePath, ec);
		}else{
			ec = ecMap.get(filePath);
		}
		return ec;
	}
	
	
	/**
	 * 获得唯一的EnvironmentUtil实例
	 * 
	 * @return
	 */
	public  static EnvironmentUtil getInstance()
	{
		EnvironmentUtil ec;
		if(ecMap.get(ENVIRONMENT_PROPERTIES_PATH) == null){
			ec = new EnvironmentUtil(ENVIRONMENT_PROPERTIES_PATH);
			ecMap.put(ENVIRONMENT_PROPERTIES_PATH, ec);
		}else{
			ec = ecMap.get(ENVIRONMENT_PROPERTIES_PATH);
		}
		return ec;
	}

	public synchronized void refresh(String filePath)
	{
		if ( filePath == null || "".equals( filePath ) )
			loaderProperties( ENVIRONMENT_PROPERTIES_PATH );
		else
			loaderProperties( filePath );
	}

	public synchronized void refresh()
	{
		refresh("");
	}

	public Properties getProperties()
	{
		if ( propertie == null ){
			propertie = new Properties();
		}
		return propertie;
	}

	/**
	 * 装载配置文件
	 * 
	 * @param filePath
	 * 要读取的配置文件的路径+名称
	 */
	private void setProperties(String filePath)
	{
		try
		{
			try
			{
				inputFile = new FileInputStream( filePath );
			} catch ( Exception e )
			{
				// getResourceAsStream()方法获取相对路径
				if ( filePath.startsWith( "/" ) )
					inputFile = EnvironmentUtil.class.getResourceAsStream( filePath );
				else
					inputFile = EnvironmentUtil.class.getResourceAsStream( "/" + filePath );
			}
			propertie.load( inputFile );
			inputFile.close();
		} catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	/** */
	/**
	 * 获得键值
	 * 
	 * @param key
	 * 取得其值的键
	 * @return key的值
	 */
	public String getPropertyValue(String key)
	{
		if ( propertie.containsKey( key ) )
		{
			// 得到某一属性的值
			String value = propertie.getProperty( key );
			return value;
		} else
			return "";
	}

	/**
	 * 直接通过指定文件获得相应的键值
	 * 
	 * @param fileName
	 * @param key
	 * @return
	 */
	public String getPropertyValue(String fileName, String key)
	{
		setProperties( fileName );
		String value = "";

		if ( propertie.containsKey( key ) )
			value = propertie.getProperty( key );

		return value;
	}

	/**
	 * 清除properties文件中所有的key和其值
	 */
	public void clear()
	{
		if ( propertie != null )
			propertie.clear();
	}

	/**
	 * 改变或添加一个key的值，当key存在于properties文件中时该key的值被value所代替， 当key不存在时，该key的值是value
	 * 
	 * @param key
	 * 要存入的键
	 * @param value
	 * 要存入的值
	 */
	public void setValue(String key, String value)
	{
		propertie.setProperty( key, value );
	}

	/**
	 * 将更改后的文件数据存入指定的文件中，该文件可以事先不存在。
	 * 
	 * @param fileName
	 * 文件路径+文件名称
	 * @param description
	 * 对该文件的描述
	 */
	public void saveFile(String fileName, String description)
	{
		try
		{
			outputFile = new FileOutputStream( fileName );
			propertie.store( outputFile, description );
			outputFile.close();
		} catch ( FileNotFoundException e )
		{
			e.printStackTrace();
		} catch ( IOException ioe )
		{
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		// System.out.println(n(n(n(EnvironmentUtil.getInstance().getPropertyValue("aaaaa"));
	}
}
