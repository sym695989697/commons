package com.sinoiov.yyzc.commons.mongodb.supports;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.sinoiov.yyzc.commons.mongodb.datasources.Datasource;
import com.sinoiov.yyzc.commons.mongodb.utils.EnvironmentUtil;

public class MongoSupport {

	protected static EnvironmentUtil env = EnvironmentUtil.getInstance("mongodb.properties");

	protected static Map<String, MongoClient> mongoClients;

	protected static Map<String, Datasource> datasources;

	private static String datasourceNames;

	static {
		datasourceNames = env.getPropertyValue("DATA_SOURCES");
		initialiseMongoClients();
		initialiseDatasources();
	}

	private static void initialiseMongoClients() {
		String datasources = env.getPropertyValue("DATA_SOURCES");
		if (!StringUtils.isBlank(datasources)) {
			for (int i = 0; i < datasources.split(",").length; i++) {

			}
		}

	}

	private static void initialiseDatasources() {

	}

	private static List<ServerAddress> getAddresses(String addresses) {
		List<ServerAddress> result = new ArrayList<ServerAddress>();
		for (String address : addresses.split(" ")) {
			String add[] = address.split(":");
			try {
				ServerAddress serverAddress = new ServerAddress(add[0],
						Integer.parseInt(add[1]));
				result.add(serverAddress);
			} catch (NumberFormatException e) {
				throw new MongoException(
						"The configurations of Mongodb address are invalid, please check the configuration file \"mongodb.properties\".!",
						e);
			}
		}
		return result;
	}

	protected static String getDefaultDatasource() {
		String datasources = env.getPropertyValue("DATA_SOURCES");
		if (!StringUtils.isBlank(datasources)) {
			return datasources.split(",")[0];
		}
		return "";
	}

}
