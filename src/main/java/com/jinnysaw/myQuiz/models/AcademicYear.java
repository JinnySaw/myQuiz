/**
 * 
 */
package com.jinnysaw.myQuiz.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author jinnysaw
 * DateTime 2018Feb09 10:23 PM
 */
@Entity
@Table(name="academicyear")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value={"createdAt","updatedAt"}, allowGetters= true)
public class AcademicYear implements Serializable{
	private static final long serialVersionUID =771321L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	
	@ManyToOne
	private School school;
	
	@NotBlank
	private String Academicname;
	
	private String Year;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public void setShcool(School shcool) {
		this.school = shcool;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getAcademicname() {
		return Academicname;
	}

	public void setAcademicname(String academicname) {
		Academicname = academicname;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}
	
}
