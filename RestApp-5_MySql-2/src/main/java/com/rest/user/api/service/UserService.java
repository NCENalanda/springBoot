package com.rest.user.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.mockito.internal.stubbing.answers.ThrowsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.exceptions.PasswordExpiredException;
import com.rest.user.api.config.UserConfig;
import com.rest.user.api.dao.UserRepository;
import com.rest.user.api.dto.UserSignup;
import com.rest.user.api.exception.UsernameAndPasswordNotMatchException;
import com.rest.user.api.exception.UserAlreadyExistException;
import com.rest.user.api.exception.UserNotFoundException;
import com.rest.user.api.dto.UserSignin;
import com.rest.user.api.model.User;

@Service
@Transactional
public class UserService {

	static {
		System.out.println("UserService.static.enclosing_method()     service");
	}
	{
		System.out.println("UserService.nonstatic.enclosing_method()            service");
	}
	@Autowired(required = true)
	private UserRepository repository;
	@Autowired
	private UserConfig config;

	public UserSignup searchUser(String userName) throws UserNotFoundException {
		User model;
		UserSignup dto;
		try {
			System.out.println(userName);
			model = repository.findByUsername(userName);
			dto = config.convertModelToDto(model);
		} catch (Exception e) {
			throw new UserNotFoundException("User Not Found" + userName + "     " + e.getMessage());
		}
		return dto;
	}

	public String signup(UserSignup dto) throws UserAlreadyExistException {
		User user = null, isUser = null;

		user = config.convertDtoToModel(dto);
		dto = null;
		isUser = repository.findByUsername(user.getUsername());
		if (isUser == null) {
			repository.save(user);
			return " SignUp Scussful";
		}
		throw new UserAlreadyExistException("    User Already Exist   " + user.getUsername());
	}

	public String signin(UserSignin signin) throws UsernameAndPasswordNotMatchException {
		User isUser = null, model = null;
		boolean match = false;

		try {
			model = config.convertSigninToModel(signin);
			signin = null;
			isUser = repository.findByUsername(model.getUsername());
			match = isUser.getPassword().equals(model.getPassword());
			if (match)
				return "  NEXT  PAGE     ";
		} catch (Exception e) {
			throw new UsernameAndPasswordNotMatchException("Username or Password Not Matcht  " + model.getUsername());
		}
		throw new UsernameAndPasswordNotMatchException("Username or Password Not Matcht  " + model.getUsername());
	}

	public List<String> fetchAllUsername() throws UserNotFoundException {
		// TODO Auto-generated method stub
		List<User> userList = null;
		try {
			userList = repository.findAll();
			List<String> listUsername = new ArrayList();
			userList.forEach(model -> {
				String str = model.getUsername();
				listUsername.add(str);
			});
			return listUsername;
		} catch (Exception e) {
			throw new UserNotFoundException(" Record Not Available  ");
		}
	}

}
