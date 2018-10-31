package com.test;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class Util {
	public Map<String, Item> itemMap = new HashMap<String, Item>();
	public List<AccountsProfile> accountsList = new ArrayList<AccountsProfile>();
	
	public Util() {		
		itemMap.put("1", addItems("toaster", 35.00, "Sunbeam"));
		itemMap.put("2", addItems("shirt", 50.00, "Brooks Bros."));
		itemMap.put("3", addItems("watch", 125.00, "Seiko"));
		itemMap.put("4", addItems("smart phone", 135.00, "Apple"));
		itemMap.put("5", addItems("television", 700.00, "Sony"));
		
		accountsList.add(addAccounts("1", "accountNumber1", "accountName1", "abc"));
		accountsList.add(addAccounts("2", "accountNumber2", "accountName2", "abc"));
		accountsList.add(addAccounts("3", "accountNumber3", "accountName3", "abc"));
		accountsList.add(addAccounts("4", "accountNumber4", "accountName4", "abc"));
		accountsList.add(addAccounts("1", "accountNumber1", "accountName1", "abc"));
		accountsList.add(addAccounts("5", "accountNumber5", "accountName5", "abc"));			
	}

	
	private Item addItems(String name, double price, String brand) {
		Item item = new Item();
		item.setName(name);
		item.setPrice(price);
		item.setBrand(brand);
		return item;
	}
	
	private AccountsProfile addAccounts(String accountId, String accountNumber, String accountName, String ewRefCode) {
		AccountsProfile accountsProfile = new AccountsProfile();
		accountsProfile.setAccountId(accountId);
		accountsProfile.setAccountNumber(accountNumber);
		accountsProfile.setAccountName(accountName);
		accountsProfile.setEwRefCode(ewRefCode);
		return accountsProfile;
	}			
}
