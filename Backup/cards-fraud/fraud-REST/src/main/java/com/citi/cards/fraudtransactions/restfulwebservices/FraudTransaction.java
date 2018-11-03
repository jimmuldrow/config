package com.citi.cards.fraudtransactions.restfulwebservices;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FraudTransaction {
	@JsonProperty("MerchantState")
	private String merchantState;
	@JsonProperty("TransactionAmount")
	private String transactionAmount;
	@JsonProperty("TransactionDate")
	private String transactionDate;
	@JsonProperty("MerchantName")
	private String merchantName;
	@JsonProperty("MerchantCountry")
	private String merchantCountry;
	
	public FraudTransaction(){}
	
	protected FraudTransaction(String merchantState, String transactionAmount,
			String transactionDate, String merchantName, String merchantCountry) {
		super();
		this.merchantState = merchantState;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.merchantName = merchantName;
		this.merchantCountry = merchantCountry;
	}
	
	@Override
	public String toString() {
		return "FraudTransaction [merchantState=" + merchantState + ", transactionStatus="  + transactionAmount + 
				", transactionDate=" + transactionDate + ", merchantName=" + merchantName + ", merchantCountry="
				+ merchantCountry + "]";
	}
	public String getMerchantState() {
		return merchantState;
	}
	public void setMerchantState(String merchantState) {
		this.merchantState = merchantState;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getMerchantCountry() {
		return merchantCountry;
	}
	public void setMerchantCountry(String merchantCountry) {
		this.merchantCountry = merchantCountry;
	}
}
