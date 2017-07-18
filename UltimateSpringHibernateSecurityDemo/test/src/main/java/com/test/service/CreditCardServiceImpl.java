package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.PersonDao;
import com.test.model.CreditCard;
import com.test.model.Person;
import com.test.dao.CreditCardDao;
 
@Service("creditCardService")
@Transactional
public class CreditCardServiceImpl implements CreditCardService {
 
    @Autowired
    private CreditCardDao dao;
     
    public CreditCard get(int id) {
        return dao.findById(id);
    }
 
    public void add(Integer personId, CreditCard creditCard) {
        dao.saveCreditCard(personId, creditCard);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void edit(CreditCard creditCard) {
        CreditCard entity = dao.findById(creditCard.getId());
        if(entity!=null){
            entity.setType(creditCard.getType());
            entity.setNumber(creditCard.getNumber());
         }
    }
 
    public void delete(Integer id) {
        dao.deleteCreditCardById(id);
    }
     
    public List<CreditCard> getAll(int personId) {
        return dao.findAllCreditCards(personId);
    }
}


