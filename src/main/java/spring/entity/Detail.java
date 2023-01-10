package spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE detail set active=false where did=?")
@Where(clause = "active=true")
public class Detail {

	@Id
	private int did;

	private String address;

	private int pincode;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
	private Customer customer;

	private boolean active = true;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Detail(String address, int pincode) {
		super();
		this.address = address;
		this.pincode = pincode;
	}

	public Detail() {
		super();
		// TODO Auto-generated constructor stub

	}

	public Detail(int did, String address, int pincode, Customer customer, boolean active) {
		super();
		this.did = did;
		this.address = address;
		this.pincode = pincode;
		this.customer = customer;
		this.active = active;
	}

}
