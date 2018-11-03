package com.test.services;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import com.test.model.Customer;
import com.test.model.Item;

@Component
public class Services {

	@Autowired
	Setup setup;

	@Autowired
	Environment env;

	public ResponseEntity<Customer> getCustomer(String customerId) {
		return new ResponseEntity<Customer>(setup.getCustomerMap().get(customerId), HttpStatus.OK);
	}

	public ResponseEntity<Item> getItem(HttpServletRequest request) {
		String itemId = request.getHeader("itemId");
		return new ResponseEntity<Item>(setup.getItemMap().get(itemId), HttpStatus.OK);
	}
	
	public void postNewCustomer(Customer customer){		
		setup.postCustomer(customer);
	}
}

