package com.citi.cards.fraudtransactions.restfulwebservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
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
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

@RestController
public class FraudWebServices {	
	FraudWebServices(){}
	public RestTemplate restTemplate = new RestTemplate();
	//String LisaURL = "https://sd-9ea5-6df7:8102/citiMobile/fraud/accounts/1234/getTransactions/";
	
	@RequestMapping(value = "/getFraudInfoById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getFraudInfoById(@PathVariable String id) {
		String lisaURL = "https://sd-9ea5-6df7:8102/citiMobile/fraud/accounts/" + id + "/getTransactions/";
		LisaResponse lisaResponse = new RestTemplate().getForObject(lisaURL, LisaResponse.class);
		Response response = lisaResponse.getResponse();		
		List<FraudTransaction> fraudTransactionList = response.fetchAOFraudTransactions();	
		List<FraudInfo> listById = new ArrayList<FraudInfo>();

		for(FraudTransaction fi: fraudTransactionList){
			FraudInfo fraudInfo = new FraudInfo();
			fraudInfo.setMerchantState(noNull(fi.getMerchantState()));
			fraudInfo.setTransactionAmount(noNull(fi.getTransactionAmount()));			
			String td = noNull(fi.getTransactionDate());			
			
			if(td.length() > 9){
				fraudInfo.setTransactionDate(td.substring(0, 10));
			}
			
			fraudInfo.setMerchantName(noNull(fi.getMerchantName()));
			fraudInfo.setMerchantCountry(noNull(fi.getMerchantCountry()));
			listById.add(fraudInfo);
		}

		Collections.sort(listById, (a, b) -> a.getTransactionDate().compareTo(b.getTransactionDate()));		
		ObjectMapper mapper = new ObjectMapper();		
		String s2 = "NOT_FOUND";
		
		try {
			s2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listById);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}		
		
		if(listById.size() > 0){
			return new ResponseEntity<String>(s2, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>(s2, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/getAccountProfiles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAccountProfiles(@PathVariable String id) {	
		@SuppressWarnings("unused")
		String url = "http://DGL-AM-V-AccountProfileWS-digital-nam-account-mgmt-dev1.cfapps-gcg-gtdc1.citipaas-dev.dyn.nsroot.net/CBOLUS/accountprofile";
		
		// Virtual version of the Account Profile Service (when you don't have coexistence)
		// Headers aren't needed for this url, but will be needed for more "real" tests
		String virtualizationURL = "http://sd-3ab0-e3a5.nam.nsroot.net:8101/CBOLUS/accountprofile";	
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("SID", id);		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		HttpEntity entity = new HttpEntity(headers);
		ParameterizedTypeReference<List<AccountsProfile>>  parameterizedTypeReference = 
			    new ParameterizedTypeReference<List<AccountsProfile>>(){};		
		ResponseEntity<List<AccountsProfile>> response = (ResponseEntity<List<AccountsProfile>>) restTemplate.exchange(virtualizationURL, HttpMethod.GET, entity, parameterizedTypeReference);
		List<AccountsProfile> apList = response.getBody();
		List<AccountsProfile> extract = new ArrayList<AccountsProfile>();
		
		for(AccountsProfile ap: apList){
			AccountsProfile apExtract = new AccountsProfile(ap.getAccountId(), ap.getAccountNumber(), ap.getAccountName(), ap.getEwRefCode());
			extract.add(apExtract);
		}
		
		ObjectMapper mapper = new ObjectMapper();		
		String s2 = "NOT_FOUND";
		
		try {
			s2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(extract);
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
	
	private String noNull(String s){return ((s == null) ? "" : s.trim());}
}
