//package com.training.configsecurity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.training.entity.User;
//import com.training.repo.UserRepository;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//	static {
//		System.out.println("UserDetailsServiceImpl");
//	}
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.getUserByUsername(username);
//		System.out.println("getUserByUsername   :" + user.getUserName());
//		System.out.println("getUserByPassword   :" + user.getPassword());
//
//		if (user == null) {
//			throw new UsernameNotFoundException("Could not find user");
//		}
//		return new MyUserDetails(user);
//	}
//}
