package com.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class Test {
	
	public static void main(String[] args) {
		ParserUtil<String> parserUtil = new ParserUtil<String>();
		String s = parserUtil.getGETWebServiceString("http://localhost:8080/test/webapi/jersey/fahrenheittocelsius/47", MediaType.TEXT_PLAIN);
		System.out.println(s);
		System.out.println("----------------------------------------------------------------------------");
		
		s = parserUtil.getGETWebServiceString("http://localhost:8080/test/webapi/xmlservice/personlistxml", MediaType.APPLICATION_XML);
		System.out.println(s);		
		System.out.println("----------------------------------------------------------------------------");
		
		ParserUtil<TestDate> parserUtilJson = new ParserUtil<TestDate>();
		TestDate testDate = new TestDate();
		testDate.setMonth("03");
		testDate.setDay("14");
		testDate.setYear("1916");
		testDate.setIsDateValid("false");		 
		s = parserUtilJson.getPOSTWebServiceString("http://localhost:8080/test/webapi/jersey/verifydate", testDate, MediaType.APPLICATION_JSON);
		System.out.println(s);
		
		System.out.println("----------------------------------------------------------------------------");
		TestDate testDate2 = parserUtilJson.getPOSTWebServiceObject("http://localhost:8080/test/webapi/jersey/verifydate", testDate, TestDate.class, MediaType.APPLICATION_JSON);
		System.out.println(testDate2.getIsDateValid());		
	}
} 

    
