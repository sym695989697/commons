package com.sinoiov.basic.interfacepub.proxy;

import com.sinoiov.basic.interfacepub.beans.request.Request;
import com.sinoiov.basic.interfacepub.beans.response.Response;

public interface ICallProxy {
	
	public Response process(Request request);
}
