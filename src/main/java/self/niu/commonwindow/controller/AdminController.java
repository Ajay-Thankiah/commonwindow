package self.niu.commonwindow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import self.niu.commonwindow.model.UserInfo;
import self.niu.commonwindow.service.AdminService;

@Controller
@SessionAttributes("userId")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/showUsers", method=RequestMethod.GET)
	public String showAllUsers(ModelMap model) {
		model.put("userInfoIterable", adminService.getUserInfoList());
		return "showUsers";
	}
	
	@RequestMapping(value="/addUserInfo", method=RequestMethod.GET)
	public String showAddUserInfoPage(ModelMap model) {
		model.put("userInfo", new UserInfo("","","",""));
		return "addUserInfo";
	}
	
	@RequestMapping(value="/addUserInfo", method=RequestMethod.POST)
	public String addddUserInfo(ModelMap model, UserInfo userInfo) {
		userInfo = adminService.addUser(userInfo);
		model.put("userAddedConfirmationMessage", "The user "+userInfo.getName()+" is added successfully!");
		model.put("userDetailsMessage", "Please note down the userId: "+userInfo.getUserId()+" and password: "+userInfo.getPassword());//later change this to mailing the details to user and admin
		model.put("userInfoIterable", adminService.getUserInfoList());
		return "showUsers";
	}
	
	@RequestMapping(value="/deleteUserInfo", method=RequestMethod.GET)
	public String removeUser(ModelMap model, @RequestParam long id) {
		adminService.removeUser(id);
		return "redirect:/showUsers";
	}
	
	@RequestMapping(value="/updateUserInfo", method=RequestMethod.GET)
	public String updateUser(ModelMap model, @RequestParam long id) {
		adminService.removeUser(id);
		return "redirect:/addUserInfo";
	}

}
