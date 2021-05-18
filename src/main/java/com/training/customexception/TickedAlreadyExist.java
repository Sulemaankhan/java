package com.training.customexception;

public class TickedAlreadyExist extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TickedAlreadyExist(String message) {
		super(message);
	}

}
