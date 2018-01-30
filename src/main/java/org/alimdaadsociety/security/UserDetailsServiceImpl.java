package org.alimdaadsociety.security;

import org.alimdaadsociety.model.bean.AppUser;
import org.alimdaadsociety.model.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService
{
	@Autowired
	AppUserRepository appUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		AppUser appUser = appUserRepository.findByEmail(email);
		
		if(appUser == null)
			throw new UsernameNotFoundException(String.format("The user %email doesn't exist", email));
		
//		return new AppUserDetails(appUser);
		
/*        List<GrantedAuthority> authorities = new ArrayList<>();
        appUser.getAppUserRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });
*/
		
		List<SimpleGrantedAuthority> authorities = appUser
														.getAppUserRoles()
														.stream()
														.map(role -> new SimpleGrantedAuthority(role.getRole()))
														.collect(Collectors.toList());
        
		return new User(appUser.getEmail(), appUser.getPassword(), authorities);
	}
	
}
