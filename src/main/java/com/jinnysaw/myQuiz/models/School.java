/**
 * 
 */
package com.jinnysaw.myQuiz.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jinnysaw
 *
 */
@Entity
@Table(name="school")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"}, allowGetters= true)
public class School implements Serializable{
	private static final long serialVersionUID = 771321L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@NotBlank
	private String Schoolname;
	
	@OneToMany(mappedBy="school", cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@JsonIgnore
	private List<AcademicYear> academicyears;

	@OneToMany(mappedBy="teacher_school", cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	@JsonIgnore
	private List<Teacher> teachers;
	
	@Column(nullable=false, updatable =false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(nullable =false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
//
	public String getSchoolname() {
		return Schoolname;
	}

	public void setSchoolname(String schoolname) {
		Schoolname = schoolname;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<AcademicYear> getAcademicyears() {
		return academicyears;
	}

	public void setAcademicyears(List<AcademicYear> academicyears) {
		this.academicyears = academicyears;
	}

//	public List<Teacher> getTeachers() {
//		return teachers;
//	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
