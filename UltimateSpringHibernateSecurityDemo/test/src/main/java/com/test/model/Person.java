package com.test.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import com.test.customannotations.ISODateInPastEdit;

@Entity
@Table(name = "PERSON")
public class Person {

	private static final long serialVersionUID = -5527566248002296042L;
	
	protected static Logger logger = Logger.getLogger("controller");

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Size(min=2, max=25)
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@NotEmpty
	@Size(min=2, max=50)
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@NotEmpty(message="A dollar amount is required for the money field.")
	@Digits(integer=12, fraction=2, message="Please enter a dollar amount between 0.00 and 999999999999.99")
	@Column(name = "MONEY")
	private String money;
	
	@NotEmpty(message="A valid customer type must be selected")
	@Size(min=2, max=25)
	@Column(name = "CUSTOMER_TYPE")
	private String customerType;	
	
	@ISODateInPastEdit(message="Birth date is not a valid YYYY-MM-DD format date in the past.")
    @Column(name="BIRTH_DATE")
	private String birthDate;

	@OneToMany
	private Set<CreditCard> creditCards;
	
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

	public Set<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", money=" + money
				+ ", customerType=" + customerType + ", birthDate=" + birthDate + ", creditCards=" + creditCards + "]";
	}	
}
