package self.niu.commonwindow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//@Column(name="name")
	//@NotNull
    private String name;
	//@Column(name="userId")
	//@NotNull
    private String userId;
	//@Column(name="password")
	//@NotNull
    private String password;
	//@Column(name="role")
	//@NotNull
    private String role;
	
	public UserInfo() { }
    
    public UserInfo(String name, String userId, String password, String role) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}

