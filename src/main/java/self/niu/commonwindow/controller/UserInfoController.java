package self.niu.commonwindow.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import self.niu.commonwindow.model.UserInfo;
import self.niu.commonwindow.repository.UserInfoRepository;


@Controller
public class UserInfoController {
	
	@Autowired
	private UserInfoRepository userInfoRepository;	
	
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
    public String saveUser(ModelMap model, @RequestParam String name,@RequestParam String role, @RequestParam String password) {
		UserInfo userInfo = new UserInfo(name,password,role,role.charAt(0)+""+name);
		userInfoRepository.save(userInfo);
		model.put("name",name);
		model.put("role",role);
		model.put("userId",role.charAt(0)+""+name);
        return "userAddedConfirmation";
    }
	
	@RequestMapping(value = "/userinfo",method = RequestMethod.GET)
    public String usersList(ModelMap model){
        return "userInfo";
    }

}
