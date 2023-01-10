package Sping.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.RequestMessage.SuccessMessage;
import spring.entity.ProductOM;

@RestController
public class ProductController {

	@Autowired
	private ProdRepository prodRepository;

	@PostMapping("customers")
	public ResponseEntity<?> setdata(@RequestBody ProductOM productOM) {

		return new ResponseEntity<>(new SuccessMessage("Successfull", "Successfull", prodRepository.save(productOM)),
				HttpStatus.OK);
	}
}
