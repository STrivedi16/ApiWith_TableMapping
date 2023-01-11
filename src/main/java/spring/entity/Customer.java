package spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer_id")
	private List<customer_entity_item> item;

	public Customer(int id, String name, String city, long number, Detail address, List<customer_entity_item> item,
			Boolean is_active) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.number = number;
		this.address = address;
		this.item = item;
		this.is_active = is_active;
	}

	public List<customer_entity_item> getItem() {
		return item;
	}

	public void setItem(List<customer_entity_item> item) {
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

	public Customer(int id, String name, String city, long number, Detail address, Product item, Boolean is_active) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.number = number;
		this.address = address;
		// this.item = item;
		this.is_active = is_active;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
