package in.codetech.angulareducloud.portal.module;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="userrole")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long UserRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	
	
	@ManyToOne
	private Role role;
	
	public long getUserRoleId() {
		return UserRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		UserRoleId = userRoleId;
	}

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(long userRoleId) {
		super();
		UserRoleId = userRoleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	

}
