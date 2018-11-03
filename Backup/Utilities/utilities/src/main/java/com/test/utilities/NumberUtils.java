package com.test.utilities;

import org.springframework.stereotype.Component;
import java.text.NumberFormat;
import java.text.Format;
import java.util.Locale;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class NumberUtils {

	public String formatUSCurrency(String s) {
		return formatCurrency(s, Locale.US, RoundingMode.HALF_UP);
	}

	public String formatCurrency(String s, Locale locale, RoundingMode roundingMode) {
		s = s.replace(",", "");

		if ((s.matches("(\\d){1,}")) || (s.matches("(\\d){1,}\\.(\\d){1,}"))) {
			BigDecimal bd1 = new BigDecimal(s);
			BigDecimal bd2 = bd1.setScale(2, roundingMode);
			double d = Double.parseDouble(bd2.toString());
			Format format = NumberFormat.getCurrencyInstance(locale);
			return format.format(d);
		}

		return "$0.00";
	}
}