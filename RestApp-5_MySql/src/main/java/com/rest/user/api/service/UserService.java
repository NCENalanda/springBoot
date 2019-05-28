package com.rest.user.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.user.api.dao.UserRepository;
import com.rest.user.api.model.User;

@Service
@Transactional
public class UserService {
	static {System.out.println("UserService.static.enclosing_method()     service");}
	{System.out.println("UserService.nonstatic.enclosing_method()            service");}
	@Autowired(required=true)
	private UserRepository repository;
	
	
	public User searchUser(String userName) {
		System.out.println(userName);
		
		return repository.findByUsername(userName);
	}
	
	public String signup(User user) {
		User isUser=null;
		 isUser=repository.findByUsername(user.getUsername());
		 if(isUser==null) {
			repository.save(user);
			return "scussful";
		 }
		 return "Unscussful";
	}

}
