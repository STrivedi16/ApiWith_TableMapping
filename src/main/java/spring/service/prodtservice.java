package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	public List<Product> getproduct() {

		int pagesize = 5;
		int pagenumber = 3;

		Pageable pageable = PageRequest.of(pagenumber, pagesize);

		Page<Product> list = this.productRepository.findAll(pageable);

		return list.getContent();
	}

//	public List<ProductInterface> getallrecords() {
//		List<ProductInterface> list = this.productRepository.findAll(ProductInterface.class);
//
//		return list;
//
//	}

	public List<Product> getInpage(Integer pagenumber, Integer pagesize) {
		Pageable pageable = PageRequest.of(pagenumber, pagesize);

		Page<Product> page = this.productRepository.findAll(pageable);

		List<Product> list = page.getContent();

		return list;
	}

}
