package com.citigroup.card.fraud.rest;

import org.springframework.web.client.RestTemplate;
import org.junit.Test;

public class TestServices {
	
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testFraudTransactions(){
		String s = restTemplate.getForObject("http://localhost:8080/getFraudInfoById/1234", String.class);
		System.out.println("************ Fraud Transactions ************");
		System.out.println(s);
		
	}
	
	@Test
	public void testAccountProfiles(){
		String s = restTemplate.getForObject("http://localhost:8080/getAccountProfiles/12345", String.class);		
		System.out.println("************ Account Profiles ************");
		System.out.println(s);
	}
}
