package org.alimdaadsociety.utility;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OtpGenerator {
	
//	public static void main(String[] args) {
//		System.out.println(generateOtp(8));
//	}

	public static String generateOtp(int len) {
		
        // A strong password has Cap_chars, Lower_chars,
        // numeric value and symbols. So we are using all of
        // them to generate our password
		
	    String capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//      String small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
//	    String symbols = "!@#$%^&*_=+-/.?<>)";
 
        String values = capital_chars + numbers;
 
        // Using random method
        Random rndm_method = new Random();
 
        char[] password = new char[len];
 
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] = values.charAt(rndm_method.nextInt(values.length())); 
        }
        return new String(password);
    }
		
}
