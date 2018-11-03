package com.test;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;
import java.util.*;
import java.net.URI;

public class Test {
	RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		new Test();
	}	

	Test(){
		//getForEntity();
		//getForObject();		
		postForObject();
		postForLocation();
		put();
		delete();
		System.out.println("*** End");
	}
	
	void getForEntity() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8080/getItem";
		ResponseEntity<Item> response = restTemplate.getForEntity(uri + "/1", Item.class);	
		Item item = response.getBody();
		System.out.println("*** getForEntity item = " + item);
	}
	
	void getForObject() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8080/getItemTwo?id=1";
		Item item = restTemplate
				  .getForObject(uri, Item.class);
		System.out.println("*** getForObject item = " + item);
	}	
	
	void postForObject() {
        try{
        	Map<String, String> vars = new HashMap<String, String>();
            vars.put("id", "6");
            RestTemplate rt = new RestTemplate();
            String uri = "http://localhost:8080/postItemForObject/{id}";
            Item item = new Item();
            item.setName("coffee maker");
            item.setPrice(55.0);
            item.setBrand("Black & Decker");
            String result = rt.postForObject(uri, item, String.class, vars);
            System.out.println("result:  " + result);
        }
        catch(Exception e){
            System.out.println("error:  " + e.getMessage());
        }
	}
	
	void postForLocation() {
        try{
        	Map<String, String> vars = new HashMap<String, String>();
            vars.put("id", "7");
            RestTemplate rt = new RestTemplate();
            String uri = "http://localhost:8080/postItemForObject/{id}";
            Item item = new Item();
            item.setName("frisbee");
            item.setPrice(12.0);
            item.setBrand("Whamo");
            URI location = rt.postForLocation(uri, item, vars);
            System.out.println("URL = " + location);
        }
        catch(Exception e){
            System.out.println("error:  " + e.getMessage());
        }
	}	
	
	void put() {
        try{
        	Map<String, String> vars = new HashMap<String, String>();
            vars.put("id", "7");
            RestTemplate rt = new RestTemplate();
            String uri = "http://localhost:8080/putItemForObject/{id}";
            Item item = new Item();
            item.setName("frisbee");
            item.setPrice(15.0);
            item.setBrand("Whamo");
            rt.put(uri, item, vars);
        }
        catch(Exception e){
            System.out.println("error:  " + e.getMessage());
        }
	}	
	
	void delete() {
        try{
        	Map<String, String> vars = new HashMap<String, String>();
            vars.put("id", "1");
            RestTemplate rt = new RestTemplate();
            String uri = "http://localhost:8080/delete/{id}";
            rt.delete(uri, vars);
        }
        catch(Exception e){
            System.out.println("error:  " + e.getMessage());
        }		
	}
}
