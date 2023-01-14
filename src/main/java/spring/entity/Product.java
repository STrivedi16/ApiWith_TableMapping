package spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SQLDelete(sql = "UPDATE product set active=")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;

	private String item;

	private int price;

	private String company;

	private Boolean active = true;

//	public int cstm() {
//
//		return customer.getId();
//	}

//	@ManyToOne(cascade = CascadeType.ALL)
//	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "item_productid", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CustumerProductEntity> productentity;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Product(int productid, String item, int price, String company, Boolean active,
			List<CustumerProductEntity> productentity) {
		super();
		this.productid = productid;
		this.item = item;
		this.price = price;
		this.company = company;
		this.active = active;
		this.productentity = productentity;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<CustumerProductEntity> getProductentity() {
		return productentity;
	}

	public void setProductentity(List<CustumerProductEntity> productentity) {
		this.productentity = productentity;
	}

	public Product(int productid, String item, Boolean active) { // Customer customer) {
		super();
		this.productid = productid;
		this.item = item;
		this.active = active;
//		this.customer = customer;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
