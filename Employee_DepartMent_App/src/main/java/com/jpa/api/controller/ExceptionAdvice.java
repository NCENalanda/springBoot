package com.jpa.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jpa.api.dto.CustomError;
import com.jpa.api.utility.MessageTemplate;

@RestControllerAdvice
public class ExceptionAdvice {
	
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomError> mapException(Exception exception){
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		log.warn(exception.getMessage(),exception);
		this.infoLog(exception);
		return new ResponseEntity<CustomError>(new CustomError(409,exception.getMessage()),HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<CustomError> mapException(Throwable th){
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		log.warn(th.getMessage(), th);
		return new ResponseEntity<CustomError>(new CustomError(409,th.getMessage()),HttpStatus.CONFLICT);
	}
	
	private void infoLog(Exception ex) {
		Class c=ex.getClass();
		String str= ex.getMessage();
		Throwable th=ex.getCause();
		StackTraceElement[] st=ex.getStackTrace();
		
		String message =c.getName()+st.toString();
		log.warn(MessageTemplate.LOGGER_INFO+message+MessageTemplate.LOGGER_INFO);
		
	}
}