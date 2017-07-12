package com.test.services;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.util.*;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import static com.test.constants.Constants.HOST;
import static com.test.constants.Constants.GET_CUSTOMER;
import static com.test.constants.Constants.GET_ITEM;
import static com.test.constants.Constants.POST_CUSTOMER;
import com.test.model.Customer;
import com.test.model.Item;


// @LoadBalanced and @RibbonClient and Eureka allow using PURCHASES to call another micro-service

@RibbonClient(name = "PURCHASES", configuration = Services.class)
@Service
public class Services {

	@Autowired
	Environment env;
	
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;
	
	public Customer purchaseCustomer(String customerId) {
		UriComponents customerUI = UriComponentsBuilder.newInstance().scheme("http").host(env.getProperty(HOST))
				.path(env.getProperty(GET_CUSTOMER)).buildAndExpand(customerId);		
		return restTemplate.getForObject(customerUI.toString(), Customer.class);
	}
	
	public Item purchaseItem(String itemId) {
		UriComponents itemUI = UriComponentsBuilder.newInstance().scheme("http").host(env.getProperty(HOST))
				.path(env.getProperty(GET_ITEM)).buildAndExpand();		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("itemId", itemId);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Item> itemResponse = restTemplate.exchange(itemUI.toString(), HttpMethod.GET, entity,
				Item.class);	
		Item item = itemResponse.getBody();
		return item;
	}
	
	public void postNewCustomer(Customer customer){
		UriComponents postCustomerUI = UriComponentsBuilder.newInstance().scheme("http").host(env.getProperty(HOST))
				.path(env.getProperty(POST_CUSTOMER)).buildAndExpand();				
		HttpEntity<Customer> request = new HttpEntity<>(customer);
		restTemplate.postForLocation(postCustomerUI.toString(), request, Customer.class);
	}
}

