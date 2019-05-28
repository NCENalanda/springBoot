package com.rest.user.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.user.api.dto.UserDto;
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
	public UserDto getUser(@PathVariable String username) {
		System.out.println(username);
		return userService.searchUser(username);	
	}
	
	@PostMapping("/signup")
	@ApiOperation(value="signup")
	public String signUp(@RequestBody UserDto user) {
		System.out.println("UserController.signUp()");
		 return userService.signup(user);
		
	}
}
