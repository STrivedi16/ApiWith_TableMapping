package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ListInterface.CustomerInterface;
import spring.RequestMessage.ErrorMessage;
import spring.RequestMessage.SuccessMessage;
import spring.entity.Customer;
import spring.service.Cstmservice;
import spring.service.NotFoundException;

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

	/*
	 * @GetMapping("api/{id}") public ResponseEntity<?> getByid(@PathVariable("id")
	 * int id) {
	 * 
	 * try { List<CustomerInterface> customer = this.cstmservice.getbyid(id); return
	 * new ResponseEntity<>(new SuccessMessage("Custumer", "Successfull", customer),
	 * HttpStatus.OK); } catch (Exception e) { return new ResponseEntity<>(new
	 * ErrorMessage(e.getMessage(), "Not found"), HttpStatus.BAD_REQUEST); }
	 * 
	 * }
	 */

	@GetMapping("all")
	public ResponseEntity<?> getall() {
		List<CustomerInterface> list = this.cstmservice.getall();

		try {
			if (list.size() <= 0) {
				throw new NotFoundException("Data Not Found");
			}
			return new ResponseEntity<>(new SuccessMessage("All Data get", "Successfull", list), HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(new ErrorMessage(e.getMessage(), "Not Found"), HttpStatus.NOT_FOUND);
		}

	}

}
