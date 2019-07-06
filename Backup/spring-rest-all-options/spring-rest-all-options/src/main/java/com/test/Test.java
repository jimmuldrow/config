package com.test;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;
import java.util.*;
import java.net.URI;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;


public class Test {
	RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		new Test();
	}	

	Test(){
		// Setting the index controls which resttemplate method gets called.
		int index = 6;
		
		switch(index) {
		case 1: 
			getForEntity();
			break;
			
		case 2: 	
			getForObject();
			break;
			
		case 3:
			postForObject();
			break;
		
		case 4:
			postForLocation();
			break;
			
		case 5:
			put();
			break;
			
		case 6:
			delete();
			break;
			
		case 7:
			patchObject();
			break;
			
		case 8:
			patchString();
		}
		
		System.out.println("*** End");
	}
	
	void getForEntity() {
		RestTemplate restTemplate = getRestTemplate();
		String uri = "http://localhost:8080/getItem";
		ResponseEntity<Item> response = restTemplate.getForEntity(uri + "/1", Item.class);	
		Item item = response.getBody();		
		System.out.println("*** getForEntity item = " + item + "  status code = " + response.getStatusCode());
	}
	
	void getForObject() {
		RestTemplate restTemplate = getRestTemplate();
		String uri = "http://localhost:8080/getItemTwo?id=1";
		Item item = restTemplate
				  .getForObject(uri, Item.class);
		System.out.println("*** getForObject item = " + item);
	}	
	
	void postForObject() {
        try{
        	Map<String, String> vars = new HashMap<String, String>();
            vars.put("id", "6");
            RestTemplate rt = getRestTemplate();
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
            RestTemplate rt = getRestTemplate();
            String uri = "http://localhost:8080/postItemForObject/{id}";
            Item item = new Item();
            item.setName("frisbee");
            item.setPrice(12.0);
            item.setBrand("Whamo");            
            rt.postForLocation(uri, item, vars);
            System.out.println("postForLocation");
        }
        catch(Exception e){
            System.out.println("error:  " + e.getMessage());
        }
	}	
	
	void put() {
        try{
        	Map<String, String> vars = new HashMap<String, String>();
            vars.put("id", "7");
            RestTemplate rt = getRestTemplate();
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
            RestTemplate rt = getRestTemplate();
            String uri = "http://localhost:8080/delete/{id}";
            rt.delete(uri, vars);
        }
        catch(Exception e){
            System.out.println("error:  " + e.getMessage());
        }		
	}
	
	void patchObject() {
        try{
            RestTemplate rt = getRestTemplate();
            HttpClient httpClient = HttpClientBuilder.create().build();
            rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
            String uri = "http://localhost:8080/patchItemForObject/7";
            Item item = new Item();
            item.setName("frisbee");
            item.setPrice(4.0);
            item.setBrand("Whamo");
            rt.exchange(uri, HttpMethod.PATCH, getRequestHeaders(item), Void.class);
        }
        catch(Exception e){
            System.out.println("error:  " + e.getMessage());
        }
	}
	
	void patchString() {
        try{
            RestTemplate rt = getRestTemplate();
            String uri = "http://localhost:8080/patchItemForObject/7";
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "frisbee");
            jsonObject.put("price", "8.00");
            jsonObject.put("brand",  "Whamo");
            rt.exchange(uri, HttpMethod.PATCH, getRequestHeaders(jsonObject.toString()), Void.class);
        }
        catch(Exception e){
            System.out.println("error:  " + e.getMessage());
        }
	}	
	
	public RestTemplate getRestTemplate() {
        RestTemplate rt = new RestTemplate();
        HttpClient httpClient = HttpClientBuilder.create().build();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
        return rt;
	}
	
    public HttpEntity<Object> getRequestHeaders(Object body) {
        List<MediaType> acceptTypes = new ArrayList<MediaType>();
        acceptTypes.add(MediaType.APPLICATION_JSON_UTF8);
        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        reqHeaders.setAccept(acceptTypes);
        return new HttpEntity<Object>(body, reqHeaders);
    }	
}
