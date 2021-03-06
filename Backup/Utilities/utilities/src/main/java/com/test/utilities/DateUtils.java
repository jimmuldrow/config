package com.test.utilities;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import com.test.enums.DateType;

@Component
public class DateUtils {

	public String formatUSDateFromYMD(String aDate) {
		return formatDate(aDate, DateType.YMD, "eeee, MMMM dd, yyyy", Locale.US);
	}

	public String formatDate(String aDate, DateType dateType, String pattern, Locale locale) {
		LocalDate localDate = getLocalDateFromString(aDate, dateType);		
		if(localDate == null){return "";}
		return formatDate(localDate, pattern, locale);
	}
	
	public String formatDate(LocalDate localDate, String pattern, Locale locale) {
		if(localDate != null){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			formatter.withLocale(locale);
			return localDate.format(formatter);
		} 
		
		return "";
	}	

	public LocalDate getLocalDateFromString(String aDate, DateType dateType) {
		aDate = aDate.replace("/", "-");
		int y = 0;
		int m = 0;
		int d = 0;

		if (aDate.matches("(\\d){1,4}-(\\d){1,4}-(\\d){1,4}")) {
			String[] dateSplit = aDate.split("-");
			String y1 = "0";
			String m1 = "0";
			String d1 = "0";

			switch (dateType) {
				case MDY: {
					y1 = dateSplit[2];
					m1 = dateSplit[0];
					d1 = dateSplit[1];
					break;
				}

				case DMY: {
					y1 = dateSplit[2];
					m1 = dateSplit[1];
					d1 = dateSplit[0];
					break;
				}

				case YMD: {
					y1 = dateSplit[0];
					m1 = dateSplit[1];
					d1 = dateSplit[2];
				}
			}

			y = Integer.parseInt(y1);
			m = Integer.parseInt(m1);
			d = Integer.parseInt(d1);
		}

		try {
			return LocalDate.of(y, m, d);
		}
		catch(Exception e){
			return null;
		}
	}
}	