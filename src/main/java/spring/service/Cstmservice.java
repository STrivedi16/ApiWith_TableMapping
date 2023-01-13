package spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ListInterface.BuyInterface;
import ListInterface.CustomerId;
import ListInterface.CustomerInterface;
import spring.RequestMessage.SuccessMessage;
import spring.entity.Customer;
import spring.repository.CustomerRepository;
import spring.repository.DetailRepository;

@Component
@Service
public class Cstmservice {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DetailRepository detailRepository;

	List<Customer> list = new ArrayList<>();

	public ResponseEntity<?> setdata(Customer customer) {

		return new ResponseEntity<>(new SuccessMessage("stored", "Successfull", customerRepository.save(customer)),
				HttpStatus.OK);
	}

//	public ResponseEntity<?> getdata() {
//		// List<Customer> list = customerRepository.findAll();
//
//		return new ResponseEntity<>(new SuccessMessage("Successfull GET", "Successfull", customerRepository.findAll()),
//				HttpStatus.OK);
//
//	}

//	public List<CustomerInterface> getbyid(int id) throws Exception {
//
//		List<CustomerInterface> customer = this.customerRepository.findById(id, CustomerInterface.class);
//
//		return customer;
//	}

	public List<CustomerInterface> getall() {
		List<CustomerInterface> list = this.customerRepository.findAll(CustomerInterface.class);

		return list;
	}

	public Customer update(Customer customer) {
		Customer list = this.customerRepository.save(customer);

		return list;
	}

	public String delete(int customer) {
		this.customerRepository.deleteById(customer);

		return "Your data has been Deleted";

	}

	public List<CustomerId> getbyid(int id) throws Exception {

		List<CustomerId> customer = this.customerRepository.findById(id, CustomerId.class);

		return customer;
	}

	public Customer Product(Customer customer) {
		Customer customer2 = this.customerRepository.save(customer);

		return customer2;
	}

	public Customer setprodctCustomer(Customer customer) {
		Customer customer2 = this.customerRepository.save(customer);

		return customer2;
	}

	public BuyInterface cstmproduct(BuyInterface cstmprod) {

		BuyInterface buy = this.customerRepository.save(cstmprod);

		return buy;
	}

	public List<CustomerInterface> getcustomerinpage(Integer pagenumber, Integer pagesize) {
		Pageable pageable = PageRequest.of(pagenumber, pagesize);

		Page<CustomerInterface> page = this.customerRepository.findAll(pageable, CustomerInterface.class);

		List<CustomerInterface> list = page.getContent();

		return list;
	}

}
