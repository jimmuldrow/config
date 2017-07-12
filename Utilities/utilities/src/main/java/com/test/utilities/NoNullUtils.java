package com.test.utilities;

import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class NoNullUtils<T> {

	 public String noNull(String s){ 
		 return ((Optional.ofNullable(s)).orElse("")).trim(); 
	 }	 
	 
	 public T noNullNotString(T t, T nonNullT){
		 return ((Optional.ofNullable(t).orElse(nonNullT)));
	 }
}
