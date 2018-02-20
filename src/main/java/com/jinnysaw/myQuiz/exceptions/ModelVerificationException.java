/**
 * 
 */
package com.jinnysaw.myQuiz.exceptions;

/**
 * @author jinnysaw
 * DateTime : 2018Feb04 07:06 PM
 */
public class ModelVerificationException  extends myQuizException{
	private static final long serialVersionUID =1L;
	public ModelVerificationException(){
		super();
	}
	public ModelVerificationException(String message){
		super(message);
	}
}
