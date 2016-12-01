package com.test;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("Account")
public class AccountDTO {

	protected int id;
	protected String number;
	protected String owner;
	protected BigDecimal balance;
	protected String greeting;

	/**
	 * Default constructor for JPA only.
	 */
	protected AccountDTO() {
		balance = BigDecimal.ZERO;
	}

	public int getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	protected void setNumber(String accountNumber) {
		this.number = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	protected void setOwner(String owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	protected void setBalance(BigDecimal value) {
		balance = value;
		balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	@Override
	public String toString() {
		return number + " [" + owner + "]: $" + balance;
	}
	
	public String getGreeting(){
		return greeting;
	}

	public void setGreeting(String greeting){
		this.greeting = greeting;
	}
}
