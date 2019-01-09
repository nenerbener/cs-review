package com.in28minutes.login;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	LoginService service = new LoginService();
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	@ResponseBody
	public String showLoginPage() {
		if(logger.isDebugEnabled()){
			logger.debug("showLoginPage() is executed!");
		}
//		return "Hello World dummy";
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, 
			@RequestParam String password,
			ModelMap model) {
		if(logger.isDebugEnabled()){
			logger.debug("handleLoginRequest() is executed!");
			logger.debug("name: " + name);
		}
		if(!service.validateUser(name, password)) {
			model.put("errorMessage", "Invalid credentials");
			return "login";
		}
		model.put("name",name);
		return "welcome";
	}
}
