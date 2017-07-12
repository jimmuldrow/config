package com.test.utilities;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class AES {
	private static String k = FileIO.getFileDataFromResources("temp.txt");
	
    public static String encrypt(String s){
    	String salt = KeyGenerators.string().generateKey();
    	TextEncryptor encryptor = Encryptors.text(k, salt);  
    	return  salt + encryptor.encrypt(s);
    }
    
    public static String decrypt(String s){
    	if(s.length() > 16){
        	String salt2 = s.substring(0, 16);
        	String therest = s.substring(16);
            TextEncryptor decryptor = Encryptors.text(k, salt2);
            return decryptor.decrypt(therest);   	
    	}
    	else{
    		return "0000";
    	}
    }
}