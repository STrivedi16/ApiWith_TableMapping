package spring.jwtConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import spring.service.CustomerUserdetailService;

@Configuration
@EnableWebSecurity
public class WebsecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomerUserdetailService service;

	@Autowired
	private JwtFilter filter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// We need to disable cross origin resource shearing
		http.csrf().disable().cors().disable()
				// in this we only allow this request all other request are authenticate
				.authorizeRequests()
				.antMatchers("/token", "/customer/register", "/product", "/product/page", "/product/searchproduct",
						"/hello")
				.permitAll().anyRequest().authenticated().and()
				// session want be used to stored user's state we we take session as stateless
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		System.err.println("get is add");

		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(service);
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
