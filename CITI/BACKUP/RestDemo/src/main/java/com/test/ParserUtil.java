package com.test;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.glassfish.jersey.client.ClientConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.xml.bind.Unmarshaller;  
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	public T xmlRequestToObject(HttpServletRequest request, @SuppressWarnings("rawtypes") Class c){
		try {
			String s = inputStreamToString(request.getInputStream());
			return xmlStringToObject(c, s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}		
	
	public String objectToJsonString(T t){
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(t);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		return null;
	}
	
	public void objectToJsonFile(T t, String jsonPath){
		ObjectMapper mapper = new ObjectMapper();

		try {
			mapper.writeValue(new File(jsonPath), t);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("unchecked")
	public T jsonStringToObject(String jsonString, @SuppressWarnings("rawtypes") Class c){
		ObjectMapper mapper = new ObjectMapper();

		try {
			return (T)  mapper.readValue(jsonString, c);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T jsonFileToObject(String jsonPath, @SuppressWarnings("rawtypes") Class c){
		ObjectMapper mapper = new ObjectMapper();

		try {
			return (T) mapper.readValue(new File(jsonPath), c);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	public T jsonRequestToObject(HttpServletRequest request, @SuppressWarnings("rawtypes") Class c){
		try {
			String s = inputStreamToString(request.getInputStream());
			return jsonStringToObject(s, c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}	
	
	public String inputStreamToString(InputStream is) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    String line;
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    
	    while ((line = br.readLine()) != null) {
	        sb.append(line);
	    }
	    
	    br.close();
	    return sb.toString();
	}
	
	public String getGETWebServiceString(String webServiceURL, String mediaType){		
		Client client = ClientBuilder.newClient(new ClientConfig());
		WebTarget webTarget = client.target(webServiceURL);		 
		Invocation.Builder invocationBuilder =  webTarget.request(mediaType);
		Response response = invocationBuilder.get();
		return response.readEntity(String.class);
	}
	
	public T getGETWebServiceObject(String webServiceURL, @SuppressWarnings("rawtypes") Class c, String mediaType){		
		Client client = ClientBuilder.newClient(new ClientConfig());
		WebTarget webTarget = client.target(webServiceURL);		 
		Invocation.Builder invocationBuilder =  webTarget.request(mediaType);
		Response response = invocationBuilder.get();
		@SuppressWarnings("unchecked")
		T t = (T) response.readEntity(c);
		return t;
	}	
	
	public String getPOSTWebServiceString(String webServiceURL, T t, String mediaType){
		Client client = ClientBuilder.newClient(new ClientConfig());
		WebTarget webTarget = client.target(webServiceURL);		 
		Invocation.Builder invocationBuilder =  webTarget.request(mediaType);
		Response response = invocationBuilder.post(Entity.entity(t, mediaType));
		return response.readEntity(String.class);
	}
	
	public T getPOSTWebServiceObject(String webServiceURL, T t, @SuppressWarnings("rawtypes") Class c, String mediaType){
		Client client = ClientBuilder.newClient(new ClientConfig());
		WebTarget webTarget = client.target(webServiceURL);		 
		Invocation.Builder invocationBuilder =  webTarget.request(mediaType);
		Response response = invocationBuilder.post(Entity.entity(t, mediaType));
		@SuppressWarnings("unchecked")
		T t2 = (T) response.readEntity(c);
		return t2;		
	}	
}
