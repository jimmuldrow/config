package com.test.rest;

public class ItemFactory {
	
	public Item createItem(String id, String brand, String itemName, String price){
		Item item = new Item();
		item.setId(id);
		item.setBrand(brand);
		item.setItemName(itemName);
		item.setPrice(price);
		return item;
	}

}
