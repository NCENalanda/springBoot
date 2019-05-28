package com.ltd.pvt.dem.vendoragency.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ltd.pvt.dem.vendoragency.api.dto.AgencyError;
import com.ltd.pvt.dem.vendoragency.api.exception.UserAlreadyExistException;
import com.ltd.pvt.dem.vendoragency.api.exception.UserNotExistException;
import com.ltd.pvt.dem.vendoragency.api.exception.UserNotFoundException;
import com.ltd.pvt.dem.vendoragency.api.exception.UsernameAndPasswordNotMatchException;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver;
/**
 *                 Handle the All of these Exception as below listed
 * UserNotFoundException.class
 * UsernameAndPasswordNotMatchException
 * UserAlreadyExistException
 * MethodArgumentNotValidException
 * Exception
 * 
 * */


@RestControllerAdvice
public class ExceptionAdvice {
	
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<AgencyError> mapException(UserNotFoundException ex){
		log.error("ExceptionAdvice.mapException()   "+ex.getMessage());
		AgencyError error=new AgencyError(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		return new ResponseEntity<AgencyError>(error,HttpStatus.NOT_FOUND);
	}//end of method
	
	@ExceptionHandler(UsernameAndPasswordNotMatchException.class)
	public ResponseEntity<AgencyError> mapException(UsernameAndPasswordNotMatchException ex){
		log.error("ExceptionAdvice.mapException()   "+ex.getMessage());
		AgencyError error=new AgencyError(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage());
		return new ResponseEntity<AgencyError>(error,HttpStatus.NOT_ACCEPTABLE);
	}//end of method
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<AgencyError> mapException(UserAlreadyExistException ex){
		log.error("ExceptionAdvice.mapException()   "+ex.getMessage());
		AgencyError error=new AgencyError(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage());
		return new ResponseEntity<AgencyError>(error,HttpStatus.NOT_ACCEPTABLE);
	}//end of method
	
	@ExceptionHandler(UserNotExistException.class)
	public ResponseEntity<AgencyError> mapException(UserNotExistException ex){
		log.error("ExceptionAdvice.mapException()   "+ex.getMessage());
		AgencyError error=new AgencyError(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage());
		return new ResponseEntity<AgencyError>(error,HttpStatus.NOT_ACCEPTABLE);
	}//end of method
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<AgencyError> mapException(MethodArgumentNotValidException ex){
		log.error("ExceptionAdvice.mapException()   "+ex.getMessage());
		
		//get defaultMessage and reason of corresponding code from BindingResult in list  of String
		
		List<String> listError=new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach(arg->{
			String str="{ code = "+arg.getCode()+" : "+arg.getDefaultMessage()+" }";
			listError.add(str);
		});//end of forEach()
		
		//list  of Error message set im UserError
		AgencyError error=new AgencyError(HttpStatus.PRECONDITION_FAILED.value(),"  Validation Failed due to "+listError.toString());
		return new ResponseEntity<AgencyError>(error,HttpStatus.PRECONDITION_FAILED);
	}//end of method
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AgencyError> mapException(Exception ex){
		log.error("ExceptionAdvice.mapException()   "+ex.getMessage());
		AgencyError error=new AgencyError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<AgencyError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}//end of method

}
