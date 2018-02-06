package org.alimdaadsociety.utility;

import java.util.Date;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PwdEncode {

	public static void main(String[] args) throws InterruptedException {
		
		BCryptPasswordEncoder e=new BCryptPasswordEncoder();
		
		System.out.println(e.encode("jwtpass"));
		
		ShaPasswordEncoder e1= new ShaPasswordEncoder(256);
		System.out.println(e1.encodePassword("jwtpass", e1));
		
		Date d1 = new Date();
		Thread.sleep(2000);
				
		Date d2 = new Date();
		
		System.out.println((d2.getTime()-d1.getTime())/1000);
		
	}

}
