package com.sinoiov.basic.interfacepub.beans.response;

import java.io.Serializable;

import com.sinoiov.basic.interfacepub.beans.common.Param;

public class Response implements Serializable{

	private static final long serialVersionUID = -8780372667251738461L;

	private String result;//调用状态
	
	private String errorMessage;//错误信息
	
	private String responseTime;
	
	private Param param;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

}
