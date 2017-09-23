package self.niu.commonwindow.repository;

import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;
import self.niu.commonwindow.model.UserInfo;

@Transactional
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{
	
	public UserInfo findByName(String name);
	
}
