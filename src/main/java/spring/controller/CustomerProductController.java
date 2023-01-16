package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ListInterface.CustomerProductInterface;
import spring.RequestMessage.ErrorMessage;
import spring.RequestMessage.SuccessMessage;
import spring.entity.CustumerProductDto;
import spring.entity.CustumerProductEntity;
import spring.service.NotFoundException;
import spring.service.customer_entity_itemService;

@RestController
@RequestMapping()
public class CustomerProductController {

	@Autowired
	private customer_entity_itemService customerproductservice;

	@PostMapping("/buyproduct")
	public ResponseEntity<?> customerproduct(@RequestBody CustumerProductDto cstmproduct) {
		try {

			System.err.println(cstmproduct.getCusumerId());

			// System.err.println(id);
			CustumerProductEntity cstm = this.customerproductservice.AddProduct(cstmproduct);

			System.err.println("ahhksnksnsnf");

			return new ResponseEntity<>(new SuccessMessage("Successfull", "SuccessFull",
					(cstm.getCustomer_id() + " " + cstm.getItem_productid())), HttpStatus.OK);

		} catch (Exception e) {
			System.err.println("abcd");
			return new ResponseEntity<>(new ErrorMessage(e.getMessage(), "Not Found"), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/allbuy")
	public ResponseEntity<?> getdata() {

		try {
			List<CustumerProductEntity> list = this.customerproductservice.getallrecords();

			return new ResponseEntity<>(new SuccessMessage("Get all Records", "Successfull", list), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage(e.getMessage(), "Not Found"), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/newallrecords")
	public ResponseEntity<?> getalldata() {
		List<CustomerProductInterface> list2 = this.customerproductservice.getallbuyer();

		try {
			if (list2.size() <= 0) {
				throw new NotFoundException("No Data Found");
			}
			return new ResponseEntity<>(new SuccessMessage("Get all Records", "Successfull", list2), HttpStatus.OK);

		} catch (NotFoundException e) {

			return new ResponseEntity<>(new ErrorMessage(e.getMessage(), "Not Found"), HttpStatus.NOT_FOUND);
		}

	}

}
