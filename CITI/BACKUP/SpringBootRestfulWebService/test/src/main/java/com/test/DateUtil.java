package com.test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateUtil {
	public LocalDate getCurrentDate(){
		return LocalDate.now();
	}
	
	public LocalDate setMdyDate(String mdyDate){
		String[] s2 = split(mdyDate);		

		if(s2.length == 3){
			return setYmdDate(s2[2] + "-" +  s2[0] + "-" + s2[1]);
		}

		return null;
	}
	
	public LocalDate setDmyDate(String dmyDate){
		String[] s2 = split(dmyDate);		

		if(s2.length == 3){
			return setYmdDate(s2[2] + "-" +  s2[1] + "-" + s2[0]);
		}
		
		return null;
	}	

	public LocalDate setYmdDate(String ymdDate){
		String[] s2 = split(ymdDate);

		if(s2.length == 3){
			String y1 = s2[0];
			String m1 = s2[1];
			String d1 = s2[2];
			int y2 = 0;
			int m2 = 0;
			int d2 = 0;				
			if(isInteger(y1)){y2 = Integer.parseInt(y1);}
			if(isInteger(m1)){m2 = Integer.parseInt(m1);}
			if(isInteger(d1)){d2 = Integer.parseInt(d1);}
			return setDate(y2, m2, d2);
		}
		
		return null;
	}	
	
	private String[] split(String s){
		s = noNull(s);
		String[] s2 = {"0", "0", "0"};
		
		if(!s.equals("")){
			String delim = "-";
			int i = s.indexOf("/");
			if(i > -1){delim = "/";}
			s2 = s.split(delim);			
		}

		return s2;
	}	

	public LocalDate setDate(int y, int m, int d){
		if((y > 1500) && (y < 2500)){
			try{
				return LocalDate.of(y,  m,  d);
			}
			catch(Exception e){
				return null;
			}			
		}
		
		return null;
	}	
	
	public LocalDate addDays(LocalDate start, int daysAdded){
		 return start.plus(daysAdded, ChronoUnit.DAYS);
	}
	
	public LocalDate addWeeks(LocalDate start, int weeksAdded){
		 return start.plus(weeksAdded, ChronoUnit.WEEKS);
	}
	
	public LocalDate addMonths(LocalDate start, int monthsAdded){
		 return start.plus(monthsAdded, ChronoUnit.MONTHS);
	}	
	
	public LocalDate addYears(LocalDate start, int yearsAdded){
		 return start.plus(yearsAdded, ChronoUnit.YEARS);
	}	
	
	public long getPeriodInDays(LocalDate date1, LocalDate date2){
		return ChronoUnit.DAYS.between(date1, date2);
	}
	
	public String formatDate(LocalDate localDate, String pattern){
		try{
			DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern(pattern);		
			return dateTimeFormatter1.format(localDate);		
		}
		catch(Exception e){
			return "ERROR";
		}
	}
	
	public String internationalDate(LocalDate localDate, Locale locale, FormatStyle formatStyle){
		try{
			DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDate(formatStyle).withLocale(locale);
			return fmt.format(localDate);	
		}
		catch(Exception e){
			return "ERROR";
		}
	}	
	
	private String noNull(String s){return ((s == null) ? "" : s.trim());}	
	
	private final Pattern p = Pattern.compile("^(\\d){1,}$");
	
	private boolean isInteger(String s){
		return p.matcher(s).matches();
	}	
}
