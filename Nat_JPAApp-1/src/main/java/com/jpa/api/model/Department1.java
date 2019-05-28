package com.jpa.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department1 {
	@Id
	@Column(name="dept_no",unique=true,nullable=true)
	private int deptNo;
	private String deptName;
	private String deptHead;
	private String deptLocation;
	
	
	public Department1() {
		this.deptLocation="Hyderabad";
	}
	
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptHead() {
		return deptHead;
	}
	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
	public String getDeptLocation() {
		return deptLocation;
	}
	@Override
	public String toString() {
		return "Department1 [deptNo=" + deptNo + ", deptName=" + deptName + ", deptHead=" + deptHead + ", deptLocation="
				+ deptLocation + "]";
	}
	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

}
