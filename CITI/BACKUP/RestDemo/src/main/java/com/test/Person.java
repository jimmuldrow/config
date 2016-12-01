package com.test;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.fasterxml.jackson.annotation.JsonProperty;





@XmlType(propOrder = {"first", "last", "ssn", "birthDate"})
public class Person {
	
	public Person(){}
	
	public Person(String first, String last, LocalDate birthDate, String ssn){
		this.first = first;
		this.last = last;
		this.birthDate = birthDate;
		this.ssn = ssn;
	}
	
	
	@JsonProperty(value="firstName")
	private String first = "";	
	@JsonProperty(value="lastName")
	private String last = "";
	private LocalDate birthDate = null;
	private String ssn = "";
	
	@XmlAttribute(name="firstName") 
	public String getFirst(){return first;}
	public void setFirst(String first){this.first = first;}
	
	@XmlAttribute(name="lastName") 
	public String getLast(){return last;}
	public void setLast(String last){this.last = last;}
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)	
	public LocalDate getBirthDate(){return birthDate;}	
	public void setBirthDate(LocalDate birthDate){this.birthDate = birthDate;}

	@XmlElement(name="tin")
	public String getSsn(){return ssn;}
	public void setSsn(String ssn){this.ssn = ssn;}
}
