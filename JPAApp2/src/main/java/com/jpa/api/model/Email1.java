package com.jpa.api.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the email1 database table.
 * 
 */
@Entity
@NamedQuery(name="Email1.findAll", query="SELECT e FROM Email1 e")
public class Email1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="e_id")
	private int eId;

	private String email;

	@Column(name="mail_type")
	private String mailType;

	//bi-directional many-to-one association to Custumber1
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Custumber1 custumber1;

	public Email1() {
	}

	public Email1(String email, String mailType) {
		super();
		this.email = email;
		this.mailType = mailType;
	}

	public int getEId() {
		return this.eId;
	}

	public void setEId(int eId) {
		this.eId = eId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMailType() {
		return this.mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	public Custumber1 getCustumber1() {
		return this.custumber1;
	}

	public void setCustumber1(Custumber1 custumber1) {
		this.custumber1 = custumber1;
	}

	@Override
	public String toString() {
		return "Email1 [email=" + email + ", mailType=" + mailType + "]";
	}

}