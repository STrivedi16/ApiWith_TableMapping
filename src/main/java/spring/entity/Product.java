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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SQLDelete(sql = "UPDATE customer_entity set is_active=false WHERE id=?")
@Where(clause = "is_active=true")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;

	private String item;

	private int price;

	private String company;

	private Boolean is_active = true;

	@CreationTimestamp
	private Timestamp creationTimestamp;

	@UpdateTimestamp
	private Timestamp updationTimestamp;

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

	public Product(int productid, String item, int price, String company, Boolean is_active,
			Timestamp creationTimestamp, Timestamp updationTimestamp, List<CustumerProductEntity> productentity) {
		super();
		this.productid = productid;
		this.item = item;
		this.price = price;
		this.company = company;
		this.is_active = is_active;
		this.creationTimestamp = creationTimestamp;
		this.updationTimestamp = updationTimestamp;
		this.productentity = productentity;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public Timestamp getUpdationTimestamp() {
		return updationTimestamp;
	}

	public void setUpdationTimestamp(Timestamp updationTimestamp) {
		this.updationTimestamp = updationTimestamp;
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
		this.is_active = active;
//		this.customer = customer;
	}

	public Boolean getActive() {
		return is_active;
	}

	public void setActive(Boolean active) {
		this.is_active = active;
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

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", item=" + item + ", price=" + price + ", company=" + company
				+ ", is_active=" + is_active + ", creationTimestamp=" + creationTimestamp + ", updationTimestamp="
				+ updationTimestamp + ", productentity=" + productentity + "]";
	}

}
