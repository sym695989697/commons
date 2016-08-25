package com.sinoiov.yyzc.commons.redis.exception;

public class RedisException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String errorCode;
	
	protected String message;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RedisException() {
		super("RedisException");

	}

	public RedisException(String errorCode) {
		this.errorCode = errorCode;
	}

	public RedisException(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public RedisException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		this.message = message;
	}

	public RedisException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public RedisException(Throwable cause) {
		super(cause);
	}
}
