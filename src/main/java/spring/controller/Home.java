package spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String Hello() {
		return "This is page that show to all ";
	}
}
