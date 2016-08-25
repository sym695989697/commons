package com.sinoiov.yyzc.common.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sinoiov.yyzc.common.dao.support.ImplementationSupport;
import com.sinoiov.yyzc.common.model.Paginator;

public class GenericManagerImpl<T, Texample> extends ImplementationSupport implements
		IGenericManager<T, Texample> {

	@Override
	public String addModel(T bean) throws Exception {
		if (bean == null) {
			throw new Exception("非法输入空bean");
		}
		return super.addObj(bean);
	}

	@Override
	public List addModelBatch(List<T> beans) throws Exception {
		if (beans == null) {
			throw new Exception("非法输入空beans");
		}
		List ids = new ArrayList();
		for (T bean : beans) {
			ids.add(this.addModel(bean));
		}
		return ids;
	}

	@Override
	public void removeModel(T bean) throws Exception {
		if (bean == null) {
			throw new Exception("非法输入空bean");
		}
		super.removeObj(bean);
	}

	@Override
	public void removeModelBatch(List<T> beans) throws Exception {
		if (beans == null) {
			throw new Exception("非法输入空beans");
		}
		for (T bean : beans) {
			this.removeModel(bean);
		}
	}

	@Override
	public void updateModelAll(T bean) throws Exception {

		if (bean == null) {
			throw new Exception("非法输入空bean");
		}
		super.updateObjAll(bean);
	}

	@Override
	public void updateModelPart(T bean) throws Exception {
		if (bean == null) {
			throw new Exception("非法输入空bean");
		}
		super.updateObjPart(bean);
	}

	@Override
	public void updateModelByOtherModel(T bean1, T bean2) throws Exception {
		if (bean1 == null && bean2 == null) {
			throw new Exception("非法输入空bean");
		}
		super.modifyObjByExample(bean1, bean2);
	}

	@Override
	public Object getModelById(T bean) throws Exception {
		if (bean == null) {
			throw new Exception("非法输入空bean");
		}
		String uuid = null;
		try {
			uuid = (String) this.publicCall(bean, "getId", new Class[] {},
					new Object[] {});
		} catch (Exception e) {
			throw new Exception("这个对象没有getId方法，不是合法的model", e);
		}
		return super.getObjectById(bean, uuid);
	}

	@Override
	public List getModels(Texample exampleExtended) throws Exception {
		if (exampleExtended == null) {
			throw new Exception("非法输入空exampleExtended");
		}
		return super.getObjectsByExampleExtended(exampleExtended);
	}

	@Override
	public int countModels(Texample exampleExtended) throws Exception {
		if (exampleExtended == null) {
			throw new Exception("非法输入空exampleExtended");
		}
		return super.countByExampleExtended(exampleExtended);
	}

	@Override
	public <T> Paginator<T> paginateModels(Texample exampleExtended)
			throws Exception {
		if (exampleExtended == null) {
			throw new Exception("非法输入空exampleExtended");
		}
		return super.paginate(exampleExtended);
	}

	@Override
	public List getKeys(Texample exampleExtended) throws Exception {
		// TODO Auto-generated method stub
		if (exampleExtended == null) {
			throw new Exception("非法输入空exampleExtended");
		}
		return super.getKeyByExampleExtended(exampleExtended);
	}

	@Override
	public List<Map> queryBySQL(String sql) throws Exception {
		// TODO Auto-generated method stub
		return super.queryBySQL(sql);
	}

	@Override
	public Object queryObjectBySQL(String sqlMapName,
			Map<String, Object> parmaObjMap) throws Exception {
		if (StringUtils.isBlank(sqlMapName)) {
			throw new Exception("sqlMapName为空!请输入正确的sqlMap 名称");
		}
		return super.queryObjectBySQL(sqlMapName, parmaObjMap);
	}

	@Override
	public List<Object> queryListBySQL(String sqlMapName,
			Map<String, Object> parmaObjMap) throws Exception {
		if (StringUtils.isBlank(sqlMapName)) {
			throw new Exception("sqlMapName为空!请输入正确的sqlMap 名称");
		}
		return super.queryListBySQL(sqlMapName, parmaObjMap);
	}
}
