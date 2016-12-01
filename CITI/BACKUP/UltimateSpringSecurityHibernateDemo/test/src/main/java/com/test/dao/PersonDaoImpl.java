package com.test.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test.model.CreditCard;
import com.test.model.Person;
 
@Repository("personDao")
public class PersonDaoImpl extends AbstractDao<Integer, Person> implements PersonDao {
	public Person findById(int id){
		return getByKey(id);
	}
	
    @SuppressWarnings("unchecked")
    public List<Person> findAllPeople() {
        return (List<Person>) createEntityCriteria().list();
    }    

    public void savePerson(Person person) {
        persist(person);
    }
    
    public void deletePersonById(int id){
    	delete(getByKey(id));
    }    
    
	/*
    public Person findById(int id) {
		Query query = getSession().createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+id);		
		return (Person) query.uniqueResult();
    }
    */    
    
    /*
    public void deletePersonById(String id) {
		Query query = getSession().createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+id);
		Person person = (Person) query.uniqueResult();
		Set<CreditCard> creditCards =person.getCreditCards();
		getSession().delete(person);
		
		for (CreditCard creditCard: creditCards) {
			getSession().delete(creditCard);
		}
    }
    */    
}
