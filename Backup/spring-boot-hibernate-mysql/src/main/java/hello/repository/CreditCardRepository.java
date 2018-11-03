package hello.repository;

import org.springframework.data.repository.CrudRepository;
import hello.model.CreditCard;

public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {

}
