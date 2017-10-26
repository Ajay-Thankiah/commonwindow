package self.niu.commonwindow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import self.niu.commonwindow.service.AdminService;

@Controller
@SessionAttributes("userId")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/showUsers", method=RequestMethod.GET)
	public String showAllUsers(ModelMap model) {
		model.put("userInfoIterable", adminService.getUserInfoList((String)model.get("userId")));
		return "showUsers";
	}

}
