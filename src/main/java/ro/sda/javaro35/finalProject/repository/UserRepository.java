package ro.sda.javaro35.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaro35.finalProject.entities.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findAll();

    Optional<User> findByNameIgnoreCase(String name);

    User findByEmailIgnoreCase(String email);


}

