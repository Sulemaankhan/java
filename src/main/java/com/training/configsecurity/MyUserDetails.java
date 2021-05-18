//package com.training.configsecurity;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.training.entity.User;
//
//
//
//
//public class MyUserDetails implements UserDetails {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	static {
//		System.out.println("MyUserDetails");
//	}
//
//	private User user;
//	
//	public MyUserDetails(User user) {
//		this.user = user;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
//		return Arrays.asList(authority);
//	}
//
//	@Override
//	public String getPassword() {
//		System.out.println("Password   :"+user.getPassword());
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		System.out.println("UserName   :"+user.getUserName());
//		return user.getUserName();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//}
