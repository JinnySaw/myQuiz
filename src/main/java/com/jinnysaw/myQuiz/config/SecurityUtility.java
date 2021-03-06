/**
 * 
 */
package com.jinnysaw.myQuiz.config;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author jinnysaw
 * Datetime 2018Feb08 9:55 PM
 */
@Component
public class SecurityUtility {
	private static final String SALT="salt";
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(12,new SecureRandom(SALT.getBytes()));
	}
	
	@Bean
	public static String randomPasswrod(){
		String SALTCHARS="QAZWSXEDCRFVTGBYHNUJMIKOLP1234567890";
		StringBuilder salt= new StringBuilder();
		Random random= new Random();
		
		while(salt.length() <18){
			int index =(int) (random.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS).charAt(index);
		}
		
		String saltStr =salt.toString();
		return saltStr;
	}
}
