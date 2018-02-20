/**
 * 
 */
package com.jinnysaw.myQuiz.resource;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jinnysaw.myQuiz.service.UserService;

/**
 * @author jinnysaw
 * Datetime 2018Feb11 7:56 PM
 */
@RestController
public class LoginResource {
 @Autowired
 private UserService userService;
 @GetMapping("/token")
 public Map<String,String> token(HttpSession session, HttpServletRequest request){
	 System.out.println("hello from sprin token");
	 System.out.println(request.getRemoteHost());
	 
	 String remoteHost = request.getRemoteHost();
	 int portNumber = request.getRemotePort();
	 
	 System.out.println(remoteHost+":"+portNumber);
	 System.out.println(request.getRemoteAddr());
	 
	 return Collections.singletonMap("token", session.getId());
 }
 
 @GetMapping("/checkSession")
 public ResponseEntity checkSession(){
	 return new ResponseEntity("Session Active!",HttpStatus.OK);
 }
 // something need to ... // delete this 
 private void something()
 {}
 
 @PostMapping("/user/logout")
 public ResponseEntity logout(){
	 SecurityContextHolder.clearContext();
	 return new ResponseEntity("Logout Successfully!", HttpStatus.OK);
 }
}
