package com.jpa.api.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.api.dao.RoleRepository;
import com.jpa.api.dao.UserRepository;
import com.jpa.api.model.Role2;
import com.jpa.api.model.User2;

@Service
//@Transactional(propagation=Propagation.MANDATORY,  rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public String save(User2 user) {
		// TODO Auto-generated method stub
		User2 temUser=null;
		temUser=userRepo.findByUserName(user.getUserName());
		
		
		if(temUser!=null)
			throw new RuntimeException("AlReadyUserExist with"+user.getUserName());
		
		
		for(Role2 role2 : user.getRoles()) {
			  log.info("                   Before   Start           ");
			  log.info(role2.getRoleId()+"      "+role2.getRole());
			  log.info("                   Before   End             ");
		}//end of foreach

		/*   
		 * set the roles                                             
		 * 
		 * */
		
		
		  Set<Role2> setRole= new HashSet<>();
		  
		  user.getRoles().forEach(role->{
			  Role2 role1=null;
			  role1=roleRepo.findByRole(role.getRole());
			  
			  if(role1!=null)
				  role = role1;
			  else {
				role.setRoleId(101);
			 }
			  
			  setRole.add(role);
		  });//end of forEach()
		  
		  for(Role2 role2 : setRole) {
			  
			  log.info(role2.getRoleId()+"      "+role2.getRole());
		}//end of foreach
		  
		  user.setRoles(setRole);
		  
		  
		  for(Role2 role2 : user.getRoles()) {
			  log.info("                   After   Start           ");
			  log.info(role2.getRoleId()+"      "+role2.getRole());
			  log.info("                   After   End             ");
		}//end of foreach
		  
		  userRepo.save(user);
		  
		  
		  return "USER ADDED";
		
	}
	
}
