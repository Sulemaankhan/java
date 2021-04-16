package ola.com.booking.service.impl;

import ola.com.booking.dao.UserDao;
import ola.com.booking.dao.impl.UserDaoImpl;
import ola.com.booking.helper.UserHelper;
import ola.com.booking.model.User;
import ola.com.booking.model.UserDTO;
import ola.com.booking.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao userDao;

	public void saveUser(User user) {
		userDao = new UserDaoImpl();
		
		user.setId(UserHelper.getIncrement());
		userDao.saveUser(user);	
	}

	@Override
	public UserDTO validateUser(String username, String password) {
		UserDTO udto=new UserDTO();
		User user=userDao.validateUser(username, password);
		
		//fatching detaild from db
		udto.setName(user.getName());
		udto.setPassword(user.getPassword());
		udto.setId(user.getuserId());
		return udto;
	}
}
