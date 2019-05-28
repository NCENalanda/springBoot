package com.rest.user.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.user.api.dao.UserRepository;
import com.rest.user.api.dto.UserDto;
import com.rest.user.api.model.User;

@Service
@Transactional
public class UserService {
	static {System.out.println("UserService.static.enclosing_method()     service");}
	{System.out.println("UserService.nonstatic.enclosing_method()            service");}
	@Autowired(required=true)
	private UserRepository repository;
	
	
	public UserDto searchUser(String userName) {
		User model;
		
		System.out.println(userName);
		model=repository.findByUsername(userName);
		
		return this.convertModelToDto(model);
	}
	
	public String signup(UserDto dto) {
		User user,isUser=null;
		user=this.convertDtoToModel(dto);
		 isUser=repository.findByUsername(user.getUsername());
		 if(isUser==null) {
			repository.save(user);
			return "scussful";
		 }
		 return "Unscussful";
	}
	
	public User convertDtoToModel(UserDto dto) {
		User model=null;
		model=new User();
		model.setFirsrname(dto.getFirsrname());
		model.setLastname(dto.getLastname());
		model.setUsername(dto.getUsername());
		model.setContact(dto.getContact());
		model.setAddress(dto.getAddress());
		model.setPassword(dto.getPassword());
		return model;
	}
	
	public UserDto convertModelToDto(User model) {
		UserDto dto=null;
		dto=new UserDto();
		dto.setUsername(model.getUsername());
		dto.setFirsrname(model.getUsername());
		dto.setLastname(model.getLastname());
		dto.setContact(model.getContact());
		dto.setAddress(model.getAddress());
		dto.setPassword("***********");
		return dto;
	}

}
