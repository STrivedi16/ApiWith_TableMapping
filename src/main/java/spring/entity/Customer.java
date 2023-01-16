package spring.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customerEntity")
@SQLDelete(sql = "UPDATE customer_entity set is_active=false WHERE id=?")
@Where(clause = "is_active=true")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private String city;

	private long number;

	@OneToOne(cascade = CascadeType.ALL)

	private Detail address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer_id", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CustumerProductEntity> item;

	@CreationTimestamp
	private Timestamp creationtime;

	@UpdateTimestamp
	private Timestamp updationtime;

	public Customer(int id, String name, String city, long number, Detail address, List<CustumerProductEntity> item,
			Timestamp creationtime, Timestamp updationtime, Boolean is_active) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.number = number;
		this.address = address;
		this.item = item;
		this.creationtime = creationtime;
		this.updationtime = updationtime;
		this.is_active = is_active;
	}

	public Timestamp getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Timestamp creationtime) {
		this.creationtime = creationtime;
	}

	public Timestamp getUpdationtime() {
		return updationtime;
	}

	public void setUpdationtime(Timestamp updationtime) {
		this.updationtime = updationtime;
	}

	public List<CustumerProductEntity> getItem() {
		return item;
	}

	public void setItem(List<CustumerProductEntity> item) {
		this.item = item;
	}

	private Boolean is_active = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public Detail getAddress() {
		return address;
	}

	public void setAddress(Detail address) {
		this.address = address;
	}

//	public Product getItem() {
//		return item;
//	}

//	public void setItem(Product item) {
//		this.item = item;
//	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
