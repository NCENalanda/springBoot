package com.jpa.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.api.service.ManyToOneService;

@SpringBootApplication
public class NatJpaApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(NatJpaApp1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo1(ManyToOneService service) {
		return (args)->{
			//service.saveEmpwithDept();
			//service.saveEmpwithDept();
			service.listEmpwithDept();
			//service.addNewEmpToExistingDept();
			//service.addExistingEmpToNewDept();
			//service.changeExistingEmpToExistingDept();
			//service.deleteAllEmpsWithDept();
		};
	} 

}
