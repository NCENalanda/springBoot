package com.jpa.api.service;

import java.util.List;

import com.jpa.api.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto searchById(int departId);
	
	List<DepartmentDto> search(String str);
	
	List<DepartmentDto> getAllDepartment();
	
	DepartmentDto save_OR_update(DepartmentDto dto);
	
	String delete(int departId);
}
