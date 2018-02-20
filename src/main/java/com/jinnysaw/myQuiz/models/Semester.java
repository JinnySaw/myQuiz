/**
 * 
 */
package com.jinnysaw.myQuiz.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jinnysaw
 * DateTime 2018Feb07 01:30 PM
 */
@Entity
@Table(name="semester")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"}, allowGetters= true)
public class Semester {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="semester", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	private List<Course> courses;
	
//	@ManyToOne
//	@JsonIgnore
//	private School school;
	
	@NotBlank
	private String Semestername; 
	
	private int Year;
	private String Term;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
//	public School getSchool() {
//		return school;
//	}
//	public void setSchool(School school) {
//		this.school = school;
//	}
	
	public int getYear() {
		return Year;
	}
	public String getSemestername() {
		return Semestername;
	}
	public void setSemestername(String semestername) {
		Semestername = semestername;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getTerm() {
		return Term;
	}
	public void setTerm(String term) {
		Term = term;
	}
	
	
}
