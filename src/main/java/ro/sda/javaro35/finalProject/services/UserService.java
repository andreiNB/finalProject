package ro.sda.javaro35.finalProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.UserDto;
import ro.sda.javaro35.finalProject.entities.User;
import ro.sda.javaro35.finalProject.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void createUser(UserDto dto) {
        User user = userMapper.convertToEntity(dto);
        userRepository.save(user);
    }

    public UserDto findById(long id) {

        User entityUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("User not found")));
        return userMapper.convertToDto(entityUser);
    }

    public void deleteById(long id){
        userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(String.format("User not found")));
    }
}
