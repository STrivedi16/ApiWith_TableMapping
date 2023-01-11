package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.entity.Customer;
import spring.entity.customer_entity_item;
import spring.repository.CustomerRepository;
import spring.repository.customer_entity_itemReposiory;

@Service
public class customer_entity_itemService {

	@Autowired
	private customer_entity_itemReposiory customerproduct;

	@Autowired
	private CustomerRepository customerRepo;

	public customer_entity_item addbuy(customer_entity_item itemService) throws NotFoundException {

		System.err.println("ASDFGHJ111");
		Customer customer = customerRepo.findById(itemService.getId())
				.orElseThrow(() -> new NotFoundException("not found"));
		System.err.println("ASDFGHJ111222" + customer);

		customer_entity_item customer2 = this.customerproduct.save(customer);
		System.err.println("ASDFGHJ1112223333444" + customer2);

		return customer2;

	}
}
