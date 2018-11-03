package com.test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;

@RestController
public class AccountController {
	public AccountController(StoreRepository storeRepository, Config config){
		this.storeRepository = storeRepository;
		this.config = config;
		
		Account account = new Account();
		account.setBalance(new BigDecimal("843274.47"));
		account.setId(1);
		account.setNumber("123456789");
		account.setOwner("Bob");
		storeRepository.save(new Store("1", account));
		
		account = new Account();
		account.setBalance(new BigDecimal("423487.73"));
		account.setId(2);
		account.setNumber("234567890");
		account.setOwner("Sally");
		storeRepository.save(new Store("2", account));
		
		account = new Account();
		account.setBalance(new BigDecimal("68423.94"));
		account.setId(3);
		account.setNumber("345678901");
		account.setOwner("Jane");
		storeRepository.save(new Store("3", account));				
	}
	
    @Autowired
    StoreRepository storeRepository;	
	
	@Autowired
	private Config config;

	@RequestMapping(value="/getAccountById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Account getAccountById(@PathVariable("id") String id) {
		return (Account) storeRepository.findByKey(id).getValue();
	}	
	
	@RequestMapping(value="/postAccount", method = RequestMethod.POST)
	public void postAccount(@RequestBody Account account) {
		String id = "" + account.getId();

		if(storeRepository.exists(id) == false){
			Store store = new Store(id, account);
			storeRepository.save(store);		
		}
	}	
	
	@RequestMapping(value="/putAccount", method = RequestMethod.PUT)
	public void putAccount(@RequestBody Account account) {
		String id = "" + account.getId();
		
		if(storeRepository.exists(id) == true){
			Store store = new Store(id, account);
			storeRepository.save(store);			
		}
	}

	@RequestMapping(value="/deleteAccountById/{id}", method = RequestMethod.DELETE)
	public void deleteAccountById(@PathVariable("id") String id) {
		if(storeRepository.exists(id) == true){
			storeRepository.delete(id);	
		}
	}		

	@RequestMapping(value="/config", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ConfigDTO configGreeting() {
		return config.getConfigDTO();
	}		
}