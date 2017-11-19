package self.niu.commonwindow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import self.niu.commonwindow.model.UserInfo;
import self.niu.commonwindow.repository.UserInfoRepository;

@Service
public class AdminService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public Iterable<UserInfo> getUserInfoList() {
		// TODO Auto-generated method stub
		return userInfoRepository.findAll();
	}

	public UserInfo addUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoRepository.saveUser(userInfo);
		return userInfo;
	}

	public void removeUser(long id) {
		// TODO Auto-generated method stub
		userInfoRepository.deleteUserById(id);		
	}

	public void updateUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoRepository.updateUserRepo(userInfo);		
	}

	public UserInfo findUserById(long id) {
		// TODO Auto-generated method stub
		return userInfoRepository.findUserByIdRepo(id);	
	}

}
