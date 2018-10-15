package com.balceda.archj.service.exception;

public class ExceptionService extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionService() {
	}

	public ExceptionService(String message) {
		super(message);
	}

	public ExceptionService(Throwable cause) {
		super(cause);
	}

	public ExceptionService(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionService(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
