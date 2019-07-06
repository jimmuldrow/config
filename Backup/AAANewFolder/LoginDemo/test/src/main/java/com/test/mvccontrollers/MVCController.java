package com.test.mvccontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.test.model.Register;
import com.test.model.User;
import com.test.model.Greeting;
import com.test.service.DBService;
import com.test.util.PasswordUtil;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Controller
public class MVCController {
	
	@Autowired
	PasswordUtil passwordtUtil;
	
	@Autowired
	DBService dbService;
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("register", new Register());
		return "register";
	}
	
	@PostMapping("/register")
	public String postRegister(@ModelAttribute Register register) {
		String userId = noNull(register.getUserId());
		String password = noNull(register.getPassword());
		
		if((userId.length() >= 6) && (passwordtUtil.checkPassword(password))) {	
			String encryptedPassword = passwordtUtil.bcryptHash(password);
			dbService.add(userId,  encryptedPassword);
			passwordtUtil.setLoggedIn(true);
			return "registerSuccess";
		}
		
		return "registerFailure";
	}
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("register", new Register());
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute Register register) {
		String userId = noNull(register.getUserId());
		String password = noNull(register.getPassword());
		List<User> userList = dbService.findUser(userId);
		
		if((userList != null) && (userList.size() > 0)) {
			User user = userList.get(0);
			String dbUserId = user.getLoginId();
			String dbPassword = user.getPass();
			
			if((userId.equals(dbUserId)) && (passwordtUtil.hashMatches(password,  dbPassword))) {
				passwordtUtil.setLoggedIn(true);
				return "loginSuccess";
			}
		}
		
		return "loginFailure";
	}

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
    	if(passwordtUtil.isLoggedIn() == true) {
    		model.addAttribute("greeting", new Greeting());
    		return "greeting";
    	}
    	
    	return "index";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }

    private String noNull(String s) {return ((s == null) ? "" : s.trim());}
}