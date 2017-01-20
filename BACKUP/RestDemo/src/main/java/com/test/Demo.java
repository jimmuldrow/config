package com.test;

import java.time.LocalDate;
import java.util.*;

public class Demo {
	
	Demo(){
		ParserUtil<People> parserUtil = new ParserUtil<People>();
		People people1 = getPersonList();
		String s = parserUtil.objectToXmlString(people1, People.class);
		System.out.println(s);
		People people2 = parserUtil.xmlStringToObject(People.class, s);
		System.out.println("******* id = " + people2.getId());
		List<Person> personList = people2.getPersonList();
		
		for(Person person: personList){
			System.out.println("firstName = " + person.getFirst() + "   lastName = " + 
					person.getLast() + "   birthDate = " + person.getBirthDate() +  "   getTin = " + person.getSsn());
		}
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
	
	public static void main(String[] args){
		new Demo();
	}

}
