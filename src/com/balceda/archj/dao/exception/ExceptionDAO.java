package com.balceda.archj.dao.exception;

public class ExceptionDAO extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionDAO() {
	}

	public ExceptionDAO(String message) {
		super(message);
	}

	public ExceptionDAO(Throwable cause) {
		super(cause);
	}

	public ExceptionDAO(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionDAO(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
