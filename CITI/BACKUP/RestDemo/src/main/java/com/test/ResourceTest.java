package com.test;

import javax.ws.rs.core.MediaType;
import org.junit.Test;
import static org.junit.Assert.*;
 

public class ResourceTest{
 

    @Test
    public void testGetIt() {
    	ParserUtil<String> parserUtil = new ParserUtil<String>();
    	String s = parserUtil.getGETWebServiceString("http://localhost:8080/test/webapi/jersey/fahrenheittocelsius/47", MediaType.TEXT_PLAIN);
        assertEquals("8.33", s);
    }
}