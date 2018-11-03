package com.test;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;

@RibbonClient(name = "ACCOUNTS-SERVICE", configuration = WebAccountsService.class)
@Service
public class WebAccountsService {
	/*
	 * @LoadBananced and @RibbonClient annotations work with ACCOUNTS-SERVICE for the application name.
	 */
	

	@Autowired
	@LoadBalanced	
	RestTemplate restTemplate;

	protected Logger logger = Logger.getLogger(WebAccountsService.class.getName());

	public WebAccountsService() {
	}

	@Cacheable("Accounts")
	@HystrixCommand(fallbackMethod = "populateAccountDefaultMethod", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000") })
	public Account findById(String id) {
		Account accountDTO = restTemplate.getForObject("http://ACCOUNTS-SERVICE/getAccountById/" + id, Account.class);
		//AccountDTO accountDTO = restTemplate.getForObject("http://localhost:2222/getAccountById/" + id, AccountDTO.class, id);
		logger.info("findById attempted");
		return accountDTO;
	}

	Account populateAccountDefaultMethod() {
		return new Account();
	}
	
	public void postToAccount(Account account){
		HttpEntity<Account> request = new HttpEntity<>(account);
		restTemplate.postForLocation("http://ACCOUNTS-SERVICE/postAccount", request, Account.class);
	}
	
	public void putToAccount(Account account){
		HttpEntity<Account> request = new HttpEntity<>(account);
		restTemplate.exchange("http://ACCOUNTS-SERVICE/putAccount", HttpMethod.PUT, request, Void.class);	
	}	
	
	public void deleteFromAccountById(String id){
        String url = "http://ACCOUNTS-SERVICE/deleteAccountById/" + id;
        restTemplate.delete(url);
 	}		
	
	public ConfigDTO getConfigurations() {
		logger.info("Get Configurations");
		return restTemplate.getForObject("http://ACCOUNTS-SERVICE/config", ConfigDTO.class);
		//return restTemplate.getForObject("http://localhost:2222/config", ConfigDTO.class);
	}
}
