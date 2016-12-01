package com.test.optional;

import java.util.Optional;

public class NoNullDemo {
	
	public NoNullDemo(){		
		String sa = "abc";
		String sb = noNull(sa);
		System.out.println("111" + sb + "222");
		
		sa = null;
		sb = noNull(sa);
		System.out.println("111" + sb + "222");		
	}
	
	public String noNull(String s){return ((Optional.ofNullable(s)).orElse("")).trim();}
	
	public static void main(String[] args){
		new NoNullDemo();
	}
}
