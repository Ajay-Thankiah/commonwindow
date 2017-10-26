package self.niu.commonwindow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import self.niu.commonwindow.service.CommonWindowLoginService;

@Controller
@SessionAttributes("userId")
public class CommonWindowLoginController {
	
	@Autowired
	private CommonWindowLoginService commonWindowLoginService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String performLogin(ModelMap model, @RequestParam String userId, @RequestParam String password) {
		String role = commonWindowLoginService.validateLogin(userId, password);
		if(role.equals("invalid")) {
			model.put("error_message", "Invalid credentials!");
			return "login";
		}
		model.put("userId",userId);
		if(role.equalsIgnoreCase("admin")) {
			return "redirect:/showUsers";
		}else if(role.equalsIgnoreCase("user")) {
			return "userPage";
		}
		return "login";
	}

}
