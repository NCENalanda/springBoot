package com.jpa.api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.api.adaptor.DepartmentAdapter;
import com.jpa.api.dao.DepartmentRepository;
import com.jpa.api.dto.DepartmentDto;
import com.jpa.api.model.DepartmentModel;
import com.jpa.api.utility.MessageTemplate;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	
	private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired(required=true)
	private DepartmentRepository departRepo;
	@Autowired
	private DepartmentAdapter adapter;
	
	@Override
	public DepartmentDto searchById(int departId) {
		// TODO Auto-generated method stub
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		return adapter.adapter(departRepo.findById(departId).get());
	}

	@Override
	public List<DepartmentDto> search(String str) {
		// TODO Auto-generated method stub
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		
		return null;
	}

	@Override
	public List<DepartmentDto> getAllDepartment() {
		// TODO Auto-generated method stub
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		List<DepartmentDto> dtoList=new ArrayList<>();
		departRepo.findAll().forEach(model->{
			dtoList.add(adapter.adapter(model));
		});
		return dtoList;
	}

	@Override
	public DepartmentDto save_OR_update(DepartmentDto dto) {
		// TODO Auto-generated method stub
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		return adapter.adapter(departRepo.save(this.haveORNot(adapter.adapter(dto))));
	}

	@Override
	public String delete(int departId) {
		// TODO Auto-generated method stub
		log.info(MessageTemplate.LOGGER_INFO+this.getClass().getName());
		departRepo.deleteById(departId);
		return MessageTemplate.SUCCESSFULLY;
	}
	
	private DepartmentModel haveORNot(DepartmentModel model) {
		
		if(departRepo.existsByDeptName(model.getDeptName()))
			throw	new RuntimeException(MessageTemplate.DEPARTMENT_AlREADY_EXIST+model.getDeptName()) ;
		return model;
	}

	
	
}
