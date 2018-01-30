package org.alimdaadsociety.controller;

import org.alimdaadsociety.model.bean.AppUser;
import org.alimdaadsociety.model.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {
	
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/signup")
    public void signUp(@RequestBody AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        appUserRepository.save(user);
    }
	
	
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello()
	{	
		return "hello";
	}
}
