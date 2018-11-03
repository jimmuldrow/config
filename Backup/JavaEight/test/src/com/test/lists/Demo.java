package com.test.lists;
import java.util.*;
import java.util.stream.Collectors;


public class Demo {
	
	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		list.add("b");
		list.add("a");
		list.add("c");
		
		list.sort( ( e1, e2 ) -> e1.compareTo(e2));		
		list.forEach( e -> System.out.print(e + " "));
		System.out.println("");
		
		System.out.println("============================================================");		
		
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());	
		filtered.forEach( e -> System.out.print(e + " ") );
		


	}

}
