package com.test;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WebAccountsController {

	@Autowired
	protected WebAccountsService accountsService;

	public WebAccountsController(WebAccountsService accountsService) {
		this.accountsService = accountsService;
	}	

	@RequestMapping("/accountById/{id}")
	public String byId(Model model,
			@PathVariable("id") String id) {

		Account account = accountsService.findById(id);
		ConfigDTO configDTO= accountsService.getConfigurations();
		account.setGreeting(configDTO.getGreeting());
		model.addAttribute("account", account);
		return "account";
	}
	
    @RequestMapping("/addUpdateDeleteAccount")
    public String enterNewAccount(Model model) {
        model.addAttribute("account", new Account());
        return "initialAccount";
    }
    
    @RequestMapping(value="/processAccount")
    public String postNewAccount(@ModelAttribute Account account, HttpServletRequest request) {
    	String submitButton = noNull(request.getParameter("submitButton"));
     	System.out.println("****************** submitButton = " + submitButton);
    	
    	if(submitButton.equals("ADD")){
    		accountsService.postToAccount(account);
    	}
    	
    	if(submitButton.equals("UPDATE")){
    		accountsService.putToAccount(account);
    	}
    	
    	if(submitButton.equals("DELETE")){
    		accountsService.deleteFromAccountById("" + account.getId());
    	}
    	
        return "result";
    }
    
    private String noNull(String s){return ((s == null) ? "" : s.trim());}
}
