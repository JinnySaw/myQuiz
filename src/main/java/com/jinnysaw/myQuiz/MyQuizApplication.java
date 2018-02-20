package com.jinnysaw.myQuiz;
 
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing; 
import com.jinnysaw.myQuiz.config.SecurityUtility;
import com.jinnysaw.myQuiz.models.User;
import com.jinnysaw.myQuiz.security.Role;
import com.jinnysaw.myQuiz.security.UserRole;import com.jinnysaw.myQuiz.service.UserService;

@SpringBootApplication
@EnableJpaAuditing
public class MyQuizApplication implements CommandLineRunner{

 @Autowired
private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(MyQuizApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
////		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
////		Calendar cal = Calendar.getInstance();
////		System.out.println(dateFormat.format(cal)); //2016/11/16 12:08:43
		User user1 =new User();
		user1.setUsername("saw");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("1"));
		user1.setEmail("jinny.developer@gmail.com");
		//user1.setCreatedDate(cal);
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user1,role1));
		//System.out.println("before save");
		userService.createUser(user1,userRoles);
		userRoles.clear();
	}
}
