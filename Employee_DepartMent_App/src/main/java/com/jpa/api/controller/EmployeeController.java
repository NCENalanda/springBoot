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
import com.jpa.api.dto.EmployeeDto;
import com.jpa.api.service.EmployeeService;
import com.jpa.api.utility.MessageTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("demo/emp")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService serviceEmp;

	
	@ApiOperation(value="")
	@GetMapping("/get")
	public EmployeeDto getEmployee(int empId) {
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		
		return serviceEmp.getEmployee(empId);
	}
	
	
	@ApiOperation(value="")
	@GetMapping("/all")
	public List<EmployeeDto> getAllEmployee() {
		
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		
		return serviceEmp.getAllEmployee();
	}
	
	
	
	@ApiOperation(value="")
	@PostMapping(value= {"/set", "/save"})
	public EmployeeDto setEmployee(EmployeeDto dto) {
		
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		
		return serviceEmp.saveEmployee(dto);
	}
	
	
	
	@ApiOperation(value="")
	@GetMapping("/search")
	public ResponseEntity<List<EmployeeDto>> searchEmployee(String search) {
		return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	
	
	@ApiOperation(value="")
	@DeleteMapping(value= {"/delete","/remove"})
	public String deleteEmployee(int empId) {
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		return serviceEmp.removeEmployee(empId);
	}

}
