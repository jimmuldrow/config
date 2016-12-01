package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;


@RefreshScope
@Component
@Controller
public class WebAccountsController {

	@Autowired
	protected WebAccountsService accountsService;

	protected Logger logger = Logger.getLogger(WebAccountsController.class
			.getName());

	public WebAccountsController(WebAccountsService accountsService) {
		this.accountsService = accountsService;
	}
	
    @Value("${message.greeting}")
    String greeting;	
	
	@RequestMapping("/accountById/{id}")
	public String byId(Model model,
			@PathVariable("id") String id) {

		logger.info("web-service accountById() invoked: " + id);

		AccountDTO account = accountsService.findById(id);
		account.setGreeting(greeting);
		logger.info("web-service byId() found: " + account + "greeting:  " + greeting);
		model.addAttribute("account", account);
		return "account";
	}	
}
