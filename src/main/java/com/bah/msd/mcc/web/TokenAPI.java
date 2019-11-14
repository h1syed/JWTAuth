package com.bah.msd.mcc.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bah.msd.mcc.domain.Customer;
import com.bah.msd.mcc.domain.Token;
import com.bah.msd.mcc.domain.TokenRequestData;
import com.bah.msd.mcc.service.JWTHelper;
import com.bah.msd.mcc.service.JWTUtil;

@RestController
@RequestMapping("/account")
public class TokenAPI {
		JWTUtil jwtUtil = new JWTHelper();
		private final String urlLogin = "http://localhost:8080/api/customers/login";
		private final String uriRegister = "http://localhost:8080/api/customers/register";
		private final String API_Scope = "com.bah.msd.mcc.web";
		
		@PostMapping("/token")
		public ResponseEntity<?> getToken(@RequestBody TokenRequestData customer) {
			String username = customer.getName();
			String password = customer.getPassword();
			
			if (username != null && username.length() > 0 && password != null && password.length() > 0) {
				RestTemplate restTemplate = new RestTemplate();
				Customer cust = new Customer(username,password,null);
				HttpEntity<Customer> request = new HttpEntity<Customer>(cust);
				Boolean custLegit = restTemplate.postForObject(urlLogin,request, Boolean.class);
				if(custLegit) {
					Token token = jwtUtil.createToken(API_Scope);
					ResponseEntity<?> response = ResponseEntity.ok(token);
					return response;			
				}
	
			}
			// bad request
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			
		}
		
		@PostMapping("/register")
		public ResponseEntity<?> makeToken(@RequestBody Customer customer){
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Customer> request = new HttpEntity<Customer>(customer);
			return restTemplate.postForObject(uriRegister, request, ResponseEntity.class);
		}
		
	    
		
}
