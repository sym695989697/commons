package com.ctfo.quartz.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ctfo.quartz.bean.PaginationResult;
import com.ctfo.utils.ObjectSuport;

@Service("quartzDao")
public class QuartzDaoImpl<T, Texample> implements IQuartzDao<T,Texample> {
	
	@Override
	public String addModel(T bean) throws Exception {
		// TODO Auto-generated method stub
		if(bean == null){
			throw new Exception("非法输入空bean");
		}
		return ObjectSuport.addObj(bean);
	}

	@Override
	public List addModelBatch(List<T> beans) throws Exception {
		// TODO Auto-generated method stub
		if(beans == null){
			throw new Exception("非法输入空beans");
		}
		List ids = new ArrayList();
		for(T bean : beans) {
			ids.add(this.addModel(bean));
		}
		return ids;
	}

	@Override
	public int removeModel(T bean) throws Exception {
		// TODO Auto-generated method stub
		if(bean == null){
			throw new Exception("非法输入空bean");
		}
		return ObjectSuport.removeObj(bean);
	}
	
	@Override
	public int removeModelBatch(List<T> beans) throws Exception {
		// TODO Auto-generated method stub
		if(beans == null){
			throw new Exception("非法输入空beans");
		}
		int num = 0;
		for(T bean : beans) {
			num += this.removeModel(bean);
		}
		return num;
	}

	@Override
	public int updateModelAll(T bean) throws Exception {
		// TODO Auto-generated method stub
		if(bean == null){
			throw new Exception("非法输入空bean");
		}
		return ObjectSuport.updateObjAll(bean);
	}
	
	@Override
	public int updateModelPart(T bean) throws Exception {
		// TODO Auto-generated method stub
		if(bean == null){
			throw new Exception("非法输入空bean");
		}
		return ObjectSuport.updateObjPart(bean);
	}
	
	@Override
	public int updateModelByOtherModel(T bean1, T bean2) throws Exception {
		// TODO Auto-generated method stub
		if(bean1 == null && bean2 == null){
			throw new Exception("非法输入空bean");
		}
		return ObjectSuport.modifyObjByExample(bean1, bean2);
	}

	@Override
	public Object getModelById(T bean) throws Exception {
		// TODO Auto-generated method stub
		if(bean == null){
			throw new Exception("非法输入空bean");
		}
		String uuid = null;
		try{
			uuid = (String) ObjectSuport.publicCall(bean, "getId", new Class[]{}, new Object[]{});
		}catch(Exception e){
			throw new Exception("这个对象没有getId方法，不是合法的model", e);
		}
		return ObjectSuport.getObjectById(bean, uuid); 
	}

	@Override
	public List getModels(Texample exampleExtended) throws Exception {
		// TODO Auto-generated method stub
		if(exampleExtended == null){
			throw new Exception("非法输入空exampleExtended");
		}
		return ObjectSuport.getObjectsByExampleExtended(exampleExtended);
	}

	@Override
	public int countModels(Texample exampleExtended) throws Exception {
		// TODO Auto-generated method stub
		if(exampleExtended == null){
			throw new Exception("非法输入空exampleExtended");
		}
		return ObjectSuport.countByExampleExtended(exampleExtended);
	}

	@Override
	public <T> PaginationResult<T> paginateModels(Texample exampleExtended) throws Exception {
		// TODO Auto-generated method stub
		if(exampleExtended == null){
			throw new Exception("非法输入空exampleExtended");
		}
		return ObjectSuport.paginate(exampleExtended);
	}
}
