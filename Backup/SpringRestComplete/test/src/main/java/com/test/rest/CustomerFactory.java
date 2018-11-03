package com.test.rest;

public class CustomerFactory {
	public Customer createCustomer(String id, String first, String last){
		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirst(first);
		customer.setLast(last);
		return customer;
	}
}
