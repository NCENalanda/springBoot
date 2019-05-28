package com.jpa.api.service;

public interface ManyToOneService {
	
	
	void saveEmpwithDept();
	void listEmpwithDept();
	
	void addNewEmpToExistingDept();
	void addExistingEmpToNewDept();
	void changeExistingEmpToExistingDept();
	void deleteAllEmpsWithDept();
	void deleteEmpFromDept();
	


}
