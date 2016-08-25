package com.ctfo.quartz.dao;

import java.util.List;

import com.ctfo.quartz.bean.PaginationResult;

public interface IQuartzDao<T, Texample> {
	
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
	public int removeModel(T bean) throws Exception;
	
	/**
	 * 批量删除对象
	 * @param beans
	 * @throws Exception
	 */
	public int removeModelBatch(List<T> beans) throws Exception;
	
	/**
	 * 修改对象（字段为空的部分也修改）
	 * @param bean
	 * @throws Exception
	 */
	public int updateModelAll(T bean) throws Exception;
	
	/**
	 * 修改对象（字段为空的部分不修改）
	 * @param bean
	 * @throws Exception
	 */
	public int updateModelPart(T bean) throws Exception;
	
	/**
	 * 根据bean2作为where条件，来修改bean1（字段为空的部分不修改）
	 * @param bean
	 * @throws Exception
	 */
	public int updateModelByOtherModel(T bean1, T bean2) throws Exception;
	
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
	public <T> PaginationResult<T> paginateModels(Texample exampleExtended) throws Exception;
	
}
