package com.jpa.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.api.model.Role3;
import com.jpa.api.model.User3;
import com.jpa.api.service.UserService;

@SpringBootApplication
public class NatJpaApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(NatJpaApp2Application.class, args);
		
	}
	
	@Bean 
	public CommandLineRunner demo(UserService service) {
		return (args)->{
			Role3 role3=new Role3();
			Role3 role2=new Role3(); role2.setRole("ADMIN");
			Role3 role1=new Role3(); role2.setRole("GUEST");
			
			
			User3 user3= new User3();
			user3.setPassword("Qwerty");
			user3.getRoles().add(role3);  user3.getRoles().add(role2);   user3.getRoles().add(role1);
			user3.setUserName("aaush01@gmail.com");
			
			service.listUser();
		};
	}

}
