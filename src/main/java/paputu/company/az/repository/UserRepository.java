package paputu.company.az.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import paputu.company.az.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
