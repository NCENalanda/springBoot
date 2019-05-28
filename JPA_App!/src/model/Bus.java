package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bus database table.
 * 
 */
@Entity
@NamedQuery(name="Bus.findAll", query="SELECT b FROM Bus b")
public class Bus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="bus_id")
	private int busId;

	@Column(name="bus_company_name")
	private String busCompanyName;

	@Column(name="bus_no")
	private String busNo;

	@Column(name="bus_owner_name")
	private String busOwnerName;

	@Column(name="bus_registration_no")
	private String busRegistrationNo;

	@Column(name="bus_type")
	private String busType;

	@Column(name="fill_seat")
	private int fillSeat;

	@Column(name="is_ac")
	private String isAc;

	@Column(name="remain_seat")
	private int remainSeat;

	@Column(name="total_seat")
	private int totalSeat;

	//bi-directional many-to-one association to BusService
	@ManyToOne
	@JoinColumn(name="bus_service_name")
	private BusService busService;

	public Bus() {
	}

	public int getBusId() {
		return this.busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusCompanyName() {
		return this.busCompanyName;
	}

	public void setBusCompanyName(String busCompanyName) {
		this.busCompanyName = busCompanyName;
	}

	public String getBusNo() {
		return this.busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getBusOwnerName() {
		return this.busOwnerName;
	}

	public void setBusOwnerName(String busOwnerName) {
		this.busOwnerName = busOwnerName;
	}

	public String getBusRegistrationNo() {
		return this.busRegistrationNo;
	}

	public void setBusRegistrationNo(String busRegistrationNo) {
		this.busRegistrationNo = busRegistrationNo;
	}

	public String getBusType() {
		return this.busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public int getFillSeat() {
		return this.fillSeat;
	}

	public void setFillSeat(int fillSeat) {
		this.fillSeat = fillSeat;
	}

	public String getIsAc() {
		return this.isAc;
	}

	public void setIsAc(String isAc) {
		this.isAc = isAc;
	}

	public int getRemainSeat() {
		return this.remainSeat;
	}

	public void setRemainSeat(int remainSeat) {
		this.remainSeat = remainSeat;
	}

	public int getTotalSeat() {
		return this.totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public BusService getBusService() {
		return this.busService;
	}

	public void setBusService(BusService busService) {
		this.busService = busService;
	}

}