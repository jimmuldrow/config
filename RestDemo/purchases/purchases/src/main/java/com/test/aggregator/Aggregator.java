package com.test.aggregator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import com.test.model.Customer;
import com.test.model.Item;
import com.test.services.Services;

@Component
public class Aggregator {
	
	@Autowired
	Services services;
	public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
		return services.getCustomer(customerId);
	}
	
	public ResponseEntity<Item> getItem(HttpServletRequest request) {
		return services.getItem(request);
	}
	
	public void postNewCustomer(Customer customer){
		services.postNewCustomer(customer);
	}
}
