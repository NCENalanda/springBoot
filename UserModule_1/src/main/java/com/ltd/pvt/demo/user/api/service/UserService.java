package com.ltd.pvt.demo.user.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltd.pvt.demo.user.api.config.UserConfig;
import com.ltd.pvt.demo.user.api.dao.UserRepository;
import com.ltd.pvt.demo.user.api.dto.UserDetail;
import com.ltd.pvt.demo.user.api.dto.UserSignin;
import com.ltd.pvt.demo.user.api.dto.UserSignup;
import com.ltd.pvt.demo.user.api.exception.UserAlreadyExistException;
import com.ltd.pvt.demo.user.api.exception.UserNotFoundException;
import com.ltd.pvt.demo.user.api.exception.UsernameAndPasswordNotMatchException;
import com.ltd.pvt.demo.user.api.model.User;

@Service
@Transactional
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired(required=true)
	private UserRepository repository;
	@Autowired
	private UserConfig config;
	
	
	public UserDetail searchUser(String userName) throws UserNotFoundException {
		User model;
		UserDetail detail;
		 log.debug("UserService.searchUser()");
		try {
		model=repository.findByUsername(userName);
		detail=config.convertModelToUserDetail(model);
		}
		catch (Exception e){
			log.warn("UserService.searchUser()  "+e.getMessage());
			throw new UserNotFoundException("    User Not Found    "+userName);
		}
		return detail;
	}
	
	public String signup(UserSignup dto) throws UserAlreadyExistException {
		User user=null,isUser=null;
		log.debug("UserService.signup()");
		user=config.convertDtoToModel(dto);
		dto=null;
		 isUser=repository.findByUsername(user.getUsername());
		 if(isUser==null) {
			repository.save(user);
			return " SignUp Scussful";
		 }
		 
		 log.warn("UserService.signup()");
		throw new UserAlreadyExistException("    User Already Exist   "+user.getUsername());
	}
	
	public String signin(UserSignin signin) throws UsernameAndPasswordNotMatchException {
		User isUser=null,model=null;
		boolean match=false;
		log.debug("UserService.signin()");
		try {
			model=config.convertSigninToModel(signin);
			signin=null;
		    isUser=repository.findByUsername(model.getUsername());
			match=isUser.getPassword().equals(model.getPassword());
			if(match)
			return "  NEXT  PAGE     ";
			}
		catch (Exception e) {
			log.warn("UserService.signin()"+e.getMessage());
		throw new UsernameAndPasswordNotMatchException("Username or Password Not Match  "+model.getUsername());
		}
		log.warn("UserService.signin()");
		throw new UsernameAndPasswordNotMatchException("Username or Password Not Matcht  "+model.getUsername());
	}

	public List<String> fetchAllUsername() throws UserNotFoundException {
		// TODO Auto-generated method stub
		List<User> userList=null;
		log.debug("UserService.fetchAllUsername()");
		try {
		userList=repository.findAll();
		List<String> listUsername=new ArrayList();
		userList.forEach(model ->{
			String str=model.getUsername();
			listUsername.add(str);
		});
		return listUsername;
		}
		catch (Exception e) {
			log.warn("   UserService.fetchAllUsername()  "+e.getMessage());
			throw new UserNotFoundException(" Record Not Available  ");
		}
	}
	

}
