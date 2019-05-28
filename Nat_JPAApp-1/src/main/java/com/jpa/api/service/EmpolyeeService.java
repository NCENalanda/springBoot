package com.jpa.api.service;

import java.util.ListIterator;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.api.dao.DepartmentRepository;
import com.jpa.api.dao.EmpolyeeRepository;
import com.jpa.api.model.Department1;
import com.jpa.api.model.Employee1;
@Service
public class EmpolyeeService implements ManyToOneService {
	
	
	private static final Logger log = LoggerFactory.getLogger(EmpolyeeService.class);

	@Autowired
	private EmpolyeeRepository repo;
	@Autowired
	private DepartmentRepository drepo;

	@Override
	public void saveEmpwithDept() {
		Employee1 employee1 = new Employee1();
		employee1.setEmpName("Ayush Kumar");employee1.setEmpId(101);
		employee1.setSalary(20000.56);
		
		Employee1 employee2 = new Employee1();
		employee2.setEmpName("Piyush Kumar");employee2.setEmpId(102);
		employee2.setSalary(15000.586);
		
		Department1 department1 = new Department1();
		department1.setDeptName("IT");department1.setDeptNo(10001);
		department1.setDeptHead(employee1.getEmpName());
		
		employee1.setDept(department1);employee2.setDept(department1);
		 repo.save(employee1);
		//log.info('\t'+"                "+emp.toString()+"                "+'\n');
		 repo.save(employee2);
		//log.info('\t'+"                "+emp.toString()+"                "+'\n');
	}

	@Override
	public void listEmpwithDept() {
		
		repo.findAll().forEach(emp->{
			log.info(emp.toString());
			log.info(emp.getDept().getDeptNo()+"");
		});
	}

	@Override
	public void addNewEmpToExistingDept() {
		//Department1 dept=null;
		
		Employee1 employee1 = new Employee1();
		employee1.setEmpName("Madhukar Kumar");employee1.setEmpId(104);
		employee1.setSalary(19600.26);
		
		Employee1 employee2 = new Employee1();
		employee2.setEmpName("Niyush Kumar");employee2.setEmpId(107);
		employee2.setSalary(15860.586);
		
		drepo.findAll().forEach(dept->{
			if(dept.getDeptNo()==10001)
				employee1.setDept(dept);employee2.setDept(dept);
		});;
		
		repo.save(employee1);
		repo.save(employee2);
		
	}

	@Override
	public void addExistingEmpToNewDept() {
		// TODO Auto-generated method stub
		
		Department1 dept=new Department1();
		dept.setDeptName("PHARMACY");dept.setDeptNo(12005);
		dept.setDeptLocation("Dehradun");
		
		repo.findAll().forEach(emp->{
			if(emp.getEmpId()==102) {
				emp.setDept(dept);
				repo.save(emp);}
			
		});
	}

	@Override
	public void changeExistingEmpToExistingDept() {
		Department1 dept=null;Employee1 emp=null;
		Optional<Employee1>    opEmp     =     repo.findById(107);
	    Optional<Department1> opDept   =      drepo.findById(12005);
	    
	    
	    if(opDept.isPresent()) {
	          dept=opDept.get();
	          if(opEmp.isPresent()) {
	        	  emp=opEmp.get();
	        	  emp.setDept(dept);
	        	  repo.save(emp);
	          }//end of if
	        	  
	   }//end of if
	    
	}

	@Override
	public void deleteAllEmpsWithDept() {
		Employee1 emp=null;
		
	    ListIterator<Employee1> listITR  =	repo.findAll().listIterator();
	    while(listITR.hasNext()) {
	    	emp=listITR.next();
	    	if(emp.getDept().getDeptNo()==12005) {
	    		repo.delete(emp);
	    	}
	    }
		
	}

	@Override
	public void deleteEmpFromDept() {
		// TODO Auto-generated method stub
		
	}

}
