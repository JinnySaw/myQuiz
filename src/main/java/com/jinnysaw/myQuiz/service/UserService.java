/**
 * 
 */
package com.jinnysaw.myQuiz.service;

import java.util.Set;

import com.jinnysaw.myQuiz.models.User;
import com.jinnysaw.myQuiz.security.UserRole;

/**
 * @author jinnysaw
 * DateTime 2018Feb08 3:58 PM
 */
public interface UserService {
 User createUser(User user,Set<UserRole> userRoles);
}
