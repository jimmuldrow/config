package com.test;

public class MavenAxis2WebService {
	  public String ping(String first, String last, String streetAddressOne, String streetAddressTwo, 
			  String city, String state, String zip) {
	    	ParserUtil<Customer> parserUtil = new ParserUtil<Customer>();
	        Customer customer = new Customer();
	        customer.setFirst(noNull(first));
	        customer.setLast(noNull(last));
	        customer.setStreetAddressOne(noNull(streetAddressOne));
	        customer.setStreetAddressTwo(noNull(streetAddressTwo));
	        customer.setCity(noNull(city));
	        customer.setState(noNull(state));
	        customer.setZip(noNull(zip));
	        return parserUtil.objectToXmlString(customer,  Customer.class); 
	    }
	    
	    private String noNull(String s){return ((s == null) ? "" : s.trim());}
	}
