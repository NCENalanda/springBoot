package com.ltd.pvt.dem.vendoragency.api.service;

import java.util.List;

import com.ltd.pvt.dem.vendoragency.api.dto.AgencyDetail;
import com.ltd.pvt.dem.vendoragency.api.dto.AgencySignin;
import com.ltd.pvt.dem.vendoragency.api.dto.AgencySignup;
import com.ltd.pvt.dem.vendoragency.api.exception.UserAlreadyExistException;
import com.ltd.pvt.dem.vendoragency.api.exception.UserNotFoundException;
import com.ltd.pvt.dem.vendoragency.api.exception.UsernameAndPasswordNotMatchException;




/**
 * This is UserService Interface
 * 
 * 
 * */

public interface UserService {
	
	
	 public AgencyDetail searchAgencyEmail(String userName) throws UserNotFoundException;
	 public String signup(AgencySignup dto) throws UserAlreadyExistException;
	 public String signin(AgencySignin signin) throws Exception;
	 public List<String> fetchAllUsername() throws UserNotFoundException;

}
