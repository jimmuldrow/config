package com.test.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.model.Customer;
import com.test.model.Item;
import com.test.aggregator.Aggregator;
import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {
	
	@Autowired
	Aggregator aggregator;

	@RequestMapping(value = "/getCustomer/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
		return aggregator.getCustomer(customerId);
	}

	@RequestMapping(value = "/getItem", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> getItem(HttpServletRequest request) {
		return aggregator.getItem(request);
	}
	
	@RequestMapping(value = "/postNewCustomer", method = RequestMethod.POST)
	public void postNewCustomer(@RequestBody Customer customer){
		aggregator.postNewCustomer(customer);
	}
}
