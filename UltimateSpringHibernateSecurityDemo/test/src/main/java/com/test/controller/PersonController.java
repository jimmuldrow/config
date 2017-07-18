package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import com.test.dto.PersonDTO;
import com.test.model.Person;
import com.test.service.CreditCardService;
import com.test.service.PersonService;


@Controller
@RequestMapping("/")
public class PersonController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private PersonService personService;
	
	/**
	 * Retrieves the "Records" page
	 */
    @RequestMapping(value = { "/listPersonCC"}, method = RequestMethod.GET)
    public String getRecords() {
    	logger.debug("Received request to show records page");
 		return "records";
	}
    
    @RequestMapping(value = {"/", "/splash"}, method = RequestMethod.GET)
    public String splash() {
    	logger.debug("Received request to show splash page");
 		return "splash";
	}   

    /**
     *  Retrieves the "Add New Record" page
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	logger.debug("Received request to show add page");
    
    	// Create new Person and add to model
    	model.addAttribute("person", new Person());

    	// This will resolve to /WEB-INF/jsp/add-record.jsp
    	return "add-record";
	}
 
    /**
     * Adds a new record
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		logger.debug("Received request to add new record");
		
        if (result.hasErrors()) {
            return "add-record";
        }		

		// Delegate to service
		personService.add(person);

		// Redirect to url
		return "redirect:/listPersonCC";
	}
    
    /**
     * Deletes a record including all the associated credit cards
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelete(@RequestParam("id") int personId) {
    	logger.debug("Received request to delete record");
    	
    	// Delete person
		personService.delete(personId);

		// Redirect to url
		return "redirect:/listPersonCC";
	}
    
    /**
     * Retrieves the "Edit Existing Record" page
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("id") Integer personId, Model model) {
    	logger.debug("Received request to show edit page");
    	
    	// Retrieve person by id
    	Person existingPerson = personService.get(personId);

    	// Add to model
    	model.addAttribute("person", existingPerson);

    	// This will resolve to /WEB-INF/jsp/edit-record.jsp
    	return "edit-record";
	}
 
    /**
     * Edits an existing record
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("id") Integer personId, 
    						    @Valid @ModelAttribute("person") Person person, BindingResult result) {
		logger.debug("Received request to edit existing person");

        if (result.hasErrors()) {
            return "edit-record";
        }			

		person.setId(personId);
		personService.edit(person);
		return "redirect:/listPersonCC";
	}
    
    @ModelAttribute("customerTypes")
    public List<String> initializeCustomerTypes() {
 
        List<String> customerTypes = new ArrayList<String>();
        customerTypes.add("Platinum");
        customerTypes.add("Gold");
        customerTypes.add("Silver");
        return customerTypes;
    } 
}
