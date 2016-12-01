package com.test;
import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;  
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@XmlRootElement(name="salesPeople")
public class People {
	
	private int id = 0;
	private List<Person> personList = new ArrayList<Person>(); 
	@JsonInclude(Include.NON_NULL)
	private List<Events> eventsList = null;

	@XmlAttribute(name="identification")
    public int getId(){return id;}    
    public void setId(int id){this.id = id;}	
    
    @XmlElement(name="person")
    public List<Person> getPersonList(){return personList;}    
    public void setPersonList(List<Person> personList){this.personList = personList;}
    public void addPerson(Person person){personList.add(person);}
        
    @XmlElement
    public List<Events> getEventsList(){return eventsList;}
    public void setEventsList(List<Events> eventsList){this.eventsList = eventsList;}
}
