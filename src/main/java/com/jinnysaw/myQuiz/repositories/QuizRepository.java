/**
 * 
 */
package com.jinnysaw.myQuiz.repositories;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jinnysaw.myQuiz.models.Quiz;

/**
 * @author jinnysaw
 *
 */
@Repository
public interface QuizRepository extends CrudRepository<Quiz,Long>{
	
}
