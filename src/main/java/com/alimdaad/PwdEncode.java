package com.alimdaad;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PwdEncode {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder e=new BCryptPasswordEncoder();
		
		System.out.println(e.encode("pwd"));
	}

}
