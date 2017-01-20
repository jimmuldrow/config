package com.test;

public class Test {	
	public static void main(String[] args){
		CustomerServiceService customerServiceService = new CustomerServiceService();
		CustomerService customerService = customerServiceService.getCustomerServicePort();
		String s = customerService.getCustomer("Fred",  "Flintstone",  "13 Quarry St",  "Apt 205",  "Bedrock",  "Pangaea", "38720");
		System.out.println(s);
	}
}
