package com.test.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

@Component  
public class PasswordUtil { 
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String bcryptHash(String input) {
		return passwordEncoder.encode(input);
	}
	
	public boolean hashMatches(String pass, String dbPass) {
		return passwordEncoder.matches(pass,  dbPass);
	}
    
	private boolean loggedIn = false;
    
    public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
    
    public boolean checkPassword(String pass) {
    	String specialChar = "[~|`|!|@|#|$|%|^|&|*|(|)|_|\\-|+|=|{|\\[|}|\\]|\\\\|:|;|\"|\'|<|,|>|\\.|?|/]";
    	boolean specialCharFound = findPattern(pass, specialChar);
    	String upperAlpha = "[A-Z]";
    	boolean upperAlphaFound = findPattern(pass, upperAlpha);
    	String lowerAlpha = "[a-z]";
    	boolean lowerAlphaFound = findPattern(pass, lowerAlpha);
       	String numberPattern = "\\d";
    	boolean numberPatternFound = findPattern(pass, numberPattern);   
    	boolean isEightPositions = pass.length() >= 8;
    	
    	if(specialCharFound && upperAlphaFound && lowerAlphaFound && numberPatternFound && isEightPositions) {
    		return true;
    	}
    	
    	return false;
    }
	
	boolean findPattern(String text, String pattern) {
        Pattern pattrn = Pattern.compile(pattern);
        Matcher matcher = pattrn.matcher(text);
        
        while(matcher.find()) {
            return true;
        }		
        
        return false;
	}	
} 