/**
 * 
 */
package com.jinnysaw.myQuiz.controllers.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import com.jinnysaw.myQuiz.exceptions.ModelVerificationException;

/**
 * @author jinnysaw
 * DateTime : 2018Fec04 07:17 PM
 */
public class RestVerifier {
	private static final Logger logger = LoggerFactory.getLogger(RestVerifier.class);
	public static void verifyModelResult(BindingResult result) throws ModelVerificationException{
		if(result.hasErrors()){
			logger.error(result.toString());
			throw new ModelVerificationException(result.getFieldError().getDefaultMessage());
		}
	}
}
