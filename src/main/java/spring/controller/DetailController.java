package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.entity.Detail;
import spring.service.DetailService;

@RestController
public class DetailController {

	@Autowired
	private DetailService detailService;

	@PostMapping("/details")
	public ResponseEntity<?> adddeail(@RequestBody Detail detail) {
		return this.detailService.addcstmdetail(detail);

	}

	@GetMapping("/getdetails")
	public ResponseEntity<?> getdata() {
		return this.detailService.getdata();
	}

}
