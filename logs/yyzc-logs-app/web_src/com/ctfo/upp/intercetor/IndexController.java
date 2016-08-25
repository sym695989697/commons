package com.ctfo.upp.intercetor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
@RequestMapping("index")  
public class IndexController {
	 @RequestMapping("helloWorld")  
	    public String helloworld() {  
	        // return "success"; //跳转到success页面  
	        return "index";  
	    }  
}
