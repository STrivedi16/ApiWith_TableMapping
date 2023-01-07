package spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;

	@ManyToOne(cascade = CascadeType.ALL)
	private Customer item;

	public Product(Customer customer) {
		super();
		this.item = customer;
	}

	public Customer getCustomer() {
		return item;
	}

	public void setCustomer(Customer customer) {
		this.item = customer;
	}

	private boolean active = true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public Product(int productid, Customer customer, boolean active) {
		super();
		this.productid = productid;
		this.item = customer;
		this.active = active;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
