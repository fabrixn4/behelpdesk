package com.fabrizio.helpdesk.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fabrizio.helpdesk.api.entity.User;
import com.fabrizio.helpdesk.api.security.jwt.JwtUserFactory;
import com.fabrizio.helpdesk.api.service.UserService;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with '%s'.", email));
		} else {
			return JwtUserFactory.create(user);
		}
	}
}
