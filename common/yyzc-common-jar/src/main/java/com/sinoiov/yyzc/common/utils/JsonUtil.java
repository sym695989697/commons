package com.sinoiov.yyzc.common.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ctfo.csm.local.DynamicSqlParameter;
import com.sinoiov.yyzc.common.model.PaginationResult;

import net.sf.json.JSONObject;


public class JsonUtil {
	
	public static Map<String, String> copyBeanToMap(Object bean, Map<String, String> map) throws Exception {
		Method[] mods = bean.getClass().getMethods();
		for (Method m : mods) {
			if (Modifier.isPublic(m.getModifiers()) && !"getClass".equals(m.getName())
					&& !"getSign".equals(m.getName()) && "get".equals(m.getName().substring(0, 3))) {
				String value = m.invoke(bean, null).toString();
				String key = m.getName();
				key = key.substring(3, 4).toLowerCase() + key.substring(4, key.length());
				map.put(key, value);
			}
		}
		return map;
	}

	public static Object copyMapToBean(Map<String, String> map, Object bean) throws Exception {
		Set<String> set = map.keySet();
		Method m = null;
		String methodName = "";
		for (String key : set) {
			methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1, key.length());
			m = bean.getClass().getMethod(methodName, String.class);
			m.invoke(bean, map.get(key));
		}
		return bean;
	}

	/**
	 * 将json转成bean对象
	 */
	public static Object jsonToObject(String json, Object bean) throws Exception {
		JSONObject jsonMap = JSONObject.fromObject(json);

		if (bean instanceof String) {
			return jsonMap.getString(bean.toString());
		} else if (bean instanceof Map) {
			Map<String, String> map = (Map) bean;
			Set<String> set = map.keySet();
			for (String key : set) {
				map.put(key, jsonMap.getString(key));
			}
			return map;
		} else if (bean instanceof List) {
			return jsonMap.get("data");
		} else {
			Set<String> set = jsonMap.keySet();
			Method m = null;
			String methodName = "";
			for (String key : set) {
				if ("sign".equals(key))
					continue;
				methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1, key.length());
				m = bean.getClass().getMethod(methodName, String.class);
				m.invoke(bean, jsonMap.get(key));
			}
			// Method[] mods = bean.getClass().getMethods();
			// String key = "";
			// for(Method m : mods){
			// if( Modifier.isPublic(m.getModifiers())
			// && !"setClass".equals(m.getName())
			// && !"setSign".equals(m.getName())
			// && "set".equals(m.getName().substring(0, 3))){
			// key = m.getName().substring(3,4).toLowerCase() +
			// m.getName().substring(4);
			// m.invoke(bean, jsonMap.getString(key));
			// }
			// }

			return bean;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static DynamicSqlParameter getDynamicSqlParameter(String paramJson) throws Exception{		
		JSONObject jsonMap = JSONObject.fromObject(paramJson);
		DynamicSqlParameter parameter = new DynamicSqlParameter();
				
		//Map<String,String>
		if(jsonMap.get("like")!=null)
			parameter.setLike((Map)JSONObject.toBean(JSONObject.fromObject(jsonMap.get("like").toString()), Map.class));
		if(jsonMap.get("equal")!=null)
			parameter.setEqual((Map)JSONObject.toBean(JSONObject.fromObject(jsonMap.get("equal").toString()), Map.class));
		if(jsonMap.get("notequal")!=null)
			parameter.setNotequal((Map)JSONObject.toBean(JSONObject.fromObject(jsonMap.get("notequal").toString()), Map.class));
		if(jsonMap.get("startwith")!=null)
			parameter.setStartwith((Map)JSONObject.toBean(JSONObject.fromObject(jsonMap.get("startwith").toString()), Map.class));
		if(jsonMap.get("endwith")!=null)
			parameter.setEndwith((Map)JSONObject.toBean(JSONObject.fromObject(jsonMap.get("endwith").toString()), Map.class));
		//Map<String,Object>
		if(jsonMap.get("inMap")!=null)
			parameter.setInMap((Map)JSONObject.toBean(JSONObject.fromObject(jsonMap.get("inMap").toString()), Map.class));
		if(jsonMap.get("updateValue")!=null)
			parameter.setUpdateValue((Map)JSONObject.toBean(JSONObject.fromObject(jsonMap.get("updateValue").toString()), Map.class));
		//List<Rule>
		//if(jsonMap.get("rules")!=null)
		//	parameter.setRules((List<Rule>)JSONArray.toCollection(JSONArray.fromObject(jsonMap.get("rules")), Rule.class));
		
		//String 
		if(jsonMap.get("op")!=null)
			parameter.setOp(jsonMap.getString("op"));
		if(jsonMap.get("noId")!=null)
			parameter.setNoId(jsonMap.getString("noId"));
		if(jsonMap.get("order")!=null)
			parameter.setOrder(jsonMap.getString("order"));
		if(jsonMap.get("sort")!=null)
			parameter.setSort(jsonMap.getString("sort"));
		//int 
		if(jsonMap.get("page")!=null)
			parameter.setPage(jsonMap.getInt("page"));
		if(jsonMap.get("rows")!=null)
			parameter.setRows(jsonMap.getInt("rows"));
		if(jsonMap.get("pagesize")!=null)
			parameter.setPagesize(jsonMap.getInt("pagesize"));
		
		return parameter;
	}
	
	public static String getObjectJson(Object result) throws Exception{
		JSONObject jsonMap = JSONObject.fromObject(result);
		return jsonMap.toString();
	}

}
