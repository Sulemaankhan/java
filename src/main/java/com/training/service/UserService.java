package com.training.service;

import java.util.List;

import com.training.customexception.UserExist;
import com.training.dto.UserRequestDTO;
import com.training.dto.UserResponseDTO;
import com.training.entity.User;

public interface UserService {

	UserResponseDTO saveUser(UserRequestDTO userRequestDTO);

	List<User> getAllUser();

	User updateById(long id, User user);

	User updateByUserName(String username, User user);

	int deleteByUserName(String username);

	UserResponseDTO save(UserRequestDTO user) throws UserExist;

	UserResponseDTO loginUser(String username, String password);

	

}
