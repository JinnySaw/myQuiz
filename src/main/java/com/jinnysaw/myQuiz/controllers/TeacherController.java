/**
 * 
 */
package com.jinnysaw.myQuiz.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jinnysaw.myQuiz.models.School;
import com.jinnysaw.myQuiz.models.Teacher;
import com.jinnysaw.myQuiz.repositories.SchoolRepository;
import com.jinnysaw.myQuiz.repositories.TeacherRepository;

/**
 * @author jinnysaw
 *
 */
@RestController
@RequestMapping("/api")
public class TeacherController {
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	SchoolRepository schoolRepository; 
	@GetMapping("/teacher")
	public List<Teacher> getAllTeacher(){
		System.out.println("Get All teachers");
		return (List<Teacher>) teacherRepository.findAll();
		
	}
	
	// Create a new teacher
	// The @RequestBody annotation is used to bind the request body with a method parameter.
	// The @Valid annotation makes sure that the request body is valid. Remember, we had marked teacher's title and content with @NotBlank annotation in the Note model?
	// If the request body doesn’t have a title or a content, then spring will return a 400 BadRequest error to the client.
	@PostMapping("/teacher")
	public Teacher createTeacher(@Valid @RequestBody Teacher teacher //,@PathVariable(value="schoolid") Long schoolId)
			, @RequestParam long schoolId){
		System.out.println("save teacher"+ teacher);
		 
		//teacher .get
		//System.out.println(teacher.getSchool());;
		School school =  schoolRepository.findOne(schoolId);
		teacher.setTeacher_school(school);
		return teacherRepository.save(teacher);
	}
	
	// Get a Single teacher
	// The @PathVariable annotation, as the name suggests, is used to bind a path variable with a method parameter.
	// In the above method, we are returning a ResponseEntity<Teacher> instead of teacher. The ResponseEntity class gives us more flexibility while returning a response from the api.
	// For example, in the above api, If a Teacher doesn’t exist with the given id, then we’re returning a 404 Not Found error with the help of ResponseEntity.
	@GetMapping("/teacher/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable(value="id") Long teacherId){
		
		Teacher teacher = teacherRepository.findOne(teacherId);
		if(teacher ==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(teacher);
	}
	
	// Update a teacher
	@PutMapping("/teacher/{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable(value="id") Long teacherId, @Valid @RequestBody Teacher teacherDetails, @RequestParam long schoolId){
		
		Teacher teacher = teacherRepository.findOne(teacherId);
		if(teacher ==null){
			return ResponseEntity.notFound().build();
		}
		
		teacher.setTeacherName(teacherDetails.getTeacherName());
		teacher.setAddress(teacherDetails.getAddress());
		teacher.setPhoneNumber(teacherDetails.getPhoneNumber());
		teacher.setEmail(teacherDetails.getEmail()); 
		School school =  schoolRepository.findOne(schoolId);
		teacher.setTeacher_school(school); 
		Teacher updateTeacher = teacherRepository.save(teacher);
		return ResponseEntity.ok(updateTeacher);
		
	}
	
	// Delete a teacher
	@DeleteMapping("/teacher/{id}")
	public ResponseEntity<Teacher> deleteTeacher(@PathVariable(value="id") Long teacherId){
		Teacher teacher = teacherRepository.findOne(teacherId);
		if(teacher == null){
			return ResponseEntity.notFound().build();
		}
		System.out.println("Delete teacher"+ teacher);
		teacherRepository.delete(teacher);
		return ResponseEntity.ok().build();
	}
}
