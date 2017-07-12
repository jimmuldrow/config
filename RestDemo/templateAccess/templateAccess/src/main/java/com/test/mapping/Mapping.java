package com.test.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.test.model.Customer;
import com.test.model.Item;
import com.test.utilities.DateUtils;
import com.test.utilities.NumberUtils;
import com.test.model.CustomerItem;

@Component
public class Mapping {
	
	@Autowired
	DateUtils dateUtils;
	
	@Autowired
	NumberUtils numberUtils;
	
	public CustomerItem mapCustomerItem(Customer customer, Item item){
		customer.setDateOfBirth(dateUtils.formatUSDateFromYMD(customer.getDateOfBirth()));
		item.setItemPrice(numberUtils.formatUSCurrency(item.getItemPrice()));
		CustomerItem customerItem = new CustomerItem();
		customerItem.setCustomer(customer);
		customerItem.setItem(item);
		return customerItem;
	}	
}
