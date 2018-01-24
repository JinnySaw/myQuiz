package com.jinnysaw.myQuiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyQuizApplication.class, args);
	}
}
