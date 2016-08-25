package com.sinoiov.basic.interfacepub.exception;

public class InterfacePubException extends RuntimeException {
	
	private static final long serialVersionUID = 509673475771844037L;
	
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

	public InterfacePubException() {
		super("InterfacePubException");

	}

	public InterfacePubException(String errorCode) {
		this.errorCode = errorCode;
	}

	public InterfacePubException(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public InterfacePubException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		this.message = message;
	}

	public InterfacePubException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public InterfacePubException(Throwable cause) {
		super(cause);
	}

	public static void throwExcetion(InterfacePubException exception) {
		throw exception;
	}
}
