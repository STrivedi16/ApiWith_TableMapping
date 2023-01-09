package spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

	public List<CustomerInterface> getbyid(int id) throws Exception {

		List<CustomerInterface> customer = this.customerRepository.findById(id, CustomerInterface.class);

		return customer;
	}

	public List<CustomerInterface> getall() {
		List<CustomerInterface> list = this.customerRepository.findAll(CustomerInterface.class);

		return list;
	}

}
