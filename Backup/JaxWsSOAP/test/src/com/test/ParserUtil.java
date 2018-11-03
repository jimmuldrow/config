package com.test;


import javax.xml.bind.Unmarshaller;  
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.io.FileOutputStream;

public class ParserUtil<T> {
	public String objectToXmlString(T t, @SuppressWarnings("rawtypes") Class c) {
	    String xmlString = "";
	    
	    try {
	        JAXBContext context = JAXBContext.newInstance(c);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        StringWriter sw = new StringWriter();
	        m.marshal(t, sw);
	        xmlString = sw.toString();
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }

	    return xmlString;
	}
	
	public void objectToXmlFile(T t, @SuppressWarnings("rawtypes") Class c, String xmlPath) {
	    try {
	        JAXBContext context = JAXBContext.newInstance(c);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	        try {
				m.marshal(t, new FileOutputStream(xmlPath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	}
	
	@SuppressWarnings("unchecked")
	public T xmlStringToObject(@SuppressWarnings("rawtypes") Class c, String xmlString){
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xmlString);
			return (T) unmarshaller.unmarshal(reader);
		} catch (JAXBException e1) {
			e1.printStackTrace();
			return null;
		}
	}	
	
	@SuppressWarnings("unchecked")
	public T xmlFileToObject(@SuppressWarnings("rawtypes") Class c, String xmlPath){
	     try {    
	    	 File file = new File(xmlPath);    
	    	 JAXBContext jaxbContext = JAXBContext.newInstance(c);
	    	 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 	            
	    	 return  (T) jaxbUnmarshaller.unmarshal(file);    
	     } catch (JAXBException e) {
	    	 e.printStackTrace(); 
	    	 return null;
	     }    		
	}
}
