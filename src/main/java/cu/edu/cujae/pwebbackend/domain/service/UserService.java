package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.UserDto;
import cu.edu.cujae.pwebbackend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll() {
        return userRepository.getAll();
    }

    public UserDto getById(Integer code) {
        return userRepository.getById(code);
    }

    public void save(UserDto user) {
        userRepository.save(user);
    }

    public void delete(Integer code) {
        userRepository.delete(code);
    }

    public UserDto isUser(UserDto user) {
        return userRepository.exists(user);
    }

    public UserDto login(UserDto user) {
        return userRepository.login(user);
    }

    public UserDto findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserDto getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
