package com.test;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.time.format.FormatStyle;
import java.util.Locale;

import java.time.LocalDate;

@RestController
public class DateService {

    @RequestMapping(value="/validatedate", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DateTest> greeting(
    		@RequestParam(value="month") String month,
    		@RequestParam(value="day") String day,
    		@RequestParam(value="year") String year
    )
    {
    	DateTest dateTest = new DateTest();
    	DateUtil dateUtil= new DateUtil();
    	String m = noNull(month);
    	String d = noNull(day);
    	String y = noNull(year);    
    	
    	if((m == "") || (d == "") || (y == "")){
    		return new ResponseEntity<DateTest> (HttpStatus.NOT_FOUND);
    	}
    	
    	dateTest.setMonth(m);
    	dateTest.setDay(d);
    	dateTest.setYear(y);
    	String dt = y + "-" + m + "-" + d;
    	LocalDate localDate = dateUtil.setYmdDate(dt); 
    	
    	if(localDate != null){
    		dateTest.setIsDateValid("true");
    		dateTest.setDateInGerman(dateUtil.internationalDate(localDate, new Locale("de", "DE"), FormatStyle.FULL));
    	}
    	
    	return new ResponseEntity<DateTest>(dateTest, HttpStatus.OK);
    }
    
    private String noNull(String s){return ((s == null) ? "" : s.trim());}
}
