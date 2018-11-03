package com.test.service;
import java.util.List;

import com.test.model.Person;

public interface PersonService {

    public Person get(int id);
 
    public void add(Person person);
 
    public void edit(Person person);
 
    public void delete(int id);
     
    public List<Person> getAll();
}
