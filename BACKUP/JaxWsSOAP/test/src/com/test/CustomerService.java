package com.test;
 
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
 
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) 
public class CustomerService {
 
 
    @WebMethod(operationName = "getCustomer")
    public String getCustomer(
    		@WebParam(name="first") String first,
    		@WebParam(name="last") String last,
    		@WebParam(name="streetAddressOne") String streetAddressOne,
    		@WebParam(name="streetAddressTwo") String streetAddressTwo,
    		@WebParam(name="city") String city,
    		@WebParam(name="state") String state,
    		@WebParam(name="zip") String zip
    		){
 
    	ParserUtil<Customer> parserUtil = new ParserUtil<Customer>();
        Customer customer = new Customer();
        customer.setFirst(noNull(first));
        customer.setLast(noNull(last));
        customer.setStreetAddressOne(noNull(streetAddressOne));
        customer.setStreetAddressTwo(noNull(streetAddressTwo));
        customer.setCity(noNull(city));
        customer.setState(noNull(state));
        customer.setZip(noNull(zip));
        return parserUtil.objectToXmlString(customer,  Customer.class); 
    }
    
    private String noNull(String s){return ((s == null) ? "" : s.trim());}
}