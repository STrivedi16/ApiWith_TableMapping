package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.RequestMessage.ErrorMessage;
import spring.RequestMessage.SuccessMessage;
import spring.entity.Product;
import spring.service.NotFoundException;
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

	@GetMapping("/allproduct")
	public ResponseEntity<?> getAllproduct() {
		List<Product> list = this.prodtservice.getproduct();
		try {
			if (list.size() <= 0) {
				throw new NotFoundException("No Data Found");
			}
			return new ResponseEntity<>(new SuccessMessage("Successfull Get REcord", "Successfull", list),
					HttpStatus.OK);

		} catch (NotFoundException e) {
			return new ResponseEntity<>(new ErrorMessage(e.getMessage(), "Not Found"), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/page")
	public ResponseEntity<?> getinpage(
			@RequestParam(name = "pagenumber", defaultValue = "1", required = false) Integer pagenumber,
			@RequestParam(name = "pagesize", defaultValue = "5", required = false) Integer pagesize) {
		try {
			List<Product> list2 = this.prodtservice.getInpage(pagenumber, pagesize);

			return new ResponseEntity<>(new SuccessMessage("Successfully GET", "Successfull", list2), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Data not Found", "Not Found"), HttpStatus.NOT_FOUND);
		}

	}
}
