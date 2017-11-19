package self.niu.commonwindow.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new 	SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/showUsers", method=RequestMethod.GET)
	public String showAllUsers(ModelMap model) {
		model.put("userInfoIterable", adminService.getUserInfoList());
		return "showUsers";
	}
	
	@RequestMapping(value="/addUserInfo", method=RequestMethod.GET)
	public String showAddUserInfoPage(ModelMap model) {
		model.put("userInfo", new UserInfo("","","","",new Date()));
		return "addUserInfo";
	}
	
	@RequestMapping(value="/addUserInfo", method=RequestMethod.POST)
	public String addUserInfo(ModelMap model, @Valid UserInfo userInfo, BindingResult result) {
		userInfo = adminService.addUser(userInfo);
		model.put("userAddedConfirmationMessage", "The user "+userInfo.getName()+" is added successfully!");
		model.put("userDetailsMessage", "Please note down the userId: "+userInfo.getUserId()+" and password: "+userInfo.getPassword());//later change this to mailing the details to user and admin
		
		return "redirect:/showUsers";
	}
	
	@RequestMapping(value="/deleteUserInfo", method=RequestMethod.GET)
	public String removeUser(ModelMap model, @RequestParam long id) {
		adminService.removeUser(id);
		return "redirect:/showUsers";
	}
	
	@RequestMapping(value="/updateUserInfo", method=RequestMethod.GET)
	public String showUpdateUserPage(ModelMap model, @RequestParam long id) {
		//adminService.removeUser(id);
		UserInfo userInfo = adminService.findUserById(id);
		model.put("userInfo", new UserInfo(userInfo.getName(), userInfo.getPassword(), userInfo.getRole(), userInfo.getUserId(), userInfo.getValidTill()));
		return "updateUserInfo";
	}
	
	@RequestMapping(value="/updateUserInfo", method=RequestMethod.POST)
	public String updateUserInfo(ModelMap model, @Valid UserInfo userInfo, BindingResult result) {
		adminService.updateUser(userInfo);
		return "redirect:/showUsers";
	}

}
