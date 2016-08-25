package com.ctfo.upp.service;

import com.ctfo.upp.exceptions.UPPException;
import com.ctfo.upp.util.DynamicSqlParameter;
import com.ctfo.upp.util.PaginationResult;


public interface IService {
	
	/**
	 * 增加一个对象
	 * @param model
	 * @param operatorid ： 当前用户
	 * @return
	 */
	public PaginationResult<?> add(Object model)throws UPPException;
	
	/**
	 * 修改一个对象
	 * @param model
	 * @param operatorid ： 当前用户
	 * @return
	 */
	public PaginationResult<?> update(Object model)throws UPPException;
	
	/**
	 * 删除一个对象
	 * @param id
	 * @param operatorid 当前用户
	 * @return
	 */
	public PaginationResult<?> delete(String id)throws UPPException;
	
	/**
	 * 根据参数查询，返回一个对象
	 * @param paramObj
	 * @return
	 */
	public PaginationResult<?> queryObjectById(Object model)throws UPPException;
	
	/**
	 * 根据参数查询信息，返回集合信息对象
	 * @param requestParam
	 * @return
	 */
	public PaginationResult<?> queryList(DynamicSqlParameter requestParam)throws UPPException;
	
	/**
	 * 根据参数查询信息，返回包含页面信息和集合信息的综合对象
	 * @param requestParam
	 * @return
	 */
	public PaginationResult<?> queryListPage(DynamicSqlParameter requestParam)throws UPPException;
	
}
