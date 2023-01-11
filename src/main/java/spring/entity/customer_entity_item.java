package spring.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class customer_entity_item {

	@Id
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer_id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Product item_productid;

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

	public customer_entity_item(Customer customer_id, Product item_productid) {
		super();
		this.customer_id = customer_id;
		this.item_productid = item_productid;
	}

	public customer_entity_item() {
		super();
		// TODO Auto-generated constructor stub
	}

}
