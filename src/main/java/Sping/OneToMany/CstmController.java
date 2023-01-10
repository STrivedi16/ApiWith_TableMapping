package Sping.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.RequestMessage.SuccessMessage;
import spring.entity.CustomerOM;

@RestController
public class CstmController {

	@Autowired
	private CstmRepositpory cstmRepositpory;

	@PostMapping("customers")
	public ResponseEntity<?> setdata(@RequestBody CustomerOM customerOM) {

		return new ResponseEntity<>(new SuccessMessage("Successfull", "Successfull", cstmRepositpory.save(customerOM)),
				HttpStatus.OK);
	}

}
