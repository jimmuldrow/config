package com.test;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
	DateUtil dateUtil = new DateUtil();
	
    public LocalDate unmarshal(String s) throws Exception {     	
    	return dateUtil.setMdyDate(s);
    }

    public String marshal(LocalDate localDate) throws Exception {
        return "" + localDate.getMonthValue() + "/" + localDate.getDayOfMonth() + "/" + localDate.getYear();
    }
}
