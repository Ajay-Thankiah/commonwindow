package self.niu.commonwindow.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import self.niu.commonwindow.model.UserInfo;
import self.niu.commonwindow.repository.UserInfoRepository;


@Controller
public class UserInfoController {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	 /* @RequestMapping("/create")
	  @ResponseBody
	  public String create(String name, String userId, String password, String role) {
	    UserInfo userInfo = null;
	    try {
	    	userInfo = new UserInfo(name,userId,password,role);
	    	userInfoRepository.save(userInfo);
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created! (id = " + userInfo.getId() + ")";
	  }*/
	
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(@RequestBody UserInfo userInfo) {
        userInfoRepository.save(userInfo);
        return userInfo.getId().toString();
    }
	
	@RequestMapping(value = "/userinfo",method = RequestMethod.GET)
    public String usersList(Model model){
		UserInfo userInfo=new UserInfo("ajay","ajaysp","admin","ironman");
		userInfoRepository.save(userInfo);
        model.addAttribute("users", userInfoRepository.findAll());
        return "userInfo";
    }

}
