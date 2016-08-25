package com.ctfo.upp.baseservice.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctfo.base.dao.beans.SimpleCode;
import com.ctfo.base.dao.beans.SimpleCodeExampleExtended;
import com.ctfo.base.intf.internal.ISimpleCodeManager;
import com.ctfo.upp.dict.GenericEnum;
import com.ctfo.upp.exception.UPPException;
import com.ctfo.upp.manager.support.UppGenericManagerImpl;
import com.ctfo.upp.models.PaginationResult;


public class SimpleCodeManagerImpl extends UppGenericManagerImpl<SimpleCode, SimpleCodeExampleExtended> implements ISimpleCodeManager {

	private static Log logger = LogFactory.getLog(SimpleCodeManagerImpl.class);
	
	@Override
	public String addSimpleCode(SimpleCode model)
			throws UPPException {

		String uuid = null;
		try {

			super.notNull(model, model.getCode(), model.getTypeCode());

			this.checkLegal("root", model.getCode());//根节点下唯一
			
			this.checkLegal(model.getTypeCode(), model.getCode());//同一类型下唯一
			
			// 默认新增码表信息为启用状态
			model.setStatus(GenericEnum.DISENABLE.getValue().equals(model.getStatus())?GenericEnum.DISENABLE.getValue():GenericEnum.ENABLE.getValue());
			
			uuid = super.addModel(model);

		} catch (Exception e) {
			logger.error("增加码表信息异常", e);
			throw new UPPException("增加码表信息异常", e);
		}
		return uuid;
	}

	@Override
	public void modifySimpleCode(SimpleCode model)
			throws UPPException {

		try {
			
			super.notNull(model, model.getId(), model.getCode(), model.getTypeCode());

			SimpleCode tem = (SimpleCode)super.getModelById(model);
			if(!tem.getTypeCode().equals(model.getTypeCode())){
				this.checkLegal("root", model.getCode());
			}
			
			if(!tem.getCode().equals(model.getCode())){
				this.checkLegal(model.getTypeCode(), model.getCode());
			}
						
			//code发生变化则对应的typecode均要发生变更
			SimpleCodeExampleExtended exampleExtended = new SimpleCodeExampleExtended();
			exampleExtended.createCriteria().andTypeCodeEqualTo(model.getCode());
			List<SimpleCode> sub = super.getModels(exampleExtended);
			if(sub!=null && sub.size()>0){
				for(SimpleCode usc : sub){
					super.updateModelPart(usc);
				}
			}

			//model.setStatus(null);//不修改状态
			super.updateModelPart(model);

		} catch (Exception e) {
			logger.error("修改码表信息异常", e);
			throw new UPPException("修改码表信息异常", e);
		}

	}

	@Override
	public void removeSimpleCode(String id)
			throws UPPException {

		try {
			super.notNull(id);
			
			
			SimpleCode model = new SimpleCode();
			model.setId(id);
			
			model = (SimpleCode)this.getSimpleCodeById(id);

			if (GenericEnum.ENABLE.getValue().equalsIgnoreCase(model.getStatus())){
				logger.warn("SimpleCode["+model.getId()+"] is using , not allowed to remove!");
				throw new UPPException("SimpleCode is using, not allowed to remove!");
			} 

			super.removeModel(model);

		} catch (Exception e) {
			logger.error("删除码表信息异常", e);
			throw new UPPException("删除码表信息异常", e);
		}

	}

	@Override
	public SimpleCode getSimpleCodeById(String id)
			throws UPPException {

		SimpleCode bean = null;

		try {
			super.notNull(id);

			bean = new SimpleCode();
			bean.setId(id);
			bean = (SimpleCode) super.getModelById(bean);

		} catch (Exception e) {
			logger.error("根据ID查询码表异常", e);
			throw new UPPException("根据ID查询码表异常", e);
		}
		return bean;
	}

	@Override
	public List<SimpleCode> getSimpleCodeByExampleExtended(
			SimpleCodeExampleExtended exampleExtended)
					throws UPPException {

		List<SimpleCode> list = null;

		try {
			super.notNull(exampleExtended);

			list = super.getModels(exampleExtended);

		} catch (Exception e) {
			logger.error("查询码表集合异常", e);
			throw new UPPException("查询码表集合异常", e);
		}

		return list;
	}

	@Override
	public PaginationResult<SimpleCode> getSimpleCodePageByExampleExtended(
			SimpleCodeExampleExtended exampleExtended)
					throws UPPException {
		PaginationResult<SimpleCode> pagination = null;
		try {

			super.notNull(exampleExtended);
			
			pagination = super.paginateModels(exampleExtended);
					
		} catch (Exception e) {
			logger.error("查询码表页面对象异常", e);
			throw new UPPException("查询码表页面对象异常", e);
		}
		return pagination;
	}

	@Override
	public int countSimpleCodeByExampleExtended(
			SimpleCodeExampleExtended exampleExtended)
					throws UPPException {
		int count = 0;
		try {
			super.notNull(exampleExtended);

			count = super.countModels(exampleExtended);
					
		} catch (Exception e) {
			logger.error("统计码表信息异常", e);
			throw new UPPException("统计码表信息异常", e);
		}
		return count;
	}

	
	/**
	 * 检查码表对象在根节点和同一类型下唯一
	 * @param type
	 * @param code
	 * @param op
	 */
	private void checkLegal(String type, String code)throws UPPException{
		
		SimpleCodeExampleExtended exampleExtended = new SimpleCodeExampleExtended();
		exampleExtended.createCriteria().andTypeCodeEqualTo(type).andCodeEqualTo(code);
		if(this.countSimpleCodeByExampleExtended(exampleExtended)>0)
			throw new UPPException("root".equals(type)?"typeCode值在根下不唯一":"code值在同一类型下不唯一!");
		
	}

}
