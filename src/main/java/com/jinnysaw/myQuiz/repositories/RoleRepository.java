/**
 * 
 */
package com.jinnysaw.myQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jinnysaw.myQuiz.security.Role;

/**
 * @author jinnysaw
 * Datetime 2018Feb08 4:23 PM
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}