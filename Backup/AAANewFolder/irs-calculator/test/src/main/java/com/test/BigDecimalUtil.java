package com.test;

import java.text.NumberFormat;
import java.text.Format;
import java.util.Locale;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;

public class BigDecimalUtil {
	
	//  -1.0 first is less
	//   0.0 numbers are equal
	//   1.0 first is greater
	public double compareBd(String s1, String s2) {
		if((isNumeric(s1)) && (isNumeric(s2))) {
			BigDecimal bd1 = new BigDecimal(s1);
			BigDecimal bd2 = new BigDecimal(s2);
			return bd1.compareTo(bd2);
		}

		return -1;
	}
	
	public String addBd(String s1, String s2) {
		if((isNumeric(s1)) && (isNumeric(s2))) {
			BigDecimal bd1 = new BigDecimal(s1);
			BigDecimal bd2 = new BigDecimal(s2);
			return bd1.add(bd2).toString();
		}

		return null;
	}
	
	public String subtractBd(String s1, String s2) {
		if((isNumeric(s1)) && (isNumeric(s2))) {
			BigDecimal bd1 = new BigDecimal(s1);
			BigDecimal bd2 = new BigDecimal(s2);
			return bd1.subtract(bd2).toString();
		}

		return null;
	}	
	
	public String multiplyBd(String s1, String s2) {
		if((isNumeric(s1)) && (isNumeric(s2))) {
			BigDecimal bd1 = new BigDecimal(s1);
			BigDecimal bd2 = new BigDecimal(s2);
			return bd1.multiply(bd2).toString();
		}

		return null;
	}	
	
	public String divideBd(String s1, String s2) {
		if((isNumeric(s1)) && (isNumeric(s2))) {
			BigDecimal bd1 = new BigDecimal(s1);
			BigDecimal bd2 = new BigDecimal(s2);
			MathContext mc = new MathContext(1000, RoundingMode.HALF_UP);
			return bd1.divide(bd2, mc).toString();
		}

		return null;
	}		

	public String formatUSCurrency(String s) {
		return formatCurrency(s, Locale.US);
	}

	public String formatCurrency(String s, Locale locale) {
		if(isNumeric(s)) {
			Format format = NumberFormat.getCurrencyInstance(locale);
			return format.format(Double.parseDouble(s));
		}

		return null;
	}
	
	public boolean isNumeric(String s) {
		if(s == null) {return false;}
		return ((s.matches("[+|-]?(\\d){1,}")) || (s.matches("[+|-]?(\\d){1,}\\.(\\d){1,}")));
	}
}
