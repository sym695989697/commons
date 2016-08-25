package com.ctfo.upp.exceptions;
/***
 * 自定异常类
 * @author zhujianbo
 *
 */
public class UPPException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UPPException(){
		super();
	}
	public UPPException(String msg){
		super(msg);
	}
	public UPPException(String msg,Throwable cause){
		super(msg,cause);
	}
	public UPPException(Throwable cause){
		super(cause);
	}
}
