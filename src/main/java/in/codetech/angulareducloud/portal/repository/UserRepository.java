package in.codetech.angulareducloud.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codetech.angulareducloud.portal.module.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);

}
