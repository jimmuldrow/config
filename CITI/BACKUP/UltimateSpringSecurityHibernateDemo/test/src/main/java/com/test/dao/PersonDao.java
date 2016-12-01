package com.test.dao;

import java.util.List;

import com.test.model.Person;

public interface PersonDao {
	
    Person findById(int id);
    
    void savePerson(Person creditCard);
     
    void deletePersonById(int id);
     
    List<Person> findAllPeople();
}
