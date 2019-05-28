package com.rest.user.api.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.user.api.dto.UserSignup;
import com.rest.user.api.exception.UsernameAndPasswordNotMatchException;
import com.rest.user.api.exception.UserAlreadyExistException;
import com.rest.user.api.exception.UserNotFoundException;
import com.rest.user.api.dto.UserDetail;
import com.rest.user.api.dto.UserSignin;
import com.rest.user.api.model.User;
import com.rest.user.api.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value="User Service")
public class UserController {
	
	static {System.out.println("UserService.static.enclosing_method()     Controller");}
	{System.out.println("UserService.nonstatic.enclosing_method()            Controller");}
	
	@Autowired(required=true)
	private UserService userService;

	@GetMapping("/get/{username}")
	@ApiOperation(value="User Details by username")
	public UserDetail getUser(@Email @PathVariable String username) throws UserNotFoundException {
		System.out.println(username);
		return userService.searchUser(username);	
	}
	
	@PostMapping("/signup")
	@ApiOperation(value="signup")
	public String signUp(@Valid @RequestBody UserSignup user) throws UserAlreadyExistException {
		System.out.println("UserController.signUp()");
		 return userService.signup(user);	
	}
	
	@PostMapping("/signin")
	@ApiOperation(value="signin")
	public String signin(@Valid @RequestBody UserSignin signin) throws UsernameAndPasswordNotMatchException {
		System.out.println("UserController.signUp()");
		 return userService.signin(signin);	
	}
	
	@GetMapping("/getAllUserName")
	@ApiOperation(value="AllUserName")
	public List<String> signin() throws UserNotFoundException {
		System.out.println("UserController.signUp()");
		 return userService.fetchAllUsername();	
	}
}
