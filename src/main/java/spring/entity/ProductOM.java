package spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductOM {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;

	private String product;

	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerOM customer1;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public CustomerOM getCustomer1() {
		return customer1;
	}

	public void setCustomer1(CustomerOM customer1) {
		this.customer1 = customer1;
	}

	public ProductOM(int productid, String product, CustomerOM customer1) {
		super();
		this.productid = productid;
		this.product = product;
		this.customer1 = customer1;
	}

	public ProductOM() {
		super();
		// TODO Auto-generated constructor stub
	}

}
