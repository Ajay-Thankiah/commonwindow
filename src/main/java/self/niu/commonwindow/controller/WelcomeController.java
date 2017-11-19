package self.niu.commonwindow.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//import self.niu.commonwindow.service.CommonWindowLoginService;

@Controller
@SessionAttributes("userId")
public class WelcomeController {
	
	/*@Autowired
	private CommonWindowLoginService commonWindowLoginService;*/
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("userId", getLoggedInUserId());
		return "welcomePage";
	}
	
	@RequestMapping(value="/userPage", method=RequestMethod.GET)
	public String showUserPage(ModelMap model) {
		model.put("userId", getLoggedInUserId());
		return "userPage";
	}
	
	private String getLoggedInUserId() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	/*@RequestMapping(value="/login", method=RequestMethod.POST)
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
*/
}
