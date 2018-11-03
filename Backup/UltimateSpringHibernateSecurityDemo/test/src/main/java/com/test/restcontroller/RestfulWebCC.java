package com.test.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.test.mapping.Mapper;
import com.test.dto.PersonDTO;

@RestController
public class RestfulWebCC {

	@Autowired
	private Mapper mapper;
	
    @RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonDTO>> listAllUsers() {
    	return mapper.mapAllUsers();
    }	
}
