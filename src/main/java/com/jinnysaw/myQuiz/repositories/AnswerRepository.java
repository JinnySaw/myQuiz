/**
 * 
 */
package com.jinnysaw.myQuiz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jinnysaw.myQuiz.models.Answer;
import com.jinnysaw.myQuiz.models.Question;

/**
 * @author jinnysaw
 * Datetime : 2018Feb04 08:20 PM
 *
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long>{
	List<Answer> findByQuestionOrderByOrderAsc(Question question);

}
