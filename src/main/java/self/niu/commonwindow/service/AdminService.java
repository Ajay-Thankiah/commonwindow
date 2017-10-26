package self.niu.commonwindow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import self.niu.commonwindow.model.UserInfo;
import self.niu.commonwindow.repository.UserInfoRepository;

@Service
public class AdminService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public Iterable<UserInfo> getUserInfoList(String string) {
		// TODO Auto-generated method stub
		return userInfoRepository.findAll();
	}

}
