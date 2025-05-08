package com.ashutosh0640.patientService.exception;

public class DuplicateResourceFoundExcepiton extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateResourceFoundExcepiton() {
		super();
	}

	public DuplicateResourceFoundExcepiton(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DuplicateResourceFoundExcepiton(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateResourceFoundExcepiton(String message) {
		super(message);
	}

	public DuplicateResourceFoundExcepiton(Throwable cause) {
		super(cause);
	}
	

}
