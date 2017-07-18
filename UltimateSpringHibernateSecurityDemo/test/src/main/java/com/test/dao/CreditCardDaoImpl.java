package com.test.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test.model.CreditCard;
import com.test.model.Person;
 
@Repository("creditCardDao")
public class CreditCardDaoImpl extends AbstractDao<Integer, CreditCard> implements CreditCardDao { 
    public CreditCard findById(int id) {
        return getByKey(id);
    }
    
    @SuppressWarnings("unchecked")
    public List<CreditCard> getAll(){
        return (List<CreditCard>) createEntityCriteria().list();    	
    }
    
    public void saveCreditCard(int personId, CreditCard creditCard) {
		getSession().save(creditCard);
		Person existingPerson = (Person) getSession().get(Person.class, personId);
		existingPerson.getCreditCards().add(creditCard);
		getSession().save(existingPerson);
    }
 
    public void deleteCreditCardById(Integer id) {
    	Query query = getSession().createSQLQuery("DELETE FROM PERSON_CREDIT_CARD " +
    			"WHERE creditCards_ID="+id);
    	
    	query.executeUpdate();
		CreditCard creditCard = (CreditCard) getSession().get(CreditCard.class, id);
		getSession().delete(creditCard);
    }
 
    @SuppressWarnings("unchecked")
    public List<CreditCard> findAllCreditCards(int personId) {
		Query query = getSession().createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+personId);		
		Person person = (Person) query.uniqueResult();		
		return  new ArrayList<CreditCard>(person.getCreditCards());
    }
    
    /*
	public List<CreditCard> getAll() {
		Query query = getSession().createQuery("FROM  CreditCard");
		return  query.list();
	}  
	*/      
}