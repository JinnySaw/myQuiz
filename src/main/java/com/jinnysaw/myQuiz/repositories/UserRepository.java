/**
 * 
 */
package com.jinnysaw.myQuiz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jinnysaw.myQuiz.models.User;

/**
 * @author jinnysaw
 * Datetime 2018Feb08 10:27 AM
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
}
