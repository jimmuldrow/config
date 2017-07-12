package com.test.aggregator;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.test.model.Customer;
import com.test.model.Item;
import com.test.model.CustomerItem;
import com.test.services.Services;
import com.test.mapping.Mapping;

@Component
public class Aggregator {
	
	@Autowired
	Services services;
	
	@Autowired 
	Mapping mapping;

	public ResponseEntity<CustomerItem> purchase(String customerId, String itemId) {
		Customer customer = services.purchaseCustomer(customerId);
		Item item = services.purchaseItem(itemId);
		CustomerItem customerItem = mapping.mapCustomerItem(customer, item);
		return new ResponseEntity<CustomerItem>(customerItem, HttpStatus.OK);
	}

	public void postNewCustomer(Customer customer){
		services.postNewCustomer(customer);
	}
}
