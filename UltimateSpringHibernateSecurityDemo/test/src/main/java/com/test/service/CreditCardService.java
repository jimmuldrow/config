package com.test.service;

import java.util.List;

import com.test.model.CreditCard;

public interface CreditCardService {
	
    CreditCard get(int id);
    
    void add(Integer personid, CreditCard creditCard);
    
    public void edit(CreditCard creditCard);
     
    void delete(Integer id);
     
    List<CreditCard> getAll(int personId);
}
