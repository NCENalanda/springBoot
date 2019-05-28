package com.jpa.api.adaptor;

import com.jpa.api.dto.EmployeeDto;
import com.jpa.api.model.EmployeeModel;

public interface EmployeeAdapter {

	
	EmployeeDto adapter(EmployeeModel model);
	EmployeeModel adapter( EmployeeDto dto);
}
