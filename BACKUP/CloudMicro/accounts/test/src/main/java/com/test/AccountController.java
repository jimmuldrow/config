package com.test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;

@RestController
public class AccountController {
	public AccountController(){
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setBalance(new BigDecimal("843274.47"));
		accountDTO.setId(1);
		accountDTO.setNumber("123456789");
		accountDTO.setOwner("Bob");
		accountMap.put(accountDTO.getId(), accountDTO);
		
		accountDTO = new AccountDTO();
		accountDTO.setBalance(new BigDecimal("423487.73"));
		accountDTO.setId(2);
		accountDTO.setNumber("234567890");
		accountDTO.setOwner("Sally");
		accountMap.put(accountDTO.getId(), accountDTO);		
		
		accountDTO = new AccountDTO();
		accountDTO.setBalance(new BigDecimal("68423.94"));
		accountDTO.setId(3);
		accountDTO.setNumber("345678901");
		accountDTO.setOwner("Jane");
		accountMap.put(accountDTO.getId(), accountDTO);			
	}
	
	Map<Integer, AccountDTO> accountMap = new HashMap<Integer, AccountDTO>();	
    
	@RequestMapping(value="/accountById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountDTO byId(@PathVariable("id") String id) {
		int i = Integer.parseInt(id);
		return accountMap.get(i);
	}	
}