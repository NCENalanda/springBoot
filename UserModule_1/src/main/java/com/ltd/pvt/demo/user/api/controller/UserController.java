package com.ltd.pvt.demo.user.api.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltd.pvt.demo.user.api.dto.UserDetail;
import com.ltd.pvt.demo.user.api.dto.UserSignin;
import com.ltd.pvt.demo.user.api.dto.UserSignup;
import com.ltd.pvt.demo.user.api.exception.UserAlreadyExistException;
import com.ltd.pvt.demo.user.api.exception.UserNotFoundException;
import com.ltd.pvt.demo.user.api.exception.UsernameAndPasswordNotMatchException;
import com.ltd.pvt.demo.user.api.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value="User Service")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired(required=true)
	private UserService userService;

	@GetMapping("/get/{username}")
	@ApiOperation(value="User Details by username")
	public UserDetail getUser(@PathVariable String username) throws UserNotFoundException {
		log.debug("UserController.getUser()");
		return userService.searchUser(username);	
	}
	
	@PostMapping("/signup")
	@ApiOperation(value="signup")
	public String signUp(@Valid @RequestBody UserSignup user) throws UserAlreadyExistException {
		log.debug("UserController.signUp()");
		 return userService.signup(user);	
	}
	
	@PostMapping("/signin")
	@ApiOperation(value="signin")
	public String signin(@Valid @RequestBody UserSignin signin) throws UsernameAndPasswordNotMatchException {
		log.debug("UserController.signin() ");
		 return userService.signin(signin);	
	}
	
	@GetMapping("/getAllUserName")
	@ApiOperation(value="AllUserName")
	public List<String> getAllUsername() throws UserNotFoundException {
		log.debug("UserController. getAllUsername()");
		 return userService.fetchAllUsername();	
	}
}
