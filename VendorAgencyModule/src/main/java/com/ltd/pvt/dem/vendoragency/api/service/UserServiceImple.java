package com.ltd.pvt.dem.vendoragency.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltd.pvt.dem.vendoragency.api.adaptor.UserAdaptor;
import com.ltd.pvt.dem.vendoragency.api.config.SwaggerConfig;
import com.ltd.pvt.dem.vendoragency.api.dao.UserRepository;
import com.ltd.pvt.dem.vendoragency.api.dto.AgencyDetail;
import com.ltd.pvt.dem.vendoragency.api.dto.AgencySignin;
import com.ltd.pvt.dem.vendoragency.api.dto.AgencySignup;
import com.ltd.pvt.dem.vendoragency.api.exception.UserAlreadyExistException;
import com.ltd.pvt.dem.vendoragency.api.exception.UserNotExistException;
import com.ltd.pvt.dem.vendoragency.api.exception.UserNotFoundException;
import com.ltd.pvt.dem.vendoragency.api.exception.UsernameAndPasswordNotMatchException;
import com.ltd.pvt.dem.vendoragency.api.model.Agency;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * 
 * Implement the All Method of UserService as below listed
 * 
 * public UserDetail searchUser(String userName) throws UserNotFoundException
 * public String signup(UserSignup dto) throws UserAlreadyExistException public
 * String signin(UserSignin signin) throws UsernameAndPasswordNotMatchException
 * public List<String> fetchAllUsername() throws UserNotFoundException
 * 
 * 
 * 
 */
@Service
@Transactional
public class UserServiceImple implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImple.class);

	@Autowired(required = true)
	private UserRepository repository;
	@Autowired
	private UserAdaptor adaptor;

	private Predicate<Agency> p = user -> user == null;
	@Autowired
	HttpServletRequest request;
	@Autowired
	private LoginAttemptService loginAttemptService;

	public AgencyDetail searchAgencyEmail(String userName) throws UserNotFoundException {
		Agency model = null;
		log.debug("UserService.searchUser()");
		try {

			// find the user
			model = repository.findByAgencyEmail(userName);
			// model is null or not
			if (!p.test(model))
				return adaptor.convertModel(model);
		} catch (Exception e) {
			log.warn("UserService.searchUser()  " + e.getMessage());
			throw new RuntimeException(" Internal Server Problem   " + e.getMessage());
		} // end of try & catch

		// model not found throw UserNotFoundException
		throw new UserNotFoundException("    User Not Found    " + userName);
	}// end of method

	public String signup(AgencySignup dto) throws UserAlreadyExistException {
		Agency isUser = null;
		log.debug("UserService.signup()");

		try {
			// check the isUser found or not
			isUser = repository.findByAgencyEmail(dto.getUsername());
			// not found then save the data
			if (p.test(isUser)) {
				repository.save(adaptor.convertSignUp(dto));
				return " SignUp Scussful";
			} // end of if
		} catch (Exception e) {
			log.warn("UserServiceImple.signup()");
			throw new RuntimeException(" Internal Server Problem   " + e.getMessage());
		}

		// User found so throw the UserAlreadyExistException
		log.warn("UserService.signup()");
		throw new UserAlreadyExistException("    User Already Exist   " + dto.getUsername());
	}// end of method

	public String signin(AgencySignin signin) throws Exception {
		Agency isUser = null, model = null;
		String ip = null;
		boolean match = false;
		log.debug("UserService.signin()");
		try {

			ip = getClientIP();
			if (loginAttemptService.isBlocked(ip)) {
				throw new RuntimeException("You are  blocked ");
			}
			// convert dto to model
			model = adaptor.convertSignin(signin);

			// unreference the obj
			signin = null;
			// ch
			isUser = repository.findByAgencyEmail(model.getAgencyEmail());

			match = isUser.getAgencyPassword().equals(model.getAgencyPassword());
			if (match)
				return "  NEXT  PAGE     ";
		} catch (NullPointerException e) {
			log.warn("UserService.signin()" + e.getMessage());
			throw new UserNotExistException("User Not ExisT  Please SignUP  " + "  " + model.getAgencyEmail());
		} catch (Exception e) {
			log.warn("  UserService.signin()   " + e.getMessage());
			throw new RuntimeException(" Internal Server Problem   " + e.getMessage());
		} // end of try & catch
		log.warn("UserService.signin()");
		throw new UsernameAndPasswordNotMatchException("Username or Password Not Match  " + model.getAgencyEmail());
	}// end of method

	public List<String> fetchAllUsername() throws UserNotFoundException {
		// TODO Auto-generated method stub

		log.debug("UserService.fetchAllUsername()");
		try {

			Function<Agency, String> f = user -> user.getAgencyEmail();
			Predicate<List<String>> p = lst -> lst.size() == 0;
			List<String> lst = repository.findAll().stream().map(f).collect(Collectors.toList());
			// check empty or not
			if (p.test(lst))
				throw new NullPointerException();
			return lst;
		} catch (NullPointerException e) {
			log.warn("   UserService.fetchAllUsername()  " + e.getMessage());
			throw new UserNotFoundException(" Record Not Available  ");
		} catch (Exception e) {
			log.warn("  UserService.fetchAllUsername()   " + e.getMessage());
			throw new RuntimeException(" Internal Server Problem   " + e.getMessage());
		} // end of try & catch
	}// end of method

	private String getClientIP() {
		String xfHeader = request.getHeader("X-Forwarded-For");
		if (xfHeader == null) {
			return request.getRemoteAddr();
		}
		return xfHeader.split(",")[0];
	}

}// end of class
