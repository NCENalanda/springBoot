package com.ltd.pvt.dem.vendoragency.api.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigInteger;
import java.util.List;

/**
 * The persistent class for the agency database table.
 * 
 */
@Entity
@NamedQuery(name = "Agency.findAll", query = "SELECT a FROM Agency a")
public class Agency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "agency_id")
	private int agencyId;

	@Column(name = "agency_address")
	private String agencyAddress;

	@Column(name = "agency_bank_account")
	private BigInteger agencyBankAccount;

	@Column(name = "agency_email")
	private String agencyEmail;

	@Column(name = "agency_gstn")
	private String agencyGstn;

	@Column(name = "agency_is_active")
	private int agencyIsActive;

	@Column(name = "agency_name")
	private String agencyName;

	@Column(name = "agency_owner_name")
	private String agencyOwnerName;

	@Column(name = "agency_pancard")
	private String agencyPancard;

	@Column(name = "agency_password")
	private String agencyPassword;

	@Column(name = "agency_phone")
	private BigInteger agencyPhone;

	// bi-directional many-to-one association to BusService
	@OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<BusService> busServices;

	public Agency() {
	}

	public int getAgencyId() {
		return this.agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyAddress() {
		return this.agencyAddress;
	}

	public void setAgencyAddress(String agencyAddress) {
		this.agencyAddress = agencyAddress;
	}

	public BigInteger getAgencyBankAccount() {
		return this.agencyBankAccount;
	}

	public void setAgencyBankAccount(BigInteger agencyBankAccount) {
		this.agencyBankAccount = agencyBankAccount;
	}

	public String getAgencyEmail() {
		return this.agencyEmail;
	}

	public void setAgencyEmail(String agencyEmail) {
		this.agencyEmail = agencyEmail;
	}

	public String getAgencyGstn() {
		return this.agencyGstn;
	}

	public void setAgencyGstn(String agencyGstn) {
		this.agencyGstn = agencyGstn;
	}

	public int getAgencyIsActive() {
		return this.agencyIsActive;
	}

	public void setAgencyIsActive(int agencyIsActive) {
		this.agencyIsActive = agencyIsActive;
	}

	public String getAgencyName() {
		return this.agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyOwnerName() {
		return this.agencyOwnerName;
	}

	public void setAgencyOwnerName(String agencyOwnerName) {
		this.agencyOwnerName = agencyOwnerName;
	}

	public String getAgencyPancard() {
		return this.agencyPancard;
	}

	public void setAgencyPancard(String agencyPancard) {
		this.agencyPancard = agencyPancard;
	}

	public String getAgencyPassword() {
		return this.agencyPassword;
	}

	public void setAgencyPassword(String agencyPassword) {
		this.agencyPassword = agencyPassword;
	}

	public BigInteger getAgencyPhone() {
		return this.agencyPhone;
	}

	public void setAgencyPhone(BigInteger agencyPhone) {
		this.agencyPhone = agencyPhone;
	}

	public List<BusService> getBusServices() {
		return this.busServices;
	}

	public void setBusServices(List<BusService> busServices) {
		this.busServices = busServices;
	}

	public BusService addBusService(BusService busService) {
		getBusServices().add(busService);
		busService.setAgency(this);

		return busService;
	}

	public BusService removeBusService(BusService busService) {
		getBusServices().remove(busService);
		busService.setAgency(null);

		return busService;
	}

}