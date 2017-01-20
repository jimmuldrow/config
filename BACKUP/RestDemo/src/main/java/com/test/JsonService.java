package com.test;

import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Path("jersey")
public class JsonService {
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("verifydate")
	@POST
	public String dates(@Context HttpServletRequest request, @Context SecurityContext securityContext){		
		DateUtil dateUtil = new DateUtil();
		ParserUtil<TestDate> parserUtil = new ParserUtil<TestDate>();
		TestDate testDate = parserUtil.jsonRequestToObject(request, TestDate.class);
		String m = noNull(testDate.getMonth());
		String d = noNull(testDate.getDay());
		String y = noNull(testDate.getYear());
		LocalDate localDate = dateUtil.setYmdDate(y + "-" +  m + "-" + d);				
		testDate.setIsDateValid((localDate == null) ? "false" : "true");
		return parserUtil.objectToJsonString(testDate);			
	}
	
	@Path("celsiustofahrenheit/{celsius}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String celsiusToFahrenheit(@PathParam("celsius") String cel){
		String s = noNull(cel);
		MathContext mc = new MathContext(2000, RoundingMode.HALF_UP);

		if(isDecimal(s)){
			BigDecimal bd1 = new BigDecimal(s);
			BigDecimal bd2 = new BigDecimal("32");
			BigDecimal bd3 = new BigDecimal("5");
			BigDecimal bd4 = new BigDecimal("9");
			BigDecimal bd5 = bd1.multiply(bd4, mc);
			BigDecimal bd6 = bd5.divide(bd3, mc);
			BigDecimal bd7 = bd6.add(bd2);
			BigDecimal bd8 = bd7.setScale(2, RoundingMode.HALF_UP);
			return bd8.toString();
		}
		
		return "N/A";
	}	
	
	@Path("fahrenheittocelsius/{fahrenheit}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String fahrenheitToCelsius(@PathParam("fahrenheit") String fah){
		String s = noNull(fah);
		MathContext mc = new MathContext(2000, RoundingMode.HALF_UP);

		if(isDecimal(s)){
			BigDecimal bd1 = new BigDecimal(s);
			BigDecimal bd2 = new BigDecimal("32");
			BigDecimal bd3 = new BigDecimal("5");
			BigDecimal bd4 = new BigDecimal("9");
			BigDecimal bd5 = bd1.subtract(bd2);
			BigDecimal bd6 = bd5.multiply(bd3,  mc);
			BigDecimal bd7 = bd6.divide(bd4, mc);
			BigDecimal bd8 = bd7.setScale(2, RoundingMode.HALF_UP);
			return bd8.toString();
		}
		
		return "N/A";
	}			
	
	private String noNull(String s){return ((s == null) ? "" : s.trim());}
	
	private final Pattern p1 = Pattern.compile("^(\\d){1,}$");
	private final Pattern p2 = Pattern.compile("^(\\d){1,}\\.(\\d){1,}$");

	public boolean isDecimal(String s){
		Matcher matcher1 = p1.matcher(s);
		Matcher matcher2 = p2.matcher(s);
		return(((matcher1.matches()) || (matcher2.matches())) ? true: false);
	}
}
