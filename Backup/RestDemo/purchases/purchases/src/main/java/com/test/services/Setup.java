package com.test.services;

import org.springframework.stereotype.Component;
import com.test.model.Customer;
import com.test.model.Item;
import java.util.Map;
import java.util.HashMap;

@Component
public class Setup {

	private Map<String, Customer> customerMap = new HashMap<String, Customer>();
	private Map<String, Item> itemMap = new HashMap<String, Item>();

	public Map<String, Customer> getCustomerMap() {
		return customerMap;
	}

	public void setCustomerMap(Map<String, Customer> customerMap) {
		this.customerMap = customerMap;
	}

	public Map<String, Item> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, Item> itemMap) {
		this.itemMap = itemMap;
	}

	public Setup() {
		customers();
		items();
	}

	private void customers() {
		customerMap.put("1", loadCustomer("1", "Fred", "Murtz", "12 Sunset Blvd", "Apt 132", "Irvine", "CA", "48932", "389 734-8128","1894/12/21"));
		customerMap.put("2", loadCustomer("2", "Lucille", "Ball", "1563 Hollywood Blvd", "Apt 91", "Hollywood", "CA", "48932", "479 725-9409","1921/4/2"));
		customerMap.put("3", loadCustomer("3", "Desi", "Arnez", "142 Hillside St", "", "Hollywood", "CA", "48932", "846 721-8572","1911/6/14"));
		customerMap.put("4", loadCustomer("4", "Ethyl", "Murtz", "12 Sunset Blvd", "Apt 132", "Irvine", "CA", "48932", "389 734-8128","1901/2/27"));
		customerMap.put("5", loadCustomer("5", "Gilligan", "Island", "3 Coconut Way", "Hut 7", "Honolulu", "HA", "63892", "746 627-9832","1932/8/21"));
		customerMap.put("6", loadCustomer("6", "Thurston", "Howell", "47 Beverly Hills", "Apt 218", "Irvine", "CA", "57632", "735 638-9082","1937/7/11"));
		customerMap.put("7", loadCustomer("7", "Ginger", "Rogers", "18 Park Ave", "Apt 7", "New York", "NY", "37904", "731 894-9126","1925/4/29"));
	}
	
	public void postCustomer(Customer customer){
		customerMap.put(customer.getCustomerId(), customer);
	}
	
	private Customer loadCustomer(String customerId, String first, String last, String streetAddressOne, String streetAddressTwo,
			String city, String state, String zip, String phone, String dateOfBirth){
		Customer customer = new Customer();
		customer.loadCustomer(customerId, first, last, streetAddressOne, streetAddressTwo,
				city, state, zip, phone, dateOfBirth);
		return customer;
	}

	private void items() {
		itemMap.put("1", loadItem("1", "microwave", "Sunbeam", "125.00"));
		itemMap.put("2", loadItem("2", "tv", "Sony", "1,500.00"));
		itemMap.put("3", loadItem("3", "vase", "green", "40.00"));
		itemMap.put("4", loadItem("4", "tire", "Goodyear", "125.00"));
		itemMap.put("5", loadItem("5", "dishwasher", "Maytag", "600.00"));
		itemMap.put("6", loadItem("6", "shirt", "blue", "12.00"));
	}
	
	private Item loadItem(String itemId, String itemName, String itemDescription, String itemPrice){
		Item item = new Item();
		item.loadItem(itemId, itemName, itemDescription, itemPrice);
		return item;
	}
}
