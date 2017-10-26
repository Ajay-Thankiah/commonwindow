package self.niu.commonwindow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import self.niu.commonwindow.model.UserInfo;
import self.niu.commonwindow.repository.UserInfoRepository;

@Service
public class CommonWindowLoginService {

	@Autowired
	private UserInfoRepository userInfoRepository;	
	
	public String validateLogin(String userId, String password) {
		// TODO Auto-generated method stub
		Iterable<UserInfo> userInfoIterable = userInfoRepository.findAll();
		for(UserInfo userInfo: userInfoIterable) {
			if(userId.equalsIgnoreCase(userInfo.getUserId())) {
				if(password.equals(userInfo.getPassword())) {
					return userInfo.getRole();
				}else {
					return "invalid";
				}
			}
		}
		return "invalid";
	}

}
