package com.alimdaad.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alimdaad.model.bean.Users;

public class MyUserDetails extends Users implements UserDetails
{
	
	
	public MyUserDetails(final Users users ) {
		super(users);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		return getUserRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return super.getPasssword();
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return (super.getEnabledState()==1)?true:false;
	}	
}