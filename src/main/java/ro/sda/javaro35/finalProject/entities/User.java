package ro.sda.javaro35.finalProject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ro.sda.javaro35.finalProject.enums.UserRol;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    Long id;

    String userName;
    @Column(nullable = false)
    String password;
    @Column(nullable = false, unique = true)
    String email;
    UserRol rol;


}
