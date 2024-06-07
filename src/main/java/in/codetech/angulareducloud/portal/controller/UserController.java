package in.codetech.angulareducloud.portal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codetech.angulareducloud.portal.module.Role;
import in.codetech.angulareducloud.portal.module.User;
import in.codetech.angulareducloud.portal.module.UserRole;
import in.codetech.angulareducloud.portal.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception{
		//Set<UserRole> roles = user.getUserRoles();
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(24L);
		role.setRoleName("Admin");
		
		UserRole userRole =  new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		return this.userservice.createUser(user, roles);
		
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		User user = this.userservice.getUser(username);
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable long id) {
		this.userservice.deleteUser(id);
	}
	
	@GetMapping("/")
	public List<User> getAllUser(){
		List<User> user = this.userservice.getAllUser();
		return user;
	}
	

}
