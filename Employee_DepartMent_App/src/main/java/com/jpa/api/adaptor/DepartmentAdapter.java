package com.jpa.api.adaptor;

import com.jpa.api.dto.DepartmentDto;
import com.jpa.api.model.DepartmentModel;

public interface DepartmentAdapter {
	
	DepartmentDto adapter(DepartmentModel model);
	DepartmentModel adapter(DepartmentDto dto);

}
