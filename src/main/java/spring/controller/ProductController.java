package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
