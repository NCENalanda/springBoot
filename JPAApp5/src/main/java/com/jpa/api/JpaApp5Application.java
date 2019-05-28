package com.jpa.api;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.api.model.Role2;
import com.jpa.api.model.User2;
import com.jpa.api.service.UserService;

@SpringBootApplication
public class JpaApp5Application {
	
	
	private static final Logger log = LoggerFactory.getLogger(JpaApp5Application.class);


	public static void main(String[] args) {
		SpringApplication.run(JpaApp5Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserService service) {
		return (args) -> {
			User2 user2=new User2();
			user2.setUserName("aaush0101@gmail.com");
			user2.setPassword("Qwerty");
			log.info('\n'+"        "+user2.toString()+"        "+'\n');
			
			Role2 role1= new Role2();
			Role2 role2= new Role2();role2.setRole("ADMIN");
			Role2 role3= new Role2();role3.setRole("GUEST");
			
			Set<Role2> roleSet= new HashSet<>();
			roleSet.add(role2);
			roleSet.add(role1);
			user2.setRoles(roleSet);
			//user2.getRoles().add(role3);
			log.info('\n'+"        "+user2.getRoles().toString()+"        "+'\n');
			service.save(user2);
		};
	}

}
