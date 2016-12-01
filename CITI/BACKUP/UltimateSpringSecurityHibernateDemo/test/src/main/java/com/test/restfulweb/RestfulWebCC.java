package com.test.restfulweb;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.test.dto.PersonDTO;
import com.test.model.Person;
import com.test.model.CreditCard;
import com.test.service.CreditCardService;
import com.test.service.PersonService;
import com.test.utilities.AES;

@RestController
public class RestfulWebCC {
	@Autowired
	private PersonService personService;
	
	@Autowired
	private CreditCardService creditCardService;	
	
    @RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonDTO>> listAllUsers() {
    	List<Person> people = personService.getAll();
    	List<PersonDTO> peopleDTO = new ArrayList<PersonDTO>();

    	for (Person person: people) {
     		PersonDTO dto = new PersonDTO();    		
			dto.setId(person.getId());
			dto.setFirstName(person.getFirstName());
			dto.setLastName(person.getLastName());
			dto.setMoney(person.getMoney());
			dto.setCustomerType(person.getCustomerType());
			List<CreditCard> creditCardList = creditCardService.getAll(person.getId());
			List<CreditCard> creditCardListTwo = new ArrayList<CreditCard>();
			
			for(CreditCard creditCard: creditCardList){
				creditCard.setNumber(AES.decrypt(creditCard.getNumber()));
				creditCardListTwo.add(creditCard);
			}			
			
			dto.setCreditCards(creditCardListTwo);			
			dto.setBirthDate(person.getBirthDate());			
			peopleDTO.add(dto);
    	}  
 
        if(peopleDTO.isEmpty()){
            return new ResponseEntity<List<PersonDTO>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<PersonDTO>>(peopleDTO, HttpStatus.OK);
    }	
}
