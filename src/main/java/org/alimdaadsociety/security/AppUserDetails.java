package org.alimdaadsociety.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.alimdaadsociety.model.bean.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUserDetails extends AppUser implements UserDetails
{
	
	
	public AppUserDetails(final AppUser appUser ) {
		super(appUser);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		return getAppUserRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return super.getPassword();
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
		return true;
	}	
}