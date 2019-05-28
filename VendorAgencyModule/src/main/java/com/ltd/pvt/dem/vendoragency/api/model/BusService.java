package com.ltd.pvt.dem.vendoragency.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the bus_service database table.
 * 
 */
@Entity
@Table(name="bus_service")
@NamedQuery(name="BusService.findAll", query="SELECT b FROM BusService b")
public class BusService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="bus_service_id")
	private int busServiceId;

	@Column(name="bus_service_name")
	private String busServiceName;

	private String destination;

	private String origin;

	@Column(name="stop_point_place")
	private String stopPointPlace;

	//bi-directional many-to-one association to Bus
	@OneToMany(mappedBy="busService",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Bus> buses;

	//bi-directional many-to-one association to Agency
	@ManyToOne
	@JoinColumn(name="agency_email")
	private Agency agency;

	public BusService() {
	}

	public int getBusServiceId() {
		return this.busServiceId;
	}

	public void setBusServiceId(int busServiceId) {
		this.busServiceId = busServiceId;
	}

	public String getBusServiceName() {
		return this.busServiceName;
	}

	public void setBusServiceName(String busServiceName) {
		this.busServiceName = busServiceName;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getStopPointPlace() {
		return this.stopPointPlace;
	}

	public void setStopPointPlace(String stopPointPlace) {
		this.stopPointPlace = stopPointPlace;
	}

	public List<Bus> getBuses() {
		return this.buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public Bus addBus(Bus bus) {
		getBuses().add(bus);
		bus.setBusService(this);

		return bus;
	}

	public Bus removeBus(Bus bus) {
		getBuses().remove(bus);
		bus.setBusService(null);

		return bus;
	}

	public Agency getAgency() {
		return this.agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

}