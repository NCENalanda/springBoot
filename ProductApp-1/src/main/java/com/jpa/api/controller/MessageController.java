package com.jpa.api.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product/user")
public class MessageController {
	
	private static final Logger log = LoggerFactory.getLogger(MessageController.class);
	private static String temmessage= "WelCome To India  ";

	
	@GetMapping("/getMessage/{name}")
	public String getMessage(@PathVariable("name") String name) {
		log.info("     getMessage()          "+this.getClass().getName());
		return temmessage+name;
	}
	
	
	@PostMapping("/setMessage")
	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	public String setMessage(String message) {
		log.info("     SetMessage()          "+this.getClass().getName());
		temmessage=message;
		return temmessage+"   Successfully";
	}

}
