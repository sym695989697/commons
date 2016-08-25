package com.sinoiov.basic.interfacepub.external.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinoiov.basic.interfacepub.beans.request.Request;
import com.sinoiov.basic.interfacepub.proxy.ICallProxy;

@Scope("prototype")
@Controller
@RequestMapping(value = "/")
public class BasicController {
	
	@Autowired
	private ICallProxy proxy;
	
	@RequestMapping(value = "/service", produces = "text/plain;charset=utf-8")
	public List<String> doService(HttpServletResponse response, Request request)
			throws Exception {
		
		return null;
	}
	

}
