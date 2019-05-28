package com.jpa.api.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 15431315L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	private String firstName;
	private String lastName;
	private String password;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "r_id", referencedColumnName = "r_id"))
	private Set<Role1> roles;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_phone", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "p_id", referencedColumnName = "p_id"))
	private Set<Phone1> phones;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "comp_user", inverseJoinColumns = @JoinColumn(name = "com_id", referencedColumnName = "com_id"), joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
	private Set<Company1> companies;

	public User1() {
		// TODO Auto-generated constructor stub
	}

	public User1(String firstName, String lastName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return "User1 [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role1> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role1> roles) {
		this.roles = roles;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Phone1> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone1> phones) {
		this.phones = phones;
	}

	public Set<Company1> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company1> companies) {
		this.companies = companies;
	}

}
