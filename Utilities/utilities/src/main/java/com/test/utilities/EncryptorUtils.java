package com.test.utilities;

import org.springframework.stereotype.Component;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

@Component
public class EncryptorUtils {

    public String encrypt(String s){
    	IOUtils iOUtils = new IOUtils();
    	String k = iOUtils.getFileDataFromResources("temp.txt");
    	String salt = KeyGenerators.string().generateKey();
    	TextEncryptor encryptor = Encryptors.text(k, salt);  
    	return  salt + encryptor.encrypt(s);
    }
    
    public String decrypt(String s){
    	IOUtils iOUtils = new IOUtils();
    	String k = iOUtils.getFileDataFromResources("temp.txt");
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