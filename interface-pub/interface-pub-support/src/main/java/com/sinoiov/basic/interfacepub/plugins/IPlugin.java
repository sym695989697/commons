package com.sinoiov.basic.interfacepub.plugins;

import com.sinoiov.basic.interfacepub.beans.request.Request;
import com.sinoiov.basic.interfacepub.beans.response.Response;

public interface IPlugin {

	public void process(Request request, Response response);
	
}
