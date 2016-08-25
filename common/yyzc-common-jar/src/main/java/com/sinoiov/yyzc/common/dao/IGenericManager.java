package com.sinoiov.yyzc.common.dao;

import java.util.List;

import com.sinoiov.yyzc.common.model.Paginator;

/**
 * 通用数据对象管理接口，各种单表对象的增删改查操作
 * @author white
 *
 */
public interface IGenericManager<T,Texample> {
	
	/**
	 * 添加单个对象
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public String addModel(T bean) throws Exception;
	
	/**
	 * 批量添加对象
	 * @param beans
	 * @return
	 * @throws Exception
	 */
	public List addModelBatch(List<T> beans) throws Exception;
	
	/**
	 * 删除单个对象
	 * @param bean
	 * @throws Exception
	 */
	public void removeModel(T bean) throws Exception;
	
	/**
	 * 批量删除对象
	 * @param beans
	 * @throws Exception
	 */
	public void removeModelBatch(List<T> beans) throws Exception;
	
	/**
	 * 修改对象（字段为空的部分也修改）
	 * @param bean
	 * @throws Exception
	 */
	public void updateModelAll(T bean) throws Exception;
	
	/**
	 * 修改对象（字段为空的部分不修改）
	 * @param bean
	 * @throws Exception
	 */
	public void updateModelPart(T bean) throws Exception;
	
	/**
	 * 根据bean2作为where条件，来修改bean1（字段为空的部分不修改）
	 * @param bean
	 * @throws Exception
	 */
	public void updateModelByOtherModel(T bean1, T bean2) throws Exception;
	
	/**
	 * 根据id获取单个对象
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Object getModelById(T bean) throws Exception;
	
	/**
	 * 根据属性获取对象集
	 * @param exampleExtended
	 * @return
	 * @throws Exception
	 */
	public List getModels(Texample exampleExtended) throws Exception;
	
	public List getKeys(Texample exampleExtended) throws Exception;

	/**
	 * 查询符合条件的对象集的大小
	 * @param exampleExtended
	 * @return
	 * @throws Exception
	 */
	public int countModels(Texample exampleExtended) throws Exception;
	
	/**
	 * 分页查询对象集
	 * @param exampleExtended
	 * @return
	 * @throws Exception
	 */
	public <T> Paginator<T> paginateModels(Texample exampleExtended) throws Exception;
	
}
