package com.ashutosh0640.patientService.exception;

public class InvalidArgumentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidArgumentException() {
		super();
	}

	public InvalidArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidArgumentException(String message) {
		super(message);
	}

	public InvalidArgumentException(Throwable cause) {
		super(cause);
	}

}
