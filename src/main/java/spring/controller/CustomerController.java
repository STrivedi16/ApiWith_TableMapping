package spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.entity.Customer;
import spring.service.Cstmservice;

@RestController
public class CustomerController {

	@Autowired
	private Cstmservice cstmservice;

	@PostMapping("api/customer")
	public ResponseEntity<?> addcustomer(@RequestBody Customer customer) {
		return this.cstmservice.setdata(customer);
	}

//	@GetMapping("api/customers")
//	public ResponseEntity<?> getcustomer() {
//		return this.cstmservice.getdata();
//	}

	@GetMapping("api/customer/{id}")
	public Optional<Customer> getByid(@PathVariable("id") int id) {
		return this.cstmservice.findById(id);
	}

}
