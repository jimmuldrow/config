package com.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import javax.servlet.http.HttpServletRequest;
import org.springframework.cache.annotation.Cacheable;

import java.util.*;

@RestController
public class RestDemo {
	
	@Autowired
	Util util;
	
	public RestDemo() {
	}
	
	@RequestMapping(value = "/getItem/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Cacheable("items")
	public ResponseEntity<Item> getItem(@PathVariable("id") String id) {
		if(util.itemMap.containsKey(id)) {
			Item item =  util.itemMap.get(id);
			return new ResponseEntity<Item>(item, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Item>(new Item(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/getItemTwo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Cacheable("items")
	public Item getItemTwo(@RequestParam(required = false, defaultValue = "1") String id) {
		if (id == null) {
			return util.itemMap.get("1");
		}

		return util.itemMap.get("" + id);
	}

	@RequestMapping(value = "/getAllItems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Cacheable("items")
	public Map getAllItems() {
		return util.itemMap;
	}

	@RequestMapping(value="/setHeaders/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> setHeaders(@PathVariable String id) {
		String getResponseURL = "http://localhost:8080/getHeaders";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("SID", id);		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		HttpEntity entity = new HttpEntity(headers);
		ParameterizedTypeReference<List<AccountsProfile>>  parameterizedTypeReference = 
			    new ParameterizedTypeReference<List<AccountsProfile>>(){};		
		ResponseEntity<List<AccountsProfile>> response = (ResponseEntity<List<AccountsProfile>>) new RestTemplate().exchange(getResponseURL, HttpMethod.GET, entity, parameterizedTypeReference);	
		List<AccountsProfile> aList = response.getBody();
		
		ObjectMapper mapper = new ObjectMapper();		
		String s2 = "";
		
		try {
			s2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}				
		
		if(s2.length() > 0){
			return new ResponseEntity<String>(s2, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>(s2, HttpStatus.NOT_FOUND);
		}		
	}
	
	@RequestMapping(value = "/getHeaders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<AccountsProfile>> getHeaders(HttpServletRequest request) {
		String id = request.getHeader("SID");
		System.out.println("****** ID = " + id);
		List<AccountsProfile> outList = new ArrayList<AccountsProfile>();
		
		for(AccountsProfile ap: util.accountsList) {
			if(id.equals(ap.getAccountId())) {
				outList.add(ap);
			}
		}
		
		return new ResponseEntity<List<AccountsProfile>>(outList, HttpStatus.OK);
	}

    @RequestMapping(value = "/postItemForObject/{id}", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String postItemForObject(@PathVariable("id") String id, @RequestBody Item item) {
    	if(util.itemMap.containsKey(id)) {
    		return "FAILURE";
    	}
    	else {
    		util.itemMap.put(id,  item);
    		return "SUCCESS";
    	}
    }
    
    @RequestMapping(value = "/putItemForObject/{id}", method = RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String putItemForObject(@PathVariable("id") String id, @RequestBody Item item) {
    	if(util.itemMap.containsKey(id)) {
    		util.itemMap.put(id,  item);
    		return "SUCCESS";
    	}
    	else {
    		return "FAILURE";
    	}
    }    
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
    	if(util.itemMap.containsKey(id)) {
    		util.itemMap.remove(id);
    	}
    }
    
    @RequestMapping(value = "/patchItemForObject/{id}", method = RequestMethod.PATCH, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String patchItemForObject(@PathVariable("id") String id, @RequestBody Item item) {
    	if(util.itemMap.containsKey(id)) {
    		util.itemMap.put(id,  item);
    		return "SUCCESS";
    	}
    	else {
    		return "FAILURE";
    	}
    }        
}
