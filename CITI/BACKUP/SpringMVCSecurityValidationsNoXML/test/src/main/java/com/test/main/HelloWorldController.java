package com.test.main;

import java.util.ArrayList;
import java.util.List;
 
import javax.validation.Valid;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
 
@Controller
@RequestMapping("/")
public class HelloWorldController {
 
    /*
     * This method will serve as default GET handler.
     *
     */
    @RequestMapping(method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "enroll";
    }
 
    /*
     * This method will be called on form submission, handling POST request
     * It also validates the user input
     */
    @RequestMapping(method = RequestMethod.POST)
    public String saveRegistration(@Valid Student student, BindingResult result, ModelMap model){
 
        if(result.hasErrors()) {
                return "enroll";
        }
 
        model.addAttribute("success", "Dear "+ student.getFirstName()+" , your Registration completed successfully");
        return "success";
    }
 
    /*
     * Method used to populate the Section list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("sections")
    public List<String> initializeSections() {
 
        List<String> sections = new ArrayList<String>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Research");
        return sections;
    }
 
    /*
     * Method used to populate the country list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("countries")
    public List<String> initializeCountries() {
 
        List<String> countries = new ArrayList<String>();
        countries.add("USA");
        countries.add("CANADA");
        countries.add("FRANCE");
        countries.add("GERMANY");
        countries.add("ITALY");
        countries.add("OTHER");
        return countries;
    }
 
    /*
     * Method used to populate the subjects list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("subjects")
    public List<String> initializeSubjects() {
 
        List<String> subjects = new ArrayList<String>();
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Life Science");
        subjects.add("Political Science");
        subjects.add("Computer Science");
        subjects.add("Mathmatics");
        return subjects;
    }
    
    //=======================================================================================================
    
    @RequestMapping(value = { "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Admin Page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("admin");

		return model;

	}
    
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "You are now logged out");
		model.setViewName("admin");
		return model;
	}
}
