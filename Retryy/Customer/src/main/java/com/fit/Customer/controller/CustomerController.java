package com.fit.Customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fit.Customer.service.CustomerService;

import io.github.bucket4j.Bucket;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private Bucket bucket;
	
	@GetMapping("/rate")
	public String rateLimiter() {
		if(bucket.tryConsume(1)) {
			return customerService.testRetry();
		}else {
			return "Rate limit request";
		}
	}
}
