package self.niu.commonwindow.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import self.niu.commonwindow.model.UserInfo;

@Repository
@Transactional
public class UserInfoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private static int userIDPopulator=0;//should be stored into DB for each admin
	
	public long saveUser(UserInfo userInfo) {
		String name = userInfo.getName();
		userInfo.setUserId(name.substring(0,2)+"1"+String.format("%03d",++userIDPopulator));
		userInfo.setPassword(Character.toUpperCase(name.charAt(0))+""+name.substring(1));
		userInfo.setRole("user");
		entityManager.persist(userInfo);
		return userInfo.getId();
	}
	
	public boolean deleteUserById(long id) {
		try{
			UserInfo userInfo = entityManager.find(UserInfo.class, id);
			entityManager.remove(userInfo);
		}catch(IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		List<UserInfo> userInfoList = entityManager.createQuery("SELECT u FROM user_info as u", UserInfo.class).getResultList();
		return userInfoList;
	}

	public UserInfo updateUserRepo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		UserInfo userInfoTemp = entityManager.find(UserInfo.class, userInfo.getId());
		userInfoTemp.setName(userInfo.getName());
		userInfoTemp.setPassword(userInfo.getPassword());
		userInfoTemp.setUserId(userInfo.getUserId());
		userInfoTemp.setValidTill(userInfo.getValidTill());
		return userInfoTemp;
	}

	public UserInfo findUserByIdRepo(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(UserInfo.class, id);
	}
}
