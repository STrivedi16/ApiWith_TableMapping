package spring.JwtController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.jwtConfig.JwtTokenUtil;
import spring.model.JwtReponce;
import spring.model.JwtRequest;
import spring.service.CustomerUserdetailService;

@RestController
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomerUserdetailService customerUserDetailService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println(jwtRequest);

		try {

			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Bad creditaiol");

		}

		UserDetails details = this.customerUserDetailService.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtTokenUtil.generateToken(details);

		System.out.println(token);

		return ResponseEntity.ok(new JwtReponce(token));
	}
}
