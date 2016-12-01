package com.test;

import java.util.List;
import org.hibernate.*;
 
public class HibernateTest {
 
public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        session.beginTransaction(); 
        List<Bank> bankList  = (List<Bank>) session.createQuery("from Bank").list();
        
        for (Bank next : bankList) {
            System.out.println("next employee: " + next);
        } 
        
        HibernateUtil.shutdown();
    }    
}
