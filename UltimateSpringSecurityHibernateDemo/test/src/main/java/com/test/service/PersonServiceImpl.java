package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.PersonDao;
import com.test.model.CreditCard;
import com.test.model.Person;
import com.test.dao.CreditCardDao;
 
@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {
 
    @Autowired
    private PersonDao dao;
     
    public Person get(int id) {
        return dao.findById(id);
    }
 
    public void add(Person person) {
        dao.savePerson(person);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void edit(Person person) {
        Person entity = dao.findById(person.getId());
        if(entity!=null){
            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setMoney(person.getMoney());
            entity.setCustomerType(person.getCustomerType());
            entity.setBirthDate(person.getBirthDate());
         }
    }
 
    public void delete(int id) {
        dao.deletePersonById(id);
    }
     
    public List<Person> getAll() {
        return dao.findAllPeople();
    }
}

