package com.nt.dao;

import com.nt.bo.UserBO;

public interface LoginDAO {
	public UserBO validate(String userName, String userPassword);
}
