/**
 * 
 */
package com.jinnysaw.myQuiz.service.impl;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinnysaw.myQuiz.models.User;
import com.jinnysaw.myQuiz.repositories.RoleRepository;
import com.jinnysaw.myQuiz.repositories.UserRepository;
import com.jinnysaw.myQuiz.security.UserRole;
import com.jinnysaw.myQuiz.service.UserService;

/**
 * @author jinnysaw
 * Datetime 2018Feb08 3:45 PM
 */
@Service
public class UserServiceImpl implements UserService{
	private static final Logger LOG= LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			System.out.println("kk");
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}
	
}
