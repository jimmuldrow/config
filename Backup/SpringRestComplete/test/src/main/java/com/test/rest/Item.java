package com.test.rest;

public class Item {
	
	String id;
	String brand;
	String itemName;
	String price;
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", brand=" + brand + ", itemName=" + itemName + ", price=" + price + "]";
	}	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
