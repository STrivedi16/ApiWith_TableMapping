package spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomerOM {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int customerid;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer1")
	private List<ProductOM> product;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public List<ProductOM> getProduct() {
		return product;
	}

	public void setProduct(List<ProductOM> product) {
		this.product = product;
	}

	public CustomerOM(int customerid, String name, List<ProductOM> product) {
		super();
		this.customerid = customerid;
		this.name = name;
		this.product = product;
	}

	public CustomerOM() {
		super();
		// TODO Auto-generated constructor stub
	}

}
