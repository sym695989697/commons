package com.sinoiov.yyzc.common.configCache;

import java.util.Map;

public abstract class ConfigAbstract {
	
	public abstract Map<String, String> initValueFromOther() throws Exception;
	
	public abstract String getValueFromOther(String key) throws Exception;
}
