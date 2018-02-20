 /**
  * 
  */
 package com.jinnysaw.myQuiz.config;
 
 import org.springframework.context.annotation.Bean;
 import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
 import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
 /**
  * @author jinnysaw
  *
  */
 @EnableRedisHttpSession
public class HttpSesstionConfig {
	@Bean
 	public LettuceConnectionFactory connectionFactory(){
 		return new LettuceConnectionFactory();
 	}
 }
