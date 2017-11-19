package self.niu.commonwindow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity(name="user_info")
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(min = 3,max=15, message = "Please enter 3 - 15 Characters")
	@Column(name="name")
	@NotEmpty(message = "*Please provide the user name")
    private String name;
	
	@Column(name="userId")
    private String userId;
	
	@Column(name="password")
    private String password;
	
	@Column(name="role")
    private String role;
	
	@Column(name="validTill")
    private Date validTill;
	
	public UserInfo() {
		 
	}
    
    public UserInfo(String name, String password, String role, String userId, Date validTill) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
		this.userId=userId;
		this.validTill=validTill;
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
	public Date getValidTill() {
		return validTill;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
}

