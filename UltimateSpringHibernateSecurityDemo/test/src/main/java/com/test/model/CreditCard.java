package com.test.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size; 
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard {
	private static final long serialVersionUID = 5924361831551833717L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Size(min=2, max=50, message="Please select a valid card type from the list.")	
	@Column(name = "TYPE")
	private String type;
	
	@NotEmpty
	@Column(name = "NUMBER")
	private String number;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", type=" + type + ", number=" + number + "]";
	}
}
