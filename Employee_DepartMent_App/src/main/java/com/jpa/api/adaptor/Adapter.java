package com.jpa.api.adaptor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.jpa.api.dto.DepartmentDto;
import com.jpa.api.dto.EmployeeDto;
import com.jpa.api.model.DepartmentModel;
import com.jpa.api.model.EmployeeModel;

@Component
public class Adapter implements EmployeeAdapter, DepartmentAdapter  {

	@Override
	public DepartmentDto adapter(DepartmentModel model) {
		// TODO Auto-generated method stub
		DepartmentDto dto=null;
		             dto= new DepartmentDto();
		
		BeanUtils.copyProperties(model, dto);
		return dto;
	}

	@Override
	public DepartmentModel adapter(DepartmentDto dto) {
		// TODO Auto-generated method stub
		   DepartmentModel model=null;
		                   model=new DepartmentModel();
           BeanUtils.copyProperties(dto, model);
		
		  return model;
	}

	@Override
	public EmployeeDto adapter(EmployeeModel model) {
		// TODO Auto-generated method stub
		EmployeeDto dto=null;
		dto= new EmployeeDto();
		BeanUtils.copyProperties(model, dto,"department");
		
		dto.setDepartment(this.adapter(model.getDepartment()));
		
		return dto;
	}

	@Override
	public EmployeeModel adapter(EmployeeDto dto) {
		// TODO Auto-generated method stub
		EmployeeModel model=null;
		              model=new EmployeeModel();
		BeanUtils.copyProperties(dto, model,"department");
		
		model.setDepartment(this.adapter(dto.getDepartment()));
		return model;
	}

	

}
