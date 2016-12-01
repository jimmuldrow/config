package com.test.dates;

import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Test {
	
	Test(){

		DateUtil dateUtil = new DateUtil();
		LocalDate localDate = dateUtil.setDate(2016,  6,  30);

		String s1 = dateUtil.formatDate(localDate, "MMM dd, yyyy");
		System.out.println(s1);
		
		String s2 = dateUtil.internationalDate(localDate,  Locale.FRENCH, FormatStyle.FULL);
		System.out.println(s2);
	}
	

	
	public static void main(String[] args) {
		new Test();
	}
}

