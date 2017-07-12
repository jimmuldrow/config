package com.citi.cards.fraudtransactions.restfulwebservices;

public class FraudInfo {		
	
	private String merchantState;
	private String transactionAmount;
	private String transactionDate;
	private String merchantName;
	private String merchantCountry;	
	
	@Override
	public String toString() {
		return "FraudInfo [merchantState=" + merchantState
				+ ", transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate
				+ ", merchantName=" + merchantName + ", merchantCountry=" + merchantCountry + "]";
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
