package com.training.customexception;

public class UserExist extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserExist(String messsage) {
		super(messsage);
	}

}
