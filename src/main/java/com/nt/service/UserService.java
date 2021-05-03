package com.nt.service;


import com.nt.dto.UserDTO;

public interface UserService {
	 public UserDTO checkLogin(String userName, String userPassword);

}
