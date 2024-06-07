package in.codetech.angulareducloud.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codetech.angulareducloud.portal.module.User;
import in.codetech.angulareducloud.portal.module.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole , Long> {

}
