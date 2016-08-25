package com.sinoiov.basic.interfacepub.plugins.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import com.sinoiov.basic.interfacepub.beans.request.Request;
import com.sinoiov.basic.interfacepub.beans.response.Response;
import com.sinoiov.basic.interfacepub.plugins.IPlugin;

@Service
public class CallLogPlugin implements IPlugin {
	
	private static ExecutorService threadPool = Executors.newFixedThreadPool(5);

	@Override
	public void process(Request request, Response response) {
		// TODO Auto-generated method stub
		threadPool.execute(new SaveCallLog(request, response));
	}
}

class SaveCallLog implements Runnable {
	
	private Request request;
	private Response response;
	
	public SaveCallLog(Request request, Response response){
		this.request = request;
		this.response = response;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("" + request + response);
	}
	
}