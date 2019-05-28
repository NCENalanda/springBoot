package com.rest.user.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.mockito.internal.stubbing.answers.ThrowsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.user.api.config.UserConfig;
import com.rest.user.api.dao.UserRepository;
import com.rest.user.api.dto.UserSignup;
import com.rest.user.api.dto.UserSignin;
import com.rest.user.api.model.User;

@Service
@Transactional
public class UserService {
	static {System.out.println("UserService.static.enclosing_method()     service");}
	{System.out.println("UserService.nonstatic.enclosing_method()            service");}
	@Autowired(required=true)
	private UserRepository repository;
	@Autowired
	private UserConfig config;
	
	
	public UserSignup searchUser(String userName) {
		User model=null;
		
		System.out.println(userName);
		model=repository.findByUsername(userName);
		
		if(model==null) {
			//throw new Throwable("This UserName does not exist"+userName);
		}
		return config.convertModelToDto(model);
		
	}
	
	public String signup(UserSignup dto) {
		User user=null,isUser=null;
		user=config.convertDtoToModel(dto);
		dto=null;
		 isUser=repository.findByUsername(user.getUsername());
		 if(isUser==null) {
			repository.save(user);
			return " SignUp Scussful";
		 }
		 return "User Already Exist";
	}
	
	public String signin(UserSignin signin) {
		User isUser=null,model=null;
		boolean match=false;
		model=config.convertSigninToModel(signin);
		signin=null;
		isUser=repository.findByUsername(model.getUsername());
		if(isUser!=null) {
			match=isUser.getPassword().equals(model.getPassword());
			if(match) {
				return "next page";
			}
			return "Incorrect Password";
		}
		return "User Not Exist";
		
	}

	public List<String> fetchAllUsername() {
		// TODO Auto-generated method stub
		List<User> userList=null;
		
		userList=repository.findAll();
		List<String> listUsername=new ArrayList();
		userList.forEach(model ->{
			String str=model.getUsername();
			listUsername.add(str);
		});
		return listUsername;
	}
	

}
