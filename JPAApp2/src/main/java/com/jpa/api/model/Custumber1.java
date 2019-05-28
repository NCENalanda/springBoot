package com.jpa.api.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the custumber1 database table.
 * 
 */
@Entity
@NamedQuery(name="Custumber1.findAll", query="SELECT c FROM Custumber1 c")
public class Custumber1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="custumber_id")
	private int custumberId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	//bi-directional many-to-one association to Email1
	@OneToMany(mappedBy="custumber1", fetch=FetchType.EAGER)
	private List<Email1> email1s= new ArrayList<>();

	//bi-directional many-to-one association to Phone1
	@OneToMany(mappedBy="custumber1", fetch=FetchType.LAZY)
	private List<Phone1> phone1s=new ArrayList<>();

	public Custumber1() {
	}

	public Custumber1(String firstName, String lastName, String middleName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}
	
	public int getCustumberId() {
		return this.custumberId;
	}

	public void setCustumberId(int custumberId) {
		this.custumberId = custumberId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public List<Email1> getEmail1s() {
		return this.email1s;
	}

	public void setEmail1s(List<Email1> email1s) {
		this.email1s = email1s;
	}

	public Email1 addEmail1(Email1 email1) {
		getEmail1s().add(email1);
		email1.setCustumber1(this);

		return email1;
	}

	public Email1 removeEmail1(Email1 email1) {
		getEmail1s().remove(email1);
		email1.setCustumber1(null);

		return email1;
	}

	public List<Phone1> getPhone1s() {
		return this.phone1s;
	}

	public void setPhone1s(List<Phone1> phone1s) {
		this.phone1s = phone1s;
	}

	public Phone1 addPhone1(Phone1 phone1) {
		getPhone1s().add(phone1);
		phone1.setCustumber1(this);

		return phone1;
	}

	public Phone1 removePhone1(Phone1 phone1) {
		getPhone1s().remove(phone1);
		phone1.setCustumber1(null);
		return phone1;
	}

	@Override
	public String toString() {
		return "Custumber1 [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + "]";
	}
}