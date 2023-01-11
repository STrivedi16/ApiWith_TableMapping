package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.RequestMessage.ErrorMessage;
import spring.RequestMessage.SuccessMessage;
import spring.entity.customer_entity_item;
import spring.service.NotFoundException;
import spring.service.customer_entity_itemService;

@RestController
@RequestMapping(value = "api")
public class CustomerProductController {

	@Autowired
	private customer_entity_itemService customerproductservice;

	@PostMapping("/buy")
	public ResponseEntity<?> setcustomerproduct(@RequestBody customer_entity_item custmproduct) {
		customer_entity_item cstm;
		try {
			System.err.println("TETRTRYU11111111");
			cstm = this.customerproductservice.addbuy(custmproduct);
			return new ResponseEntity<>(new SuccessMessage("Successfull", "Successfull", cstm), HttpStatus.OK);
		} catch (NotFoundException e) {

			return new ResponseEntity<>(new ErrorMessage(e.getMessage(), "Not Found"), HttpStatus.NOT_FOUND);
		}

	}

}
