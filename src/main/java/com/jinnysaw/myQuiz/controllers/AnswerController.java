/**
 * 
 */
package com.jinnysaw.myQuiz.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jinnysaw.myQuiz.models.Answer;
import com.jinnysaw.myQuiz.models.Question;
import com.jinnysaw.myQuiz.repositories.AnswerRepository;
import com.jinnysaw.myQuiz.repositories.QuestionRepository;

/**
 * @author jinnysaw
 * DateTime 2018Feb04 8:23 PM
 */

@RestController
@RequestMapping("/api")
public class AnswerController {
	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@PostMapping("/answer")
	public Answer createAnswer(@Valid @RequestBody Answer answer, @RequestParam long question_id){
		Question question = questionRepository.findOne(question_id);
		answer.setQuestion(question);
		
		return answerRepository.save(answer);
	}

	// Get an Answer
	@GetMapping("/answer/{id}")
	public ResponseEntity<Answer> getAnswerById(@PathVariable(value="id") Long answerId){
		Answer answer = answerRepository.findOne(answerId);
		if(answer ==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(answer);
		
	}
	// update an answer
	@PutMapping("/answer/{id}")
	public ResponseEntity<Answer> updateAnswer(@PathVariable(value="id") Long answerId, @Valid @RequestBody Answer answerDetails){
		Answer currentAnswer = answerRepository.findOne(answerId);
		if(currentAnswer ==null){
			return ResponseEntity.notFound().build();
		}
	 Answer newAnswer=	mergeAnswers(currentAnswer,answerDetails);
	 Answer updateAnswer = answerRepository.save(newAnswer);
	 return ResponseEntity.ok(updateAnswer);
	}
	
	// update all answers
	@PutMapping("/answer/updateAll")
	public void updateAll(@RequestBody List<Answer> answers){
		for(int i=0; i<answers.size();i++){
			Answer newAnswer = answers.get(i);
			newAnswer.setOrder(i+1);
			Answer currentAnswer = answerRepository.findOne(newAnswer.getId());
			if(currentAnswer ==null){
				//return ResponseEntity.notFound().build();
			}
			mergeAnswers(currentAnswer,newAnswer);
			answerRepository.save(currentAnswer);
		}
			
	}
	// Delete an answer
	@DeleteMapping("/answer/{id}")
	public ResponseEntity<Question> deleteAnswer(@PathVariable(value="id") Long answerId){
		Answer answer = answerRepository.findOne(answerId);
		if(answer ==null){
			return ResponseEntity.notFound().build();
		}
		
		answerRepository.delete(answer);
		return ResponseEntity.ok().build();
	} 
	
	private Answer mergeAnswers(Answer currentAnswer, Answer newAnswer){
		currentAnswer.setAnswertext(newAnswer.getAnswertext());
		currentAnswer.setCorrectAnswer(newAnswer.getCorrectAnswer());
		currentAnswer.setIsValid(newAnswer.getIsValid());
		currentAnswer.setUpdatedAt(newAnswer.getUpdatedAt());
		
		if(newAnswer.getOrder() !=null){
			currentAnswer.setOrder(newAnswer.getOrder());
		}
		return currentAnswer;
	}
}
