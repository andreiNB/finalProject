package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.javaro35.finalProject.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
