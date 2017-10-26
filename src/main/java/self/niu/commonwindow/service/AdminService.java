package self.niu.commonwindow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import self.niu.commonwindow.model.UserInfo;
import self.niu.commonwindow.repository.UserInfoRepository;

@Service
public class AdminService {
	
	private static int userIDPopulator=0;//should be stored into DB for each admin

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public Iterable<UserInfo> getUserInfoList() {
		// TODO Auto-generated method stub
		return userInfoRepository.findAll();
	}

	public UserInfo addUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		String name = userInfo.getName();
		userInfo.setUserId(name.substring(0,2)+"1"+String.format("%03d",++userIDPopulator));
		userInfo.setPassword(Character.toUpperCase(name.charAt(0))+""+name.substring(1));
		userInfo.setRole("user");
		userInfoRepository.save(userInfo);
		return userInfo;
	}

	public void removeUser(long id) {
		// TODO Auto-generated method stub
		userInfoRepository.delete(id);		
	}

	public void updateUser(long id) {
		// TODO Auto-generated method stub
		userInfoRepository.delete(id);		
	}

}
