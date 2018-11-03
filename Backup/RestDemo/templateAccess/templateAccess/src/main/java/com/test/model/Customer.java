package com.test.model;

public class Customer {

	private String customerId;
	private String first;
	private String last;
	private String streetAddressOne;
	private String streetAddressTwo;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String dateOfBirth;

	public Customer() {
	}

	public void loadCustomer(String customerId, String first, String last, String streetAddressOne, String streetAddressTwo,
			String city, String state, String zip, String phone, String dateOfBirth) {
		this.customerId = customerId;
		this.first = first;
		this.last = last;
		this.streetAddressOne = streetAddressOne;
		this.streetAddressTwo = streetAddressTwo;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
	}
	
	public void moveSpaces(){
		this.customerId = "";
		this.first = "";
		this.last = "";
		this.streetAddressOne = "";
		this.streetAddressTwo = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.phone = "";
		this.dateOfBirth = "";
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getStreetAddressOne() {
		return streetAddressOne;
	}

	public void setStreetAddressOne(String streetAddressOne) {
		this.streetAddressOne = streetAddressOne;
	}

	public String getStreetAddressTwo() {
		return streetAddressTwo;
	}

	public void setStreetAddressTwo(String streetAddressTwo) {
		this.streetAddressTwo = streetAddressTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", first=" + first + ", last=" + last + ", streetAddressOne="
				+ streetAddressOne + ", streetAddressTwo=" + streetAddressTwo + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", phone=" + phone + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
