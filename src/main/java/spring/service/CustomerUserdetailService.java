package spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.entity.Customer;
import spring.repository.CustomerRepository;

@Service
public class CustomerUserdetailService implements UserDetailsService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			Customer customer = this.repository.findByEmail(username);

			return new User(customer.getEmail(), customer.getPassword(), new ArrayList<>());
		} catch (Exception e) {
			e.printStackTrace();

			throw new UsernameNotFoundException("User email is not valid and not found ");
		}

	}

}
