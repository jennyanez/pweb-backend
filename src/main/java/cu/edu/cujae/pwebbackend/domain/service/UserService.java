package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.UserDto;
import cu.edu.cujae.pwebbackend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll() throws SQLException{
        return userRepository.getAll();
    }

    public UserDto getById(Integer code) throws SQLException {
        return userRepository.getById(code);
    }

    public void save(UserDto user) throws SQLException{
        userRepository.save(user);
    }

    public boolean delete(Integer code){
       try{
           userRepository.delete(code);
           return true;
       }catch (EmptyResultDataAccessException e){
           return false;
       }
    }

    public UserDto isUser(UserDto user) throws SQLException{
        return userRepository.exists(user);
    }

    public UserDto login(UserDto user) throws SQLException{
        return userRepository.login(user);
    }

    public UserDto findByUsername(String username) throws SQLException{
        return userRepository.findByUsername(username);
    }

    public UserDto getUserByEmail(String email) throws SQLException{
        return userRepository.getUserByEmail(email);
    }
}
