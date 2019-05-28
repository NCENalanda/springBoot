package com.jpa.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List; 
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.api.dao.UserRepository;
import com.jpa.api.model.Company1;
import com.jpa.api.model.Phone1;
import com.jpa.api.model.Role1;
import com.jpa.api.model.User1;



@SpringBootApplication
public class JpaApp4Application {

	
	private static final Logger log = LoggerFactory.getLogger(JpaApp4Application.class);

	
	public static void main(String[] args) {
		SpringApplication.run(JpaApp4Application.class, args);
	}

	/*@Bean
	public CommandLineRunner demo(UserRepository repo) {
		return (args) ->{
			
			Role1 role1=new Role1() ;
			Role1 role2=new Role1("ADMIN") ;
			Role1 role3=new Role1() ;
			role3.setRole("OBSERVER");
			log.info('\n'+"        "+role1.getRole()+"    "+role2.getRole()+"        "+role3.getRole()+"      "+'\n');
			
			User1 user1=new User1("Ayush","Kumar","Qwerty");
			log.info('\n'+"        "+user1.toString()+"        "+'\n');
			Set<Role1> roleList =new HashSet<>();
			roleList.add(role1);
			roleList.add(role2);
			roleList.add(role3);
			user1.setRoles(roleList );
			
			
			log.info('\n'+"        "+user1.getRoles().toString()+"        "+'\n');
			
			User1 user12=repo.save(user1);
			
			log.info('\n'+"        "+user1.toString()+"        "+'\n');
		};
	}*/
	
	/*
	@Bean
	public CommandLineRunner demo(UserRepository repo) {
		return (args) ->{
			
			for (User1 user1 :repo.findAll()) {
				log.info('\n'+"        "+user1.toString()+"        "+'\n');
				//log.info('\n'+"        "+user1.getRoles().toString()+"        "+'\n');
				System.out.println(user1.getRoles().toString());
				
				Phone1 phone1=new Phone1(new BigInteger("8877290173"));
				Phone1 phone2=new Phone1(new BigInteger("9121772537"),"OFFICE");
				Phone1 phone3=new Phone1();
				phone3.setPhoneNo(new BigInteger("8051425229"));
				phone3.setType("PERSONAL");
				Set<Phone1> phoneList=new HashSet<>();
				phoneList.add(phone1);
				phoneList.add(phone2);
				phoneList.add(phone3);
				user1.setPhones(phoneList);
				log.info('\n'+"        "+user1.getPhones().toString()+"        "+'\n');
				
			}
			
		};
	}
*//*
	@Bean
	public CommandLineRunner demo(UserRepository repo) {
		return (args) ->{
			List<User1> userList=repo.findAll();
			Iterator<User1> itrerator= userList.iterator();
			while(itrerator.hasNext()) {
				User1 user1=itrerator.next();
				log.info('\n'+"        "+user1.toString()+"        "+'\n');
				System.out.println(user1.getRoles().toString());
				log.info('\n'+"        "+user1.getPhones().toString()+"        "+'\n');
				
				Company1 company1 = new Company1("HI-TECH BULIDERS GROUP PVT LMT");
				Set<Company1> comSet=new HashSet<>();
				comSet.add(company1);
				user1.setCompanies(comSet);
				
				//repo.save(user1);
				
				log.info('\n'+"        "+user1.getCompanies().toString()+"        "+'\n');
			}
		};
		
    }
	*/
	
	@Bean
	public CommandLineRunner demo(UserRepository repo) {
		return (args) ->{
			
			/*User1 user1 =new User1("Bharat", "Patel","ASDFGH");
			User1 user2 =new User1("Sandeep", "Sahu","ZXCVBN");
			List<User1> userList=new ArrayList<>();
			userList.add(user1);
			userList.add(user2);
			repo.saveAll(userList);*/
			repo.findAll().stream().forEach(user1->{
				log.info('\n'+"        "+user1.toString()+"        "+'\n');
				System.out.println(user1.getRoles().toString());
				log.info('\n'+"        "+user1.getPhones().toString()+"        "+'\n');
				log.info('\n'+"        "+user1.getCompanies().toString()+"        "+'\n');
				
			});
		};
	}
}
