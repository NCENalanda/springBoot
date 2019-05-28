package com.rest.user.api.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.rest.user.api.dto.UserError;
import com.rest.user.api.exception.UserAlreadyExistException;
import com.rest.user.api.exception.UserNotFoundException;
import com.rest.user.api.exception.UsernameAndPasswordNotMatchException;

@RestControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserError> mapException(UserNotFoundException ex){
		
		UserError error=new UserError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<UserError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UsernameAndPasswordNotMatchException.class)
	public ResponseEntity<UserError> mapException(UsernameAndPasswordNotMatchException ex){
		
		UserError error=new UserError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<UserError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<UserError> mapException(UserAlreadyExistException ex){
		
		UserError error=new UserError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<UserError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
