/**
 * 
 */
package com.jinnysaw.myQuiz.security;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author jinnysaw
 * DateTime 2018Feb07 10:29 PM
 */
public class Authority implements GrantedAuthority, Serializable{

	private static final long serialVersionUID = 771321L;
	private final String authority;
	
	public Authority(String authority){
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

}
