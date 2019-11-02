package snowtoslow.work.workProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snowtoslow.work.workProject.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
