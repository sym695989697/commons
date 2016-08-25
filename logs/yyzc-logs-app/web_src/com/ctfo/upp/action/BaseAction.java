package com.ctfo.upp.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ctfo.upp.service.IService;
import com.ctfo.upp.util.PaginationResult;


/**
 * action公用基类
 * @author malongqing
 * @date  2014年10月27日
 *
 */
public abstract class BaseAction extends MultiActionController {
	
private static final long serialVersionUID = 1L;
	
	protected static final String LOGOUT = "logout";
	
	private static Log logger = LogFactory.getLog(BaseAction.class);
	
	protected Object model;
	
	protected ModelAndView modelView;
	
	protected String modelClassName;
	
	protected String ids;
		
	//protected DynamicSqlParameter requestParam= new DynamicSqlParameter();
	
	protected PaginationResult<?> result = new PaginationResult<Object>();
	
	protected String message;

	@Resource(name="service",description="service父接口")
	//@Autowired  
	protected IService service;
//	
//	protected HttpServletRequest request = ServletActionContext.getRequest();
//	protected HttpServletResponse response = ServletActionContext.getResponse();       
//	
//	
	/**
	 * 添加对象
	 * @return
	 */
	//@RequestMapping(value = "org/add.action")
//	public ModelAndView add(@ModelAttribute("form") Object model){		
//		try {			
//
//			result = service.add(model);
//
//		} catch (Exception e) {
//			result.setMessage(e.getLocalizedMessage());
//			logger.error("添加信息异常!",e);
//		}	
//		return modelView;		
//	}
//	
//
//
//	/**
//	 * 修改对象
//	 * @return
//	 */
//	//@Action("update")
//	public String update(){
//		try {			
//
//			result = service.update(model);
//
//		} catch (Exception e) {
//			result.setMessage("修改信息异常!");
//			logger.error("修改信息异常!",e);
//			this.setMessage(e.getLocalizedMessage());
//		}		
//		return SUCCESS;	
//	}	
//	
//	/**
//	 * 删除对象
//	 * @return
//	 * @author  malq
//	 * @date    2012-6-19
//	 */
//	//@Action("delete")
//	public String delete(){
//		try {			
//
//			result = service.delete(ids);
//
//		} catch (Exception e) {
//			result.setMessage("删除信息异常!");
//			logger.error("删除信息异常!", e);
//			this.setMessage(e.getLocalizedMessage());
//		}		
//		return SUCCESS;	
//	}
//
//	/**
//	 * 根据条件查询信息集合
//	 * @return
//	 * @author  malq
//	 * @date    2012-6-19
//	 */
//	//@Action("queryListPage")
//	public String queryListPage(){
//		try {	
//			result = service.queryListPage(requestParam);
//		} catch (Exception e) {
//			result.setMessage("查询信息集合异常!");
//			logger.error("查询信息集合异常!",e);
//			this.setMessage(e.getLocalizedMessage());
//		}		
//		return SUCCESS;	
//	}
//	
//	/**
//	 * 根据主键查询信息对象
//	 * @return
//	 */
//	//@Action("queryObjectById")
//	public String queryObjectById(){
//		try {			
//
//			result = service.queryObjectById(model);
//
//		} catch (Exception e) {
//			result.setMessage("查询信息异常!");
//			logger.error("查询信息异常!",e);
//			this.setMessage(e.getLocalizedMessage());
//		}		
//		return SUCCESS;	
//	}
//	
//	
//	
//	/**
//	 * 以子类的配置文件中必须注入service
//	 * 才能调用此类中基本增加，修改，删除，查询对象，查询分布集合的方法
//	 * @param service
//	 */
//	public void setService(IService service){
//		this.service = service;
//	}
//	
//	
//	
//	
//	/////////////set and get/////////////////////////
//	
//	@JSON(serialize=false)
//	public DynamicSqlParameter getRequestParam() {
//		return requestParam;
//	}
//
//	public void setRequestParam(DynamicSqlParameter requestParam) {
//		this.requestParam = requestParam;
//	}
//
//	@JSON(serialize=false)
//	public Object getModel() {
//		return model;
//	}
//
//	public void setModel(Object model) {
//		this.model = model;
//	}
//	public PaginationResult<?> getResult() {
//		return result;
//	}
//	public void setResult(PaginationResult<?> result) {
//		this.result = result;
//	}
//	@JSON(serialize=false)
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	@JSON(serialize=false)
//	public String getIds() {
//		return ids;
//	}
//	
//	public void setIds(String ids) {
//		this.ids = ids;
//	}
//	@JSON(serialize=false)
//	public String getModelClassName() {
//		return modelClassName;
//	}
//
//
//	public void setModelClassName(String modelClassName) {
//		this.modelClassName = modelClassName;
//	}
}
