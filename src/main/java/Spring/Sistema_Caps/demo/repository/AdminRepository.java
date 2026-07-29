package Spring.Sistema_Caps.demo.repository;

import Spring.Sistema_Caps.demo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    boolean existsByLogin(String login);
}
