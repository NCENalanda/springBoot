package com.ltd.pvt.demo.user.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ltd.pvt.demo.user.api.dto.UserError;
import com.ltd.pvt.demo.user.api.exception.UserAlreadyExistException;
import com.ltd.pvt.demo.user.api.exception.UserNotFoundException;
import com.ltd.pvt.demo.user.api.exception.UsernameAndPasswordNotMatchException;

@RestControllerAdvice
public class ExceptionAdvice {
	
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserError> mapException(UserNotFoundException ex){
		log.error("ExceptionAdvice.mapException()   "+ex.getMessage());
		UserError error=new UserError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<UserError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UsernameAndPasswordNotMatchException.class)
	public ResponseEntity<UserError> mapException(UsernameAndPasswordNotMatchException ex){
		log.error("ExceptionAdvice.mapException()   "+ex.getMessage());
		UserError error=new UserError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<UserError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<UserError> mapException(UserAlreadyExistException ex){
		log.error("ExceptionAdvice.mapException()   "+ex.getMessage());
		UserError error=new UserError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<UserError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
