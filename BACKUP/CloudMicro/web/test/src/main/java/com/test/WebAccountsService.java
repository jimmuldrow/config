package com.test;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebAccountsService {
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;
	protected static final String serviceUrl = "http://ACCOUNTS-SERVICE";
	protected Logger logger = Logger.getLogger(WebAccountsService.class.getName());
	public WebAccountsService() {}

	public AccountDTO findById(String id) {
		logger.info("findByNumber() invoked: for " + id);
		return restTemplate.getForObject(serviceUrl + "/accountById/{id}",
				AccountDTO.class, id);
	}	
}
