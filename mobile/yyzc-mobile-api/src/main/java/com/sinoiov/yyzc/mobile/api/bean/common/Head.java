package com.sinoiov.yyzc.mobile.api.bean.common;

public class Head implements java.io.Serializable {
	private static final long serialVersionUID = 927427642571559938L;

	/**
	 * 服务接口编码
	 */
	private String serverCode;

	/**
	 * 调用序列码（调用对应回传序列码）
	 */
	private String sequenceCode;

	/**
	 * 调用时间
	 */
	private String requestTime;
	
	/**
	 * 返回时间
	 */
	private String responseTime;

	/**
	 * 返回结果状态，success：成功，failed：失败
	 */
	private String status;

	/**
	 * 错误信息
	 */
	private String errorMessage;

	/**
	 * //1:android; 2:ios
	 */
	private String sourceSystem;
	
	/**
	 * 协议版本号
	 */
	private String protocolVersion;
	
	/**
	 * apk版本号
	 */
	private String appVersion;
	
	/**
	 * 手机型号
	 */
	private String mobileModel;
	
	/**
	 * 登陆token
	 */
	private String token;
	
	/**
	 * 用户id
	 */
	private String userId;

	public String getServerCode() {
		return serverCode;
	}

	public void setServerCode(String serverCode) {
		this.serverCode = serverCode;
	}

	public String getSequenceCode() {
		return sequenceCode;
	}

	public void setSequenceCode(String sequenceCode) {
		this.sequenceCode = sequenceCode;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getMobileModel() {
		return mobileModel;
	}

	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
