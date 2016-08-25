package com.sinoiov.yyzc.mobile.api.bean.common;

import java.io.Serializable;

public class TokenRsult implements Serializable{
	private static final long serialVersionUID = 1L;
	private String result;
	private String userName;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
