package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import javax.servlet.http.HttpServletRequest;

import java.util.*;

@RestController
public class RestDemo {

	public RestDemo() {
	}
	
	@Autowired
	SimpleBookRepository sbr;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getItem() {
		System.out.println("Book = " + sbr.getByIsbn(1));
		System.out.println("Book = " + sbr.getByIsbn(2));
		System.out.println("Book = " + sbr.getByIsbn(1));
		System.out.println("Book = " + sbr.getByIsbn(3));
		System.out.println("Book = " + sbr.getByIsbn(4));
		System.out.println("Book = " + sbr.getByIsbn(1));
		System.out.println("Book = " + sbr.getByIsbn(1));
		return "success";
	}
}
