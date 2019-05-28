package com.jpa.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.api.dao.CustumberRepository;
import com.jpa.api.model.Custumber1;

@SpringBootApplication
public class JpaApp3Application {

	
	private static final Logger log = LoggerFactory.getLogger(JpaApp3Application.class);

	
	public static void main(String[] args) {
		SpringApplication.run(JpaApp3Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustumberRepository repo) {
		return (args) ->{
			log.info("   ***  SAVE THE OBJECT   ***    ");
			repo.save(new Custumber1("Ayush"," ","Kumar"));
		};
	}

}
