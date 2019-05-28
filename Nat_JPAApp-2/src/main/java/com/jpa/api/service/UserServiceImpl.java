package com.jpa.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.api.dao.RoleRepository;
import com.jpa.api.dao.UserRepository;
import com.jpa.api.model.Role3;
import com.jpa.api.model.User3;

@Service
//@Transactional(propagation=Propagation.MANDATORY,  rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public String save(User3 user) {

		User3 temUser=null;
		
		this.show(user);
		//check  "AlReadyUserExist with"+user.getUserName()
		temUser=userRepo.findByUserName(user.getUserName());
		
		if(temUser!=null)
			throw new RuntimeException("AlReadyUserExist with"+user.getUserName());
		  
		//userRepo.save(user);
		return "USER ADDED";
	}
	
	private void show(User3 user) {
		log.info(user.getUserId()+"          "+user.toString()+"           ");
		
		if(user.getUserId()==75)
			this.addRole(user);
		
		for (Role3 role : user.getRoles()) {
			
			log.info(role.getRoleId()+"              "+role.getRole());
			if(role.getRoleId()==82)
				this.changeRoleName(role);
		}
	}
	
	private void changeRoleName(Role3 role ) {
		role.setRole("ADMIN");
		roleRepo.save(role);
	}
	
	private void addRole(User3 user) {
		user.getRoles().add(new Role3("OBSERVER"));
		userRepo.save(user);
	}

	@Override
	public void listUser() {
		userRepo.findAll().forEach(user->{
			this.show(user);
		});
		
	}
	
}
