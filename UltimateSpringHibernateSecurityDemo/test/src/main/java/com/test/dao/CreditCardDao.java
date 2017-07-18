package com.test.dao;

import java.util.List;

import com.test.model.CreditCard;

public interface CreditCardDao {
	
    CreditCard findById(int id);
    
    List<CreditCard> getAll();
    
    void saveCreditCard(int personId, CreditCard creditCard);
     
    void deleteCreditCardById(Integer id);
     
    List<CreditCard> findAllCreditCards(int personId);
}
