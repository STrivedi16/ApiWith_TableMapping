package spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import spring.RequestMessage.SuccessMessage;
import spring.entity.Customer;
import spring.repository.CustomerRepository;

@Component
public class Cstmservice {

	@Autowired
	private CustomerRepository customerRepository;

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

	public Optional<Customer> findById(int id) {
		return customerRepository.findById(id);
	}

}
