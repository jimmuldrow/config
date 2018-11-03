package hello.apicontroller;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import hello.model.User;
import hello.model.CreditCard;
import hello.service.ServiceApp;
import java.util.Date;
import java.util.Set;

@RestController    
@RequestMapping(path="/demo") 
public class MainController {
	@Autowired 
	private ServiceApp serviceApp;
	
	@GetMapping(path="/addUser") 
	public String addUser (@RequestParam String name
			, @RequestParam String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setCreatedAt(new Date());
		serviceApp.createOrUpdateUser(user);
		return "Saved";
	}
	
	@GetMapping(path="/addCreditCardForUser/{personId}/{accountNumber}") 
	public String addCreditCardForUser (@PathVariable String personId,
		   @PathVariable String accountNumber) {
		RestTemplate restTemplate = new RestTemplate();
		StringBuilder sb = new StringBuilder("http://localhost:8080/demo/oneUser/");
		sb.append(personId);
		String uri = sb.toString();
		User user = restTemplate
				  .getForObject(uri, User.class);
		CreditCard creditCard = new CreditCard();
		creditCard.setAccountNumber(accountNumber);
		Set<CreditCard> cards = user.getCreditCard();
		cards.add(creditCard);
		user.setCreditCard(cards);
		serviceApp.createOrUpdateCreditCard(creditCard);
		user.setUpdatedAt(new Date());
		serviceApp.createOrUpdateUser(user);
		return "Saved";
	}	
	
	@GetMapping(path="/oneUser/{id}")
	public User oneUser(@PathVariable String id) {
		try {
			int i = Integer.parseInt(id);
			return serviceApp.retrieveOneUser(i);
		}
		catch(Exception e) {
			System.out.println("******** oneUser ERROR = " + e);
			return new User();
		}
	}
	
	@GetMapping(path="/allUsers")
	public Iterable<User> allUsers() {
		return serviceApp.retrieveAllUsers();
	}
}
