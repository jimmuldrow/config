package com.citi.cards.fraudtransactions.restfulwebservices;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {	
	
	@JsonProperty("AOFraudTransactions")
	private List<FraudTransaction> aOFraudTransactions = new ArrayList<FraudTransaction>();
	
	public Response(){}

	protected Response(List<FraudTransaction> aOFraudTransactions) {
		this.aOFraudTransactions = aOFraudTransactions;
	}

	public List<FraudTransaction> fetchAOFraudTransactions() {
		return aOFraudTransactions;
	}
}
