
package com.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CustomerService", targetNamespace = "http://test.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerService {


    /**
     * 
     * @param zip
     * @param last
     * @param streetAddressTwo
     * @param city
     * @param streetAddressOne
     * @param state
     * @param first
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCustomer", targetNamespace = "http://test.com/", className = "com.test.GetCustomer")
    @ResponseWrapper(localName = "getCustomerResponse", targetNamespace = "http://test.com/", className = "com.test.GetCustomerResponse")
    @Action(input = "http://test.com/CustomerService/getCustomerRequest", output = "http://test.com/CustomerService/getCustomerResponse")
    public String getCustomer(
        @WebParam(name = "first", targetNamespace = "")
        String first,
        @WebParam(name = "last", targetNamespace = "")
        String last,
        @WebParam(name = "streetAddressOne", targetNamespace = "")
        String streetAddressOne,
        @WebParam(name = "streetAddressTwo", targetNamespace = "")
        String streetAddressTwo,
        @WebParam(name = "city", targetNamespace = "")
        String city,
        @WebParam(name = "state", targetNamespace = "")
        String state,
        @WebParam(name = "zip", targetNamespace = "")
        String zip);

}
