package com.jpa.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.api.dao.CustumberRepository;
import com.jpa.api.model.Custumber1;
import com.jpa.api.model.Email1;
import com.jpa.api.model.Phone1;

@SpringBootApplication
public class JpaApp2Application {

	
	private static final Logger log = LoggerFactory.getLogger(JpaApp2Application.class);

	
	public static void main(String[] args) {
		SpringApplication.run(JpaApp2Application.class, args);
	}
	@Bean
	public CommandLineRunner demo(CustumberRepository repo) {
		return (args)->{
			
			/*
			log.info("  ***      SAVE THE OBJECT     ***    "+'\n');
			repo.save(new Custumber1("Ayush"," ","Kumar"));
			repo.save(new Custumber1("Sandeep","Kumar","Sahu"));
			repo.save(new Custumber1("Bharat","Kumar","Patel"));
			
			log.info("  ***      FETCH THE ALL OBJECT     ***    "+'\n');
			for(Custumber1 custumber1:repo.findAll()) {
				log.info(custumber1.toString()+"      "+'\n');
			}
			
			*/
			
			log.info("  ***      FETCH THE ALL OBJECT     ***    "+'\n');
			Custumber1 custumber1=new Custumber1("Piyush"," ","Kumar");
			Phone1 phone1=new Phone1(new BigInteger("6573779047"),"HOME");
			Email1 email1=new Email1("piyush@gmail.com","PERSONAL");
			
			/*
			List<Phone1> phList=new ArrayList<>();
			phList.add(phone1);
			custumber1.setPhone1s(phList);
			*/
			
			List<Email1> emList=new ArrayList<>();
			emList.add(email1);
			custumber1.setEmail1s(emList);
			
			//custumber1.addEmail1(email1);
			//custumber1.addPhone1(phone1);
			
			log.info('\n'+"    ###      "+custumber1.toString()+"      "+"    ###     "+'\n');
			log.info('\n'+"    ###      "+custumber1.getEmail1s().toString()+"      "+"    ###     "+'\n');
			//log.info('\n'+"    ###      "+custumber1.getPhone1s().toString()+"      "+"    ###     "+'\n');
			log.info("  ***      ADD OBJECT     ***    "+'\n');
			repo.save(custumber1);
			//repo.saveAndFlush(custumber1);
			
		};
	}

}
