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

import com.jinnysaw.myQuiz.models.AcademicYear;  
import com.jinnysaw.myQuiz.models.School;
import com.jinnysaw.myQuiz.repositories.AcademicRepository;
import com.jinnysaw.myQuiz.repositories.SchoolRepository;

/**
 * @author jinnysaw
 *
 */
@RestController
@RequestMapping("/api")
public class AcademicController {
	@Autowired
	AcademicRepository academicRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	// Get All AcademicYear
	// This method is pretty straightforward. It calls JpaRepository’s findAll() method to retrieve all the notes from the database and returns the entire list.
	// The @GetMapping("/") annotation is a short form of @RequestMapping(value="/notes", method=RequestMethod.GET).
	@GetMapping("/academic")
	public List<AcademicYear> getAllAcademicYear(){
		System.out.println("Get All AcademicYear");
		return (List<AcademicYear>) academicRepository.findAll();
		
	}
	
	// Create a new AcademicYear
	// The @RequestBody annotation is used to bind the request body with a method parameter.
	// The @Valid annotation makes sure that the request body is valid. Remember, we had marked AcademicYear's title and content with @NotBlank annotation in the Note model?
	// If the request body doesn’t have a title or a content, then spring will return a 400 BadRequest error to the client.
	@PostMapping("/academic")
	public AcademicYear createAcademicYear(@Valid @RequestBody AcademicYear academic //,@PathVariable(value="schoolid") Long schoolId)
			, @RequestParam long schoolId){
		System.out.println("save academic"+ academic);
		 
		//academic.get
		//System.out.println(academic.getSchool());;
		School school =  schoolRepository.findOne(schoolId);
		academic.setSchool(school);
		return academicRepository.save(academic);
	}
	
	// Get a Single AcademicYear
	// The @PathVariable annotation, as the name suggests, is used to bind a path variable with a method parameter.
	// In the above method, we are returning a ResponseEntity<AcademicYear> instead of AcademicYear. The ResponseEntity class gives us more flexibility while returning a response from the api.
	// For example, in the above api, If a AcademicYear doesn’t exist with the given id, then we’re returning a 404 Not Found error with the help of ResponseEntity.
	@GetMapping("/academic/{id}")
	public ResponseEntity<AcademicYear> getAcademicYearById(@PathVariable(value="id") Long academicId){
		
		AcademicYear academic = academicRepository.findOne(academicId);
		if(academic ==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(academic);
	}
	
	// Update a AcademicYear
	@PutMapping("/academic/{id}")
	public ResponseEntity<AcademicYear> updateAcademicYear(@PathVariable(value="id") Long academicId, @Valid @RequestBody AcademicYear academicDetails, @RequestParam long schoolId){
		
		AcademicYear academic = academicRepository.findOne(academicId);
		if(academic ==null){
			return ResponseEntity.notFound().build();
		}
		
		academic.setAcademicname(academicDetails.getAcademicname());
		academic.setYear(academicDetails.getYear()); 
		School school =  schoolRepository.findOne(schoolId);
		academic.setSchool(school);
//		academic.setSchool(academicDetails.getSchool()); 
		AcademicYear updateAcademic = academicRepository.save(academic);
		return ResponseEntity.ok(updateAcademic);
		
	}
	
	// Delete a academic
	@DeleteMapping("/academic/{id}")
	public ResponseEntity<AcademicYear> deleteAcademic(@PathVariable(value="id") Long academicId){
		AcademicYear academic = academicRepository.findOne(academicId);
		if(academic == null){
			return ResponseEntity.notFound().build();
		}
		System.out.println("Delete academic"+ academic);
		academicRepository.delete(academic);
		return ResponseEntity.ok().build();
	}
}
