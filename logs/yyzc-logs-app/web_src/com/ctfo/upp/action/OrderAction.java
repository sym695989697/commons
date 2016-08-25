package com.ctfo.upp.action;

import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
//@Scope("prototype,request")
public class OrderAction extends BaseAction{
	
	private static Log logger = LogFactory.getLog(OrderAction.class);
			
	
	/**
	 * 添加订单
	 */
	@RequestMapping(value = "order/add.action")
	public ModelAndView add(@ModelAttribute("form") OrderBean model){		
		try {			

			result = service.add(model);
			
			ModelAndView modelView = new ModelAndView();
			modelView.setViewName("orgadd");

		} catch (Exception e) {
			result.setMessage(e.getLocalizedMessage());
			logger.error("添加信息异常!",e);
		}	
		return  modelView;		
	}
	
	/**
	 * 修改订单
	 */
	@RequestMapping(value = "org/add.action")
	public String update(@ModelAttribute("form") OrderBean model, 
			@RequestParam("orderId") String orderId){		
		try {			
			
			//result = service.update(model);
			
		} catch (Exception e) {
			result.setMessage(e.getLocalizedMessage());
			logger.error("修改信息异常!",e);
		}	
		return  "orgupdate";		
	}
	
	
	
	 /** 
     * 输入 和输出为JSON格式的数据的方式 
     * 
     */  
    @RequestMapping(value = "order/getOrderById.action")   
    @ResponseBody   
    public ResponseEntity<String> getOrderById(@RequestParam("orderId") String orderId){
    	
    	ResponseEntity<String> responseEntity = null;
    	
    	try{
    		
    	
    		OrderBean shop = new OrderBean();  
	        shop.setOrderNo("pay_201410270021524");
	        shop.setOrderName("JSON,JSON:JSON");
	        shop.setOrderType("1002");
        
        
	        JsonConfig config = new JsonConfig();    
	        config.setIgnoreDefaultExcludes(false);
	        config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);     
       
	        config.setExcludes(new String[]{"name"}); //过滤不需要的属性   
	        
	        logger.debug("json3:"+JSONSerializer.toJSON(shop,config).toString());
	       
	        HttpHeaders httpHeaders = new HttpHeaders();  
	        responseEntity = new ResponseEntity<String>(JSONSerializer.toJSON(shop,config).toString(), httpHeaders, HttpStatus.CREATED);  
        
    	} catch (Exception e) {
			result.setMessage(e.getLocalizedMessage());
			logger.error("修改信息异常!",e);
		}	
		
        return responseEntity;  
            
    }    
	

}
