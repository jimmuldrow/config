package com.test;

import org.springframework.web.client.RestTemplate;
import java.net.URI;

public class BatchCrudUtil<T> {	
	@SuppressWarnings("unchecked")
	public T getObject(String endpoint, T t){return (T) new RestTemplate().getForObject(endpoint,  t.getClass());}
	public URI postObject(String endpoint, T t){return new RestTemplate().postForLocation(endpoint,  t, t.getClass());}
	public void putObject(String endpoint, T t){new RestTemplate().put(endpoint, t);}
	public void deleteObject(String endpoint){new RestTemplate().delete(endpoint);}
}
