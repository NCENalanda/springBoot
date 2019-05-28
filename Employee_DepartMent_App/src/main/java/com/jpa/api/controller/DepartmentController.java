package com.jpa.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.api.dto.DepartmentDto;
import com.jpa.api.service.DepartmentService;
import com.jpa.api.utility.MessageTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("demo/depart")
public class DepartmentController {
	
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentService serviceDepart;

	
	@ApiOperation(value="")
	@GetMapping("/get")
	public DepartmentDto getDepartment(int departId){
		
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		return serviceDepart.searchById(departId);
	}
	/*
	@ApiOperation(value="")
	@GetMapping("/all")
	public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		return new ResponseEntity<List<DepartmentDto>>(serviceDepart.getAllDepartment(),HttpStatus.FOUND);
	}*/
	
	@ApiOperation(value="")
	@GetMapping("/all")
	public List<DepartmentDto> getAllDepartment(){
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		return serviceDepart.getAllDepartment();
	}
	
	@ApiOperation(value="")
	@GetMapping("/search")
	public ResponseEntity<List<DepartmentDto>> searchDepartment(String str){
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		return new ResponseEntity<List<DepartmentDto>>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	
	@ApiOperation(value="")
	@PostMapping(value= {"/save","/update"})
	public DepartmentDto setDepartment(DepartmentDto dto){
		
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		return serviceDepart.save_OR_update(dto);
	}
	
	@ApiOperation(value="")
	@DeleteMapping(value= {"/remove","/delete"})
	public String deleteDepartment(int departId){
		
		
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		return serviceDepart.delete(departId);
	}


}
