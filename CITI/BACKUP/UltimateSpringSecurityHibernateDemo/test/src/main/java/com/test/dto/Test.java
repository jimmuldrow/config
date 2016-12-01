package com.test.dto;
import javax.validation.constraints.*;

public class Test {
	@Pattern.List({
	    @Pattern(regexp="(\\d){1,}"),
	    @Pattern(regexp="(\\d){1,}\\.(\\d){1,2}")
	})
	private String money = "";
	
	Test(){
		
	}	
	
	public static void main(String[] args){
		new Test();
	}
}
