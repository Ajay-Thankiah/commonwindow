package self.niu.commonwindow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import self.niu.commonwindow.model.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{
	
}
