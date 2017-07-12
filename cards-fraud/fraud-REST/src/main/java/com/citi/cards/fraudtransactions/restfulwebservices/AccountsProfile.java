package com.citi.cards.fraudtransactions.restfulwebservices;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountsProfile implements Serializable{

	private static final long serialVersionUID = 1L;
	String accountId ;
	String accountNumber;
	String accountName ;
	String ewRefCode ;
	
	@Override
	public String toString() {
		return "AccountsProfile [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountName="
				+ accountName + ", ewRefCode=" + ewRefCode + "]";
	}
	
	public AccountsProfile(){}
	
	protected AccountsProfile(String accountId, String accountNumber, String accountName, String ewRefCode) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.ewRefCode = ewRefCode;
	}	
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getEwRefCode() {
		return ewRefCode;
	}
	public void setEwRefCode(String ewRefCode) {
		this.ewRefCode = ewRefCode;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}