package com.sinoiov.yyzc.commons.mongodb.exceptions;

public class YyzcMongoException extends RuntimeException{

	private static final long serialVersionUID = 8511480498625930669L;

	protected String errorCode;
	
	protected String message;
	
	public YyzcMongoException() {
		super("CtfoMongoException");

	}

	public YyzcMongoException(String errorCode) {
		this.errorCode = errorCode;
	}

	public YyzcMongoException(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public YyzcMongoException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		this.message = message;
	}

	public YyzcMongoException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public YyzcMongoException(Throwable cause) {
		super(cause);
	}

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

	public static void throwExcetion(YyzcMongoException exception) {
		throw exception;
	}
}
