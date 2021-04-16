package ola.com.booking.service;

import ola.com.booking.model.User;
import ola.com.booking.model.UserDTO;

public interface UserService {

	public void saveUser(User user);
	public UserDTO validateUser(String username, String password);
}
