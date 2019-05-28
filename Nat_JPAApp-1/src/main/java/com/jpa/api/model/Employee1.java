package com.jpa.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity

public class Employee1 {
	@Id
	
	@Column(name="emp_id",unique=true,nullable=true)
	private int empId;
	private String empName;
	private double salary;
	@ManyToOne(
			    cascade=CascadeType.ALL,
			     fetch=FetchType.LAZY)
	@JoinColumn(name="dept_no",referencedColumnName="dept_no",nullable=true)//name="dept_no"
	private Department1 dept;
	
	public Employee1() {
		// TODO Auto-generated constructor stub
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department1 getDept() {
		return dept;
	}
	public void setDept(Department1 dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee1 [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}

}
