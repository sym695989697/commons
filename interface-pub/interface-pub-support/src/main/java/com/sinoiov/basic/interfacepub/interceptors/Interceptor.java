package com.sinoiov.basic.interfacepub.interceptors;

import com.sinoiov.basic.interfacepub.beans.request.Request;
import com.sinoiov.basic.interfacepub.exception.InterfacePubException;

public interface Interceptor {
	
	public void doFilter(Request request) throws InterfacePubException;
}
