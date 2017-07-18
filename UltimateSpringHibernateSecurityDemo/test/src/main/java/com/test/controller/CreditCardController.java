package com.test.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;
import com.test.model.CreditCard;
import com.test.service.CreditCardService;
import com.test.utilities.AES;


@Controller
@RequestMapping("/main/creditcard")
public class CreditCardController {
	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private CreditCardService creditCardService;
	
    /**
     * Retrieves the "Add New Credit Card" page
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(@RequestParam("id") Integer personId, Model model) {
    	logger.debug("Received request to show add page");
    	CreditCard creditCard = new CreditCard();
    	model.addAttribute("personId", personId);
    	model.addAttribute("creditCard", creditCard);
    	return "add-credit-card";
	}
 
    /**
     * Adds a new credit card
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@RequestParam("id") Integer personId, 
    							Model model,
    						    @Valid @ModelAttribute("creditCard") CreditCard creditCard, BindingResult result) {
		logger.debug("Received request to add new credit card");
		
        if (result.hasErrors()) {
        	model.addAttribute("personId", personId);
        	model.addAttribute("creditCard", creditCard);       	
            return "add-credit-card";
        }				
		
        creditCard.setNumber(AES.encrypt(creditCard.getNumber()));
		creditCardService.add(personId, creditCard);
		return "redirect:/listPersonCC";
	}
    
    
    /**
     * Deletes a credit card
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelete(@RequestParam("id") Integer creditCardId) {
    	logger.debug("Received request to delete credit card");
    
    	
    	// Delegate to service
		creditCardService.delete(creditCardId);

		// Redirect to url
		return "redirect:/listPersonCC";
	}
   
    /**
     * Retrieves the "Edit Existing Credit Card" page
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("pid") Integer personId, 
    		@RequestParam("cid") Integer creditCardId, Model model) {
    	logger.debug("Received request to show edit page");
    	
    	// Retrieve credit card by id
    	CreditCard existingCreditCard = creditCardService.get(creditCardId);
    	existingCreditCard.setNumber(AES.decrypt(existingCreditCard.getNumber()));
    	// Add to model
    	model.addAttribute("personId", personId);
    	model.addAttribute("creditCard", existingCreditCard);

    	// This will resolve to /WEB-INF/jsp/edit-credit-card.jsp
    	return "edit-credit-card";
	}
 
    /**
     * Edits an existing credit card
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("pid") Integer personId,
    							@RequestParam("id") Integer creditCardId, 
    							Model model,
    						    @Valid @ModelAttribute("creditCard") CreditCard creditCard, BindingResult result) {
		logger.debug("Received request to add new credit card");

        if (result.hasErrors()) {
        	model.addAttribute("personId", personId);
        	model.addAttribute("creditCard", creditCard);    	
            return "edit-credit-card";
        }		
       
        creditCard.setNumber(AES.encrypt(creditCard.getNumber()));
		creditCard.setId(creditCardId);
		creditCardService.edit(creditCard);
		return "redirect:/listPersonCC";
	}
    
    @ModelAttribute("creditcardlist")
    public List<String> initializeCreditCards() { 
        List<String> creditcards = new ArrayList<String>();
        creditcards.add("VISA");
        creditcards.add("Master Card");
        creditcards.add("American Express");
        creditcards.add("Diners");
        creditcards.add("Discover");
        return creditcards;
    }    
}
