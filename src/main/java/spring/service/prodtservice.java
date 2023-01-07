package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import spring.RequestMessage.SuccessMessage;
import spring.entity.Product;
import spring.repository.ProductRepository;

@Component
public class prodtservice {

	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<?> addproduct(Product product) {
		return new ResponseEntity<>(
				new SuccessMessage("Stored Successfull", "Successfull", productRepository.save(product)),
				HttpStatus.OK);
	}

}
