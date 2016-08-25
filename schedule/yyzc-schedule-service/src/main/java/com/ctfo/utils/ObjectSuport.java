package com.ctfo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ctfo.quartz.bean.PaginationResult;
import com.ibatis.sqlmap.engine.impl.ExtendedSqlMapClient;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMap;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

public class ObjectSuport extends CallSupport {

	private static final Log logger = LogFactory.getLog(ObjectSuport.class);

	public ObjectSuport() {

	}

	public static Object getBeanExample(Object bean) throws Exception {
		if (bean == null) {
			return null;
		}
		return Class.forName(bean.getClass().getName() + "Example")
				.newInstance();
	}

	public static String getDaoIntf(Class beanClass) throws Exception {
		return (String) staticCall(beanClass, "daoInterface", new Class[] {},
				new Object[] {});
	}

	public static Object getDao(String daoIntf) throws Exception {
		try {
			return getDao(Class.forName(daoIntf));
		} catch (ClassNotFoundException e) {
			logger.error("Cann't get DAO Implement:" + daoIntf, e);
			throw new Exception("Cann't get DAO Implement:" + daoIntf, e);
		}
	}

	public static Object getDao(Class daoIntf) throws Exception {
		if (daoIntf == null) {
			return null;
		}
		Object impl = null;
		String implName = daoIntf.getName() + "Impl";
		try {
			impl = Class.forName(implName).newInstance();
			Object clientTemplate = SpringBUtils
					.getBean("quartzOracleClientTemplate");
			if (impl instanceof SqlMapClientDaoSupport) {
				((SqlMapClientDaoSupport) impl)
						.setSqlMapClientTemplate((SqlMapClientTemplate) clientTemplate);
			}
		} catch (Exception e) {
			logger.error("Cann't get DAO Implement:" + daoIntf.getName(), e);
			throw new Exception(
					"Cann't get DAO Implement:" + daoIntf.getName(), e);
		}
		return impl;
	}

	public static String addObj(Object obj) throws Exception {
		if (obj == null) {
			logger.error("obj Cann't be null");
			throw new Exception("obj Cann't be null");
		}
		String uuid = UUID.randomUUID().toString();
		publicCall(obj, "setId", new Class[] { String.class },
				new Object[] { uuid });
		Object dao = getDao(getDaoIntf(obj.getClass()));
		publicCall(dao, "insert", new Class[] { obj.getClass() },
				new Object[] { obj });

		return uuid;
	}

	public static Object getObjectById(Object obj, String id) throws Exception {
		String daoIntf = getDaoIntf(obj.getClass());
		Object dao = getDao(daoIntf);
		Object ret = null;
		String tableName = publicCall(obj, "tableName", new Class[] {},
				new Object[] {}).toString();
		try {
			ret = publicCall(dao, "selectByPrimaryKey",
					new Class[] { String.class }, new Object[] { id });
		} catch (Exception e) {
			logger.error("Can'not get Object By PrimaryKey："
					+ obj.getClass().getName() + "[" + id + "]", e);
			throw new Exception("Can'not get Object By PrimaryKey："
					+ obj.getClass().getName() + "[" + id + "]", e);
		}

		return ret;
	}

	public static int removeObj(Object obj) throws Exception {
		if (obj == null) {
			logger.error("obj Cann't be null");
			throw new Exception("obj Cann't be null");
		}
		String daoIntf = getDaoIntf(obj.getClass());
		Object dao = getDao(daoIntf);
		Object id = publicCall(obj, "getId", new Class[] {}, new Object[] {});

		return (Integer) publicCall(dao, "deleteByPrimaryKey",
				new Class[] { String.class }, new Object[] { id });
	}

	public static int updateObjAll(Object obj) throws Exception {
		if (obj == null) {
			return 0;
		}
		Object dao = getDao(getDaoIntf(obj.getClass()));
		return (Integer) publicCall(dao, "updateByPrimaryKey",
				new Class[] { obj.getClass() }, new Object[] { obj });
	}

	public static int updateObjPart(Object obj) throws Exception {
		if (obj == null) {
			return 0;
		}
		Object dao = getDao(getDaoIntf(obj.getClass()));
		return (Integer) publicCall(dao, "updateByPrimaryKeySelective",
				new Class[] { obj.getClass() }, new Object[] { obj });
	}

	public static void setExample(Object example, Object whereobj)
			throws Exception {
		Map props = null;
		try {
			props = BeanUtils.describe(whereobj);
		} catch (Exception e) {
			logger.error("beans convert to map error:", e);
			throw new Exception("beans convert to map error:", e);
		}

		Object criteria = publicCall(example, "createCriteria", new Class[] {},
				new Object[] {});
		for (Object key : props.keySet()) {
			if (props.get(key) == null
					|| StringUtils.equals(key.toString(), "class")) {
				continue;
			}
			try {
				String name = key.toString();
				Object value = publicCall(
						whereobj,
						"get" + name.substring(0, 1).toUpperCase()
								+ name.substring(1), new Class[] {},
						new Object[] {});
				if (value == null) {
					continue;
				}
				publicCall(criteria, "and" + name.substring(0, 1).toUpperCase()
						+ name.substring(1) + "EqualTo",
						new Class[] { value.getClass() },
						new Object[] { value });
			} catch (Exception e) {
				logger.error("put value from " + whereobj.getClass().getName()
						+ " to " + example.getClass().getName() + " error:["
						+ key.toString() + "]", e);
				throw new Exception("put value from "
						+ whereobj.getClass().getName() + " to "
						+ example.getClass().getName() + " error:["
						+ key.toString() + "]", e);
			}
		}
	}

	public static int modifyObjByExample(Object obj, Object whereobj)
			throws Exception {
		if (obj == null || whereobj == null) {
			return 0;
		}
		Object example;
		try {
			example = getBeanExample(obj);
		} catch (Exception e) {
			logger.error("get example of " + obj.getClass().getName()
					+ "error :", e);
			throw new Exception("get example of " + obj.getClass().getName()
					+ "error :", e);
		}
		try {
			setExample(example, whereobj);
		} catch (Exception e) {
			logger.error("change " + obj.getClass().getName() + " to "
					+ example.getClass().getName() + " by "
					+ whereobj.getClass().getName() + "error :", e);
			throw new Exception("change " + obj.getClass().getName() + " to "
					+ example.getClass().getName() + " by "
					+ whereobj.getClass().getName() + "error :", e);
		}
		Object dao = getDao(getDaoIntf(obj.getClass()));
		List keys = (List) publicCall(dao, "getKeyBy", new Class[] {example.getClass()},
		        new Object[] {example});
		
	    int count = (Integer) publicCall(dao, "updateByExampleSelective", new Class[] {obj.getClass(),
		          example.getClass()}, new Object[] {obj, example});
	    
	    return count;
	}

	public static PaginationResult paginate(Object exampleExtended)
			throws Exception {
		int count = countByExampleExtended(exampleExtended);
		List<Object> data = getObjectsByExampleExtended(exampleExtended);

		PaginationResult ret = new PaginationResult();
		ret.setTotal(count);
		ret.setData((data != null) ? Arrays.asList(data
				.toArray(new Object[] {})) : null);

		return ret;
	}

	public static int countByExampleExtended(Object exampleExtended)
			throws Exception {
		String daoIntf = getDaoIntf(exampleExtended.getClass());
		if (daoIntf == null) {
			throw new Exception("the input param exampleExtended is invalid :"
					+ exampleExtended, null);
		}
		Object dao = getDao(daoIntf);
		if (dao == null) {
			throw new Exception("cann't find the dao :" + daoIntf, null);
		}

		extendExample4SubQuery(exampleExtended);

		Integer count = (Integer) publicCall(dao, "countByExample",
				new Class[] { exampleExtended.getClass() },
				new Object[] { exampleExtended });
		if (count == null) {
			count = 0;
		}
		return count;
	}

	public static List<Object> getObjectsByExampleExtended(
			Object exampleExtended) throws Exception {
		String daoIntf = getDaoIntf(exampleExtended.getClass());
		if (daoIntf == null) {
			throw new Exception("the input param exampleExtended is invalid :"
					+ exampleExtended, null);
		}
		Object dao = getDao(daoIntf);
		if (dao == null) {
			throw new Exception("cann't find the dao :" + daoIntf, null);
		}

		extendExample4SubQuery(exampleExtended);

		List<Object> ret = new ArrayList<Object>();
		ret = (List) publicCall(dao, "selectByExampleWithPage",
				new Class[] { exampleExtended.getClass() },
				new Object[] { exampleExtended });

		return ret;
	}

	public static Object extendExample4SubQuery(Object example)
			throws Exception {
		List allCriterias = (List) publicCall(example, "getOredCriteria",
				new Class[] {}, new Object[] {});

		for (Object criteria : allCriterias) {
			List inOrNotINCriteria = (List) publicCall(criteria,
					"getCriteriaWithListValue", new Class[] {}, new Object[] {});
			List criteriaNoValue = (List) publicCall(criteria,
					"getCriteriaWithoutValue", new Class[] {}, new Object[] {});

			replaceSubExample(inOrNotINCriteria, criteriaNoValue);
		}

		return example;
	}

	public static void replaceSubExample(List exampleCriteria, List criteria)
			throws Exception {
		for (Iterator ite = exampleCriteria.iterator(); ite.hasNext();) {
			Map m = (Map) ite.next();
			List vals = (List) m.get("values");
			if (vals.isEmpty()) {
				continue;
			}
			Object exa = vals.get(0);
			String classn = exa.getClass().getName();
			if (classn.endsWith("Example")
					|| classn.endsWith("ExampleExtended")) {
				boolean extended = classn.endsWith("ExampleExtended");
				extendExample4SubQuery(exa);
				String sql = (String) m.get("condition");
				sql += " ( " + extractSql(exa, true, extended) + " ) ";

				criteria.add(sql);
				ite.remove();
			}
		}
	}

	public static String extractSql(Object example, boolean forwhere,
			boolean extended) throws Exception {
		if (forwhere) {
			publicCall(example, "setOrderByClause",
					new Class[] { String.class }, new Object[] { null });
			publicCall(example, "setSkipNum", new Class[] { int.class },
					new Object[] { 0 });
			publicCall(example, "setEndNum", new Class[] { int.class },
					new Object[] { 0 });
		}

		SqlMapClientDaoSupport dao = (SqlMapClientDaoSupport) getDao(getDaoIntf(example
				.getClass()));
		ExtendedSqlMapClient sqlMapClient = (ExtendedSqlMapClient) dao
				.getSqlMapClient();

		String _namesp = (String) publicCall(dao, "getNameSpace",
				new Class[] {}, new Object[] {});
		String sqlId = _namesp
				+ (extended ? ".abatorgenerated_selectKeyByExtended"
						: ".abatorgenerated_selectKeyBy");
		SqlMapExecutorDelegate delegate = sqlMapClient.getDelegate();
		MappedStatement mappedStatement = delegate.getMappedStatement(sqlId);
		Sql sql = mappedStatement.getSql();
		SessionScope sessionScope = new SessionScope();
		StatementScope statementScope = new StatementScope(sessionScope);
		mappedStatement.initRequest(statementScope);
		StringBuffer sqlExecuted = new StringBuffer(sql.getSql(statementScope,
				example));

		ParameterMap parameterMap = sql
				.getParameterMap(statementScope, example);
		Object[] parameters = parameterMap.getParameterObjectValues(
				statementScope, example);

		int lasti = 0;
		for (Object p : parameters) {
			String value = "";
			if (p instanceof String) {
				value = "'" + p + "'";
			} else {
				value = String.valueOf(p);
			}

			if (lasti > -1) {
				lasti = sqlExecuted.indexOf("?", lasti);
				if (lasti > -1) {
					sqlExecuted = sqlExecuted.replace(lasti, lasti + 1, value); // ("\\?",
																				// value);
				}
			}
		}
		System.out.println(sqlExecuted);
		return sqlExecuted.toString();
	}

}
