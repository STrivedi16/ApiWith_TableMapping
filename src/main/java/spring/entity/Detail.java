package spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE customer_entity set is_active=false WHERE id=?")
@Where(clause = "is_active=true")
public class Detail {

	@Id

	private int addressid;

	private String address;

	private int pincode;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address")

	private Customer customer;

	private boolean is_active = true;

	@CreationTimestamp
	private java.sql.Timestamp creationtime;

	@UpdateTimestamp
	private java.sql.Timestamp updationtime;

	public Detail(int addressid, String address, int pincode, Customer customer, boolean is_active,
			java.sql.Timestamp creationtime, java.sql.Timestamp updationtime) {
		super();
		this.addressid = addressid;
		this.address = address;
		this.pincode = pincode;
		this.customer = customer;
		this.is_active = is_active;
		this.creationtime = creationtime;
		this.updationtime = updationtime;
	}

	public java.sql.Timestamp getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(java.sql.Timestamp creationtime) {
		this.creationtime = creationtime;
	}

	public java.sql.Timestamp getUpdationtime() {
		return updationtime;
	}

	public void setUpdationtime(java.sql.Timestamp updationtime) {
		this.updationtime = updationtime;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isActive() {
		return is_active;
	}

	public void setActive(boolean active) {
		this.is_active = active;
	}

	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}

}
