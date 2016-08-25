package com.sinoiov.basic.interfacepub.beans.request;

import java.io.Serializable;

import com.sinoiov.basic.interfacepub.beans.common.Param;

public class Request implements Serializable{

	private static final long serialVersionUID = 6203645694013555140L;

	private String servCode;//服务编码，10001!01
	
	private String sequenceNum;//调用流水号
	
	private String callTime;//调用时间
	
	private Param param;
	
	private String sign;

	public String getServCode() {
		return servCode;
	}

	public void setServCode(String servCode) {
		this.servCode = servCode;
	}

	public String getSequenceNum() {
		return sequenceNum;
	}

	public void setSequenceNum(String sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public String getCallTime() {
		return callTime;
	}

	public void setCallTime(String callTime) {
		this.callTime = callTime;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

}
