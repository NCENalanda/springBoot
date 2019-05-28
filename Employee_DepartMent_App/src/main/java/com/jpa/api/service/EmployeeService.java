package com.jpa.api.service;

import java.util.List;

import com.jpa.api.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto getEmployee(int empId);
	
	List<EmployeeDto> getAllEmployee();
	
	EmployeeDto saveEmployee(EmployeeDto dto);
	
	String  removeEmployee(int empId);

}
