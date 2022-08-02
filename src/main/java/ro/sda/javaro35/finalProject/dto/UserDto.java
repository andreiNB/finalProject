package ro.sda.javaro35.finalProject.dto;

import lombok.Data;
import ro.sda.javaro35.finalProject.enums.UserRol;

@Data
public class UserDto {

    Long id;
    String userName;
    String password;
    String email;
    UserRol rol;
}
