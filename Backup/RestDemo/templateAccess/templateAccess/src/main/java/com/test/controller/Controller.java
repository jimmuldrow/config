package com.test.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.model.CustomerItem;
import com.test.model.Customer;
import com.test.aggregator.Aggregator;

@RestController
public class Controller {
	
	@Autowired
	Aggregator aggregator;

	
	// http://localhost:3333/purchase/8?itemId=2
	
	@RequestMapping(value = "/purchase/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerItem> purchase(@PathVariable String customerId, @RequestParam(value="itemId", required=true) String itemId) {
		postNewCustomer();
		return aggregator.purchase(customerId, itemId);
	}

	public void postNewCustomer(){
		Customer customer = new Customer();
		customer.setCustomerId("8");
		customer.setFirst("Elmer");
		customer.setLast("Fudd");
		customer.setStreetAddressOne("217 Warner Lane");
		customer.setStreetAddressTwo("");
		customer.setCity("Phoenix");
		customer.setState("AZ");
		customer.setZip("47823");
		customer.setPhone("739-289-5873");
		customer.setDateOfBirth("1967/11/19");
		aggregator.postNewCustomer(customer);
	}
}
