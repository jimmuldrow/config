package com.test.dto;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.test.model.CreditCard;
import org.apache.log4j.Logger;

public class PersonDTO {

	private static final long serialVersionUID = -5527566248002296042L;
	
	protected static Logger logger = Logger.getLogger("controller");

	private Integer id;
	private String firstName;	
	private String lastName;
	private String money;
	private String customerType;
	private String birthDate;
	private List<CreditCard> creditCards;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	
	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}	
	
	public String getBirthDate(){
		return this.birthDate;
	}
	
	public void setBirthDate(String birthDate){
		this.birthDate = birthDate;
	}	
	
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", money=" + money
				+ ", customerType=" + customerType + ", birthDate=" + birthDate + ", creditCards=" + creditCards + "]";
	}	
}
