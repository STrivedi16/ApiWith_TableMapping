package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ListInterface.CustomerProductInterface;
import spring.entity.Customer;
import spring.entity.CustumerProductDto;
import spring.entity.CustumerProductEntity;
import spring.entity.Product;
import spring.repository.CustomerRepository;
import spring.repository.ProductRepository;
import spring.repository.customer_entity_itemReposiory;

@Service
public class customer_entity_itemService {

	@Autowired
	private customer_entity_itemReposiory customerproduct;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private ProductRepository productRepository;

	public CustumerProductEntity addbuy(CustumerProductEntity itemService) throws NotFoundException {

		Customer customer = customerRepo.findById(itemService.getId())
				.orElseThrow(() -> new NotFoundException("not found"));

		CustumerProductEntity customer2 = this.customerproduct.save(customer);

		return customer2;

	}

	public CustumerProductEntity AddProduct(CustumerProductDto cstmproduct) throws NotFoundException {

		Customer customer = customerRepo.findById(cstmproduct.getCusumerId())
				.orElseThrow(() -> new NotFoundException("Custumer not found"));

		Product product = productRepository.findByProductid(cstmproduct.getProductId());

		CustumerProductEntity custumerProductEntity = new CustumerProductEntity();

		custumerProductEntity.setCustomer_id(customer);
		custumerProductEntity.setItem_productid(product);

		this.customerproduct.save(custumerProductEntity);

		return custumerProductEntity;
	}

	public List<CustumerProductEntity> getallrecords() {

		List<CustumerProductEntity> list = this.customerproduct.findAll();

		return list;

	}

	public List<CustomerProductInterface> getallbuyer() {
		List<CustomerProductInterface> list1 = this.customerproduct.findAll(CustomerProductInterface.class);

		return list1;

	}

}
