package com.test;

import com.test.base.Struts2Action;
import com.test.base.UserForm;

public class WelcomeUserAction extends Struts2Action{
	private static final long serialVersionUID = 1L;
	
	private UserForm userForm = new UserForm();

	public UserForm getUserForm() {
		return userForm;
	}
	
	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}

	public String welcome() {
		return "welcome, " + userForm.getUserName();
	}
	
	public void validate(){
	    if (userForm.getUserName().length() == 0 ){ 	 
	        addFieldError( "userForm.userName", "User name is required." );	         
	    }
	    
	    if (userForm.getPassword().length() == 0 ){ 	 
	        addFieldError( "userForm.password", "Password is required." );	         
	    }	
	}
}