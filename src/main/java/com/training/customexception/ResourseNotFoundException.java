package com.training.customexception;


public class ResourseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourseNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ResourseNotFoundException(String message) {
		super(message);
	}

}
