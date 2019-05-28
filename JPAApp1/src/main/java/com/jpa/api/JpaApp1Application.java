package com.jpa.api;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.api.dao.UserRepository;
import com.jpa.api.model.Custumber;
import com.jpa.api.model.Email;

@SpringBootApplication
public class JpaApp1Application {
	
	
	private static final Logger log = LoggerFactory.getLogger(JpaApp1Application.class);

	
	public static void main(String[] args) {
		SpringApplication.run(JpaApp1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository repo) {
		return (args)->{
			/*
			//save couble of object
			repo.save(new Custumber("Ayush"," ","Kumar"));
			repo.save(new Custumber("Sandeep","Kumar","Sahu"));
			repo.save(new Custumber("Bharat","Kumar","Patel"));
			log.info("   ****   SAVE THE DATA    ****     ");
			
			
			
			log.info("   ****   FETCH THE DATA    ****     ");
			//fetch the All Object
			for(Custumber custumber: repo.findAll()) {
				log.info(custumber.toString());
			}
			
			*/
			log.info("   ****   SAVE THE DATA    ****     ");
			Custumber custumber=new Custumber("Piyush","","Kumar");
			Email email=new Email("Piyush@gmail.com");
			ArrayList<Email> list=new ArrayList<>();
			list.add(email);
			custumber.setEmails(list);
			repo.save(custumber);
		};
	
	}
}
	