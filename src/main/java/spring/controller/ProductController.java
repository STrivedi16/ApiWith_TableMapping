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

import spring.RequestMessage.SuccessMessage;
import spring.entity.Product;
import spring.service.prodtservice;

@RequestMapping(value = "api")
@RestController
public class ProductController {

	@Autowired
	private prodtservice prodtservice;

	@PostMapping("/product")
	public ResponseEntity<?> addproduct(@RequestBody Product product) {

		return this.prodtservice.addproduct(product);
	}

	@GetMapping("/products")
	public ResponseEntity<?> getallproduct() {
		List<Product> list = this.prodtservice.getallproduct();

		return new ResponseEntity<>(new SuccessMessage("Successfull", "Succesfull", list), HttpStatus.OK);
	}

}
