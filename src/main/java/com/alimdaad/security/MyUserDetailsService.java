package com.alimdaad.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alimdaad.model.bean.Users;
import com.alimdaad.model.repository.UsersRepository;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService
{
	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users users = usersRepository.findByEmail(email);
		
		if(users == null)
			throw new UsernameNotFoundException("User not found");
		
		return new MyUserDetails(users);
	}
	
}
