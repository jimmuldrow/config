package com.test.rest;

public class Customer {
	
	public String id;
	public String first;
	public String last;
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", first=" + first + ", last=" + last + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
}
