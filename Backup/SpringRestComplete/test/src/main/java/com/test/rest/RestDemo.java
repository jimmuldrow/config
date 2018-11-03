package com.test.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.Locale;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

@RestController
public class RestDemo {
	
	CustomerFactory customerFactory = new CustomerFactory();
	ItemFactory itemFactory = new ItemFactory();	
	
	public RestDemo(){
		customerMap.put("1", customerFactory.createCustomer("1", "Mike", "Smith"));
		customerMap.put("2", customerFactory.createCustomer("2", "Lois", "Lane"));
		customerMap.put("3", customerFactory.createCustomer("3", "Lucy", "Ricardo"));
		customerMap.put("4", customerFactory.createCustomer("4", "Bruce", "Wayne"));
		
		itemMap.put("1",  itemFactory.createItem("1",  "Sunbeam", "Toaster", "30.00"));
		itemMap.put("2",  itemFactory.createItem("2",  "Whirlpool", "Washer", "500.00"));
		itemMap.put("3",  itemFactory.createItem("3",  "GE", "Circuit Breaker", "20.00"));
		itemMap.put("4",  itemFactory.createItem("4",  "Bunn", "Coffee Maker", "110.00"));
	}
	
	Map<String, Customer> customerMap = new HashMap<String, Customer>();
	Map<String, Item> itemMap = new HashMap<String, Item>();
	

	@RequestMapping(value="/purchase/{customerId}/{itemId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> purchase(
			@PathVariable String customerId, 
			@PathVariable String itemId, 
			@RequestParam(value="purchaseDate", required=false) String purchaseDate){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);				
		DateUtils dateUtils = new DateUtils();
		Purchase purchase = new Purchase();
		Customer customer = customerMap.get(customerId);
		Item item = itemMap.get(itemId);
		String stringPurchase = "";
		
		if((customer == null) || (item == null)){
			stringPurchase = purchaseJson(purchase);
			return new ResponseEntity<String>(stringPurchase, HttpStatus.NOT_FOUND);
		}
		
		if(purchaseDate == null){
			LocalDate dt = LocalDate.now();
			purchaseDate = dateUtils.formatDate(dt,  "MM/dd/yyyy",  Locale.US);
		}

		purchase.setPurchaseDate(purchaseDate);
		purchase.setCustomer(customer);
		purchase.setItem(item);
		stringPurchase = purchaseJson(purchase);
		return new ResponseEntity<String>(stringPurchase, HttpStatus.OK);
	}
	
	private String purchaseJson(Purchase purchase){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);		
		String stringPurchase = "";
		
		try {
			stringPurchase = objectMapper.writeValueAsString(purchase);
			return stringPurchase;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}		
	}
	
	@RequestMapping(value="/testPostThroughHeader", method=RequestMethod.GET)
	public String testPostThroughHeader(){		
		UriComponents itemUI = UriComponentsBuilder.newInstance().scheme("http").host("localhost:8080/test")
				.path("/postThroughHeader/{customerId}").buildAndExpand("5");	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("first", "Alfred");
		headers.set("last", "Neuman");
		@SuppressWarnings({ "unchecked", "rawtypes" })
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<String> response = new RestTemplate().exchange(itemUI.toString(), HttpMethod.POST, entity, String.class);				
		return response.getBody();
	}
	
	@RequestMapping(value="/postThroughHeader/{customerId}", method=RequestMethod.POST)
	public String postThroughHeader(
			@PathVariable String customerId, 
			HttpServletRequest request)	{
		String first = request.getHeader("first");
		String last = request.getHeader("last");
		Customer customer = customerFactory.createCustomer(customerId, first, last);
		customerMap.put(customer.getId(), customer);
		return "success";
	}
	
	@RequestMapping(value="/testPutThroughObject", method=RequestMethod.GET)
	public String testPutThroughObject(){
		UriComponents itemUI = UriComponentsBuilder.newInstance().scheme("http").host("localhost:8080/test")
				.path("/putThroughObject").buildAndExpand();			
		Customer customer = customerFactory.createCustomer("1",  "Hal",  "Jordan");
		new RestTemplate().put("http://localhost:8080/test/putThroughObject", customer);
		return "success";
	}
	
	@RequestMapping(value="/putThroughObject", method=RequestMethod.PUT)
	public void postThroughObject(@RequestBody Customer customer){
		customerMap.put(customer.getId(), customer);
	}
}
