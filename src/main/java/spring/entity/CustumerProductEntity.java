package spring.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "custumerProductMapping")
public class CustumerProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Customer customer_id;
	// Eagaer loading data loading oocurs on the spot
	@ManyToOne(fetch = FetchType.LAZY) // Lazy Loading data load when we call explicitly call getter method.
	@JsonIgnore

	// jsonignore is used to ignore the logical propertity
	private Product item_productid;

	@CreationTimestamp
	private Timestamp creatiotime;

	public Customer getCustomer_id() {
		return customer_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}

	public Product getItem_productid() {
		return item_productid;
	}

	public void setItem_productid(Product item_productid) {
		this.item_productid = item_productid;
	}

	public CustumerProductEntity(Customer customer_id, Product item_productid) {
		super();
		this.customer_id = customer_id;
		this.item_productid = item_productid;
	}

	public CustumerProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
