package org.alimdaadsociety.model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppUserToken {
	@Id
	private String token;
	
	private Date token_gen_time;
	
	private String token_email;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getToken_gen_time() {
		return token_gen_time;
	}

	public void setToken_gen_time(Date token_gen_time) {
		this.token_gen_time = token_gen_time;
	}

	public String getToken_email() {
		return token_email;
	}

	public void setToken_email(String token_email) {
		this.token_email = token_email;
	}


}
