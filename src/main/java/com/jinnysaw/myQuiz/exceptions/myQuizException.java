/**
 * 
 */
package com.jinnysaw.myQuiz.exceptions;

/**
 * @author jinnysaw
 * DateTime : 2018Feb04 07:13 PM
 */
public class myQuizException extends RuntimeException{
	private static final long serialVersionUID =1L;
	
	public myQuizException(){
		super();
	}
	public myQuizException(String message){
		super(message);
	}
}
