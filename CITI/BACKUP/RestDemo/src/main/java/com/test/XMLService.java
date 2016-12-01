package com.test;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.*;

@Path("xmlservice")
public class XMLService {
	
	@Path("personlistxml")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getPeopleXml(){	
		return new ParserUtil<People>().objectToXmlString(getPersonList(),  People.class);
	}
	
	@Path("personlistjson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getPeopleJson(){		
		return  new ParserUtil<People>().objectToJsonString(getPersonList());
	}	
	
	private People getPersonList(){
		People people = new People();
		people.setId(423847);
		Person person = new Person("Bob", "White", LocalDate.of(1968,  11,  21), "287467376");
		people.addPerson(person);
		person = new Person("Jane", "Green",LocalDate.of(1972,  4,  3) , "479012784");
		people.addPerson(person);	
		person = new Person("George", "Johnson",LocalDate.of(1952,  9,  11), "379038467");
		people.addPerson(person);
		person = new Person("Lisa", "Lang",LocalDate.of(1978,  5, 14), "854287630");
		people.addPerson(person);			
		return people;
	}
}
