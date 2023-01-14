package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ListInterface.ProductInterface;
import spring.RequestMessage.ErrorMessage;
import spring.RequestMessage.SuccessMessage;
import spring.RequestMessage.SuccessMessagePage;
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

	@GetMapping("/products")
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
			Page<Product> list2 = this.prodtservice.getInpage(pagenumber, pagesize);

			return new ResponseEntity<>(new SuccessMessagePage("Successfully GET", "Successfull", list2.getContent(),
					pagenumber, pagesize, list2.getTotalPages()), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Data not Found", "Not Found"), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/search")
	public ResponseEntity<?> getserch(
			@RequestParam(value = "Search", defaultValue = "-", required = false) String product) {
		try {

			String product1 = product;
			boolean product3 = product1.equalsIgnoreCase(product);

			System.out.println(product3);

			Product product2 = this.prodtservice.getInsearch(product);

			return new ResponseEntity<>(new SuccessMessage("Success", "Success", product2), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorMessage("Error ", "Not Found"), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		try {
			String product = this.prodtservice.deleteProduct(id);

			return new ResponseEntity<>(new SuccessMessage("SuccessFull Discontinue", "Success", product),
					HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error ", "Not Found"), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/searchproduct")
	public ResponseEntity<?> Insearch(
			@RequestParam(value = "search", defaultValue = "-", required = false) String product) {

		try {

			System.out.println(product);
			Product product2 = this.prodtservice.getSearch(product);

			return new ResponseEntity<>(new SuccessMessage("Success", "Success", product2), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error ", "Not Found "), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/contain")
	public ResponseEntity<?> Contain(
			@RequestParam(value = "getsearch", defaultValue = "-", required = false) String product) {
		try {
			System.out.println(product);

			List<ProductInterface> list = this.prodtservice.getProductContaining(product);

			return new ResponseEntity<>(new SuccessMessage("Success", "Success", list), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error", "Not Found"), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/Unique")
	public ResponseEntity<?> Uniqueserch(

			@RequestParam(value = "product", defaultValue = "", required = false) String product,
			@RequestParam(value = "price", defaultValue = "", required = false) Integer price,
			@RequestParam(value = "company", defaultValue = "", required = false) String company) {
		try {
			List<ProductInterface> list2 = this.prodtservice.getunique(product, price, company);

			return new ResponseEntity<>(new SuccessMessage("Success", "Success", list2), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorMessage("Error ", "Not Found"), HttpStatus.NOT_FOUND);
		}
	}

}
