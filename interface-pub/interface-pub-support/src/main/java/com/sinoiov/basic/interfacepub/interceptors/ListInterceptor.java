package com.sinoiov.basic.interfacepub.interceptors;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component("filters")
public class ListInterceptor extends ArrayList<Interceptor> {

	private static final long serialVersionUID = 2677027668874227058L;

}
