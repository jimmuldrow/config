package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import hello.repository.UserRepository;
import hello.repository.CreditCardRepository;
import org.springframework.stereotype.Service;
import hello.model.User;
import hello.model.CreditCard;
import java.util.Optional;

@Service
public class ServiceApp {
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	public void createOrUpdateUser(User user) {
		userRepository.save(user);
	}
	
	public User retrieveOneUser(int id) {
		Optional<User> oUser = userRepository.findById(id);
		return oUser.orElse(new User());
	}
	
	public Iterable<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
	
	public void createOrUpdateCreditCard(CreditCard creditCard) {
		creditCardRepository.save(creditCard);
	}	
	
	public CreditCard retrieveOneCreditCard(int id) {
		Optional<CreditCard> oCreditCard = creditCardRepository.findById(id);
		return oCreditCard.orElse(new CreditCard());
	}	
	
	public Iterable retrieveAllCreditCards() {
		return creditCardRepository.findAll();
	}	
	
	public void deleteCreditCardById(int id) {
		creditCardRepository.deleteById(id);
	}	
}
