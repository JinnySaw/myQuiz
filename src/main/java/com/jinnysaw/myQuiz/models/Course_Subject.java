/**
 * 
 */
package com.jinnysaw.myQuiz.models;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author jinnysaw
 * DateTime: 2018Feb07 10:06 PM
 */
public class Course_Subject implements Serializable{
	private static final long serialVersionUID = 771321L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="courseid")
	private Course course;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="subjectid")
	private Subject subject;
	
	public Course_Subject(){}
	public Course_Subject(Course course, Subject subject){
		this.course = course;
		this.subject = subject;
	}
}
