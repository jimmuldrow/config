package com.test;

import javax.xml.bind.annotation.XmlRootElement; 
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="customer")
@XmlType(propOrder = {"first", "last", "streetAddressOne", "streetAddressTwo", "city", "state", "zip"})
public class Customer {
	private String first = "";
	private String last = "";
	private String streetAddressOne = "";
	private String streetAddressTwo = "";
	private String city = "";
	private String state = "";
	private String zip = "";
	
	public String getFirst(){return first;}
	public void setFirst(String first){this.first = first;}
	
	public String getLast(){return last;}
	public void setLast(String last){this.last = last;}
	
	public String getStreetAddressOne(){return streetAddressOne;}
	public void setStreetAddressOne(String streetAddressOne){this.streetAddressOne = streetAddressOne;}	
	
	public String getStreetAddressTwo(){return streetAddressTwo;}
	public void setStreetAddressTwo(String streetAddressTwo){this.streetAddressTwo = streetAddressTwo;}	

	public String getCity(){return city;}
	public void setCity(String city){this.city = city;}	
	
	public String getState(){return state;}
	public void setState(String state){this.state = state;}	
	
	public String getZip(){return zip;}
	public void setZip(String zip){this.zip = zip;}		
}
