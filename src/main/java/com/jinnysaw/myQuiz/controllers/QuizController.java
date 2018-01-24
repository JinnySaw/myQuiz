/**
 * 
 */
package com.jinnysaw.myQuiz.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jinnysaw.myQuiz.models.Quiz;
import com.jinnysaw.myQuiz.repositories.QuizRepository;

/**
 * @author jinnysaw
 *
 */

@RestController
@RequestMapping("/api")
public class QuizController {
	
	@Autowired
	QuizRepository quizRepository;
	// Get All Quiz
	// This method is pretty straightforward. It calls JpaRepository’s findAll() method to retrieve all the notes from the database and returns the entire list.
	// The @GetMapping("/") annotation is a short form of @RequestMapping(value="/notes", method=RequestMethod.GET).
	@GetMapping("/quiz")
	public List<Quiz> getAllQuiz(){
		return quizRepository.findAll();
	}
	
	// Create a new Quiz
	// The @RequestBody annotation is used to bind the request body with a method parameter.
	// The @Valid annotation makes sure that the request body is valid. Remember, we had marked Quiz's title and content with @NotBlank annotation in the Note model?
	// If the request body doesn’t have a title or a content, then spring will return a 400 BadRequest error to the client.
	@PostMapping("/quiz")
	public Quiz createQuiz(@Valid @RequestBody Quiz quiz){
		return quizRepository.save(quiz);
	}
	
	// Get a Single Quiz
	// The @PathVariable annotation, as the name suggests, is used to bind a path variable with a method parameter.
	// In the above method, we are returning a ResponseEntity<Quiz> instead of Quiz. The ResponseEntity class gives us more flexibility while returning a response from the api.
	// For example, in the above api, If a quiz doesn’t exist with the given id, then we’re returning a 404 Not Found error with the help of ResponseEntity.
	@GetMapping("/quiz/{id}")
	public ResponseEntity<Quiz> getQuizById(@PathVariable(value="id") Long quizId){
		
		Quiz quiz = quizRepository.findOne(quizId);
		if(quiz ==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(quiz);
	}
	
	// Update a Quiz
	@PutMapping("/quiz/{id}")
	public ResponseEntity<Quiz> updateQuiz(@PathVariable(value="id") Long quizId, @Valid @RequestBody Quiz quizDetails){
		
		Quiz quiz = quizRepository.findOne(quizId);
		if(quiz ==null){
			return ResponseEntity.notFound().build();
		}
		
		quiz.setTitle(quizDetails.getTitle());
		quiz.setDescription(quizDetails.getDescription());
		Quiz updateQuiz = quizRepository.save(quiz);
		return ResponseEntity.ok(updateQuiz);
		
	}
	
	// Delete a Quiz
	public ResponseEntity<Quiz> deleteQuiz(@PathVariable(value="id") Long quizId){
		Quiz quiz = quizRepository.findOne(quizId);
		if(quiz == null){
			return ResponseEntity.notFound().build();
		}
		quizRepository.delete(quiz);
		return ResponseEntity.ok().build();
	}
}
