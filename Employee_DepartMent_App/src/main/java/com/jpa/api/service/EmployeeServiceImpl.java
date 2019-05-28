package com.jpa.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.api.adaptor.EmployeeAdapter;
import com.jpa.api.dao.DepartmentRepository;
import com.jpa.api.dao.EmployeeRepository;
import com.jpa.api.dto.EmployeeDto;
import com.jpa.api.model.DepartmentModel;
import com.jpa.api.model.EmployeeModel;
import com.jpa.api.utility.MessageTemplate;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository repoEmpl;
	
	@Autowired
	private DepartmentRepository repoDept;
	
	@Autowired
	private EmployeeAdapter adapter;

	@Override
	public EmployeeDto getEmployee(int empId) {
		// TODO Auto-generated method stub
		Optional<EmployeeModel> opModel=null;
		EmployeeDto dto;
		opModel=repoEmpl.findById(empId);
		
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		
		if(!(opModel.isPresent()))
			throw new  RuntimeException(MessageTemplate.USER_NOT_FOUND+empId);
		dto= adapter.adapter(opModel.get());
		
		return dto;
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		List<EmployeeDto> dtoList= new ArrayList<>();
		
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		
		repoEmpl.findAll().forEach(model->{
			EmployeeDto dto=adapter.adapter(model);
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {
		// TODO Auto-generated method stub
		
		
		dto=adapter.adapter(repoEmpl.save(this.setDepartmentInEmployee(this.haveOrNot(adapter.adapter(dto)))));
	
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		
		return dto;
	}

	@Override
	public String removeEmployee(int empId) {
		// TODO Auto-generated method stub
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		
		repoEmpl.deleteById(empId);
		return MessageTemplate.SUCCESSFULLY;
	}
	
	private EmployeeModel setDepartmentInEmployee(EmployeeModel emplModel) {
		Optional<DepartmentModel> opModelDepart=null;
		     opModelDepart=repoDept.findById(emplModel.getDepartment().getDeptNo());
		     
		     
		     if(opModelDepart.isPresent()) {
		    	 emplModel.setDepartment(opModelDepart.get());
		     }
		     else {
		    	 opModelDepart=repoDept.findByDeptName(emplModel.getJob());
		    	 if(opModelDepart.isPresent()) {
			    	 emplModel.setDepartment(opModelDepart.get());
			     }
		    	 else {
					throw new RuntimeException(MessageTemplate.JOB_NAME_NOT_MATCH+emplModel.getJob()+"  "
		    	                                                     +emplModel.getDepartment().getDeptNo());
				}
		     }
			log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		
		return emplModel;
	}//end of method
	
	private EmployeeModel haveOrNot(EmployeeModel model) {
		
		if(repoEmpl.existsByEmail(model.getEmail()))
			throw	new RuntimeException(MessageTemplate.USER_AlREADY_EXIST+model.getEmail()) ;
		return model;
	}

}
