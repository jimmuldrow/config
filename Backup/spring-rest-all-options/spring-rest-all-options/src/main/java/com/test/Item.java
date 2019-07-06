package com.test;

public class Item {
	private String name;
	private double price;
	private String brand;

	public Item() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", brand=" + brand + "]";
	}
}
