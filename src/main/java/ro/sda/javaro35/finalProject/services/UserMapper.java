package ro.sda.javaro35.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.UserDto;
import ro.sda.javaro35.finalProject.entities.User;
import ro.sda.javaro35.finalProject.repository.UserRepository;

@Service
public class UserMapper implements Mapper<User, UserDto> {

    private final UserRepository userRepository;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto convertToDto(User entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setName(entity.getName());
        userDto.setPassword(entity.getPassword());
        userDto.setEmail(entity.getEmail());
        userDto.setRoles(entity.getRoles());
        return userDto;
    }

    @Override
    public User convertToEntity(UserDto dto) {
        User user;
        if (dto.getId() != null) {
            user = userRepository.findById(dto.getId()).orElse(new User());
        } else {
            user = new User();
        }
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setRoles(dto.getRoles());
        return user;
    }
}
