package in.codetech.angulareducloud.portal.serviceImpl;

import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.module.User;
import in.codetech.angulareducloud.portal.module.UserRole;
import in.codetech.angulareducloud.portal.repository.UserRepository;
import in.codetech.angulareducloud.portal.repository.RoleRepository;
import in.codetech.angulareducloud.portal.service.UserService;
import in.codetech.angulareducloud.portal.exception.UserFoundException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            // Create user
            for(UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> all = this. userRepository.findAll();
		return all;
	}

	
}
