package org.alimdaadsociety.controller;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.alimdaadsociety.model.bean.AppUser;
import org.alimdaadsociety.model.bean.AppUserToken;
import org.alimdaadsociety.model.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

	@Autowired
	AppUserService appUserService;

	@PostMapping("/auth/Signup/{token}")
	public void signup(@RequestBody AppUser appUser, @PathVariable String token) throws Exception {

		appUserService.Signup(appUser, token);
	}		
	
	@PostMapping("/auth/ForgotPassword")
	public void forgotPassword(@RequestBody Map<String, String> jsonEmail) throws MessagingException {
		appUserService.forgotPassword(jsonEmail.get("email"));
	}
	
	@PostMapping("/auth/ChangePassword/{token}")
	public void changePassword(@RequestBody Map<String, String> userpassword, @PathVariable String token) throws Exception {
		appUserService.changePassword(userpassword.get("password"), token);
	}


	@PostMapping("/SignupToken")
	public void generateUserSignupToken(@RequestBody Map<String, String> jsonEmail) throws MessagingException {		
		appUserService.generateUserSignupToken(jsonEmail.get("email"));
	}
	
	@GetMapping("/Tokens")
	public List<AppUserToken> getTokens() {
		return appUserService.getTokens();
	}

	@DeleteMapping("/Token")
	public void deleteToken(String tokenId) {
		appUserService.deleteToken(tokenId);
	}

	@GetMapping("/AppUsers")
	public List<AppUser> getAppUsers() {
		return appUserService.findAll();
	}


	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello()
	{	
		return "hello";
	}
}
