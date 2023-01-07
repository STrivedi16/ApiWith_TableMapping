package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import spring.RequestMessage.SuccessMessage;
import spring.entity.Detail;
import spring.repository.DetailRepository;

@Component
public class DetailService {

	@Autowired
	private DetailRepository detailRepository;

	public ResponseEntity<?> addcstmdetail(Detail detail) {
		return new ResponseEntity<>(
				new SuccessMessage("Stored Sucessfull", "Successfull", detailRepository.save(detail)), HttpStatus.OK);

	}

	public ResponseEntity<?> getdata() {
		List<Detail> list = detailRepository.findAll();

		return new ResponseEntity<>(new SuccessMessage("Successfull", "Successfull", list), HttpStatus.OK);
	}

}
