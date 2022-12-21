package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.UserDto;
import cu.edu.cujae.pwebbackend.persistence.crud.UserCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.User;
import cu.edu.cujae.pwebbackend.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserCrudRepository userCrudRepository;



    public List<UserDto> getAll() {
        List<User> users = userCrudRepository.findAll();
        return userMapper.toListUserDto(users);
    }

    public UserDto getById(Integer id) {
        return userMapper.toUserDto(userCrudRepository.findByCode(id));
    }

    public void save(UserDto user) throws SQLException {
        try{
            if(getUserByEmail(user.getEmail()) == null){
                if(findByUsername(user.getUsername()) == null){
                    user.setPassword(encodePass(user.getPassword()));
                    User userEntity = userMapper.toUser(user);
                    userCrudRepository.save(userEntity);
                }
            }
        }catch (Exception e){
            throw new SQLException(e);
        }
    }

    public void delete(Integer code) {
        userCrudRepository.deleteById(code);
    }

    public UserDto login(UserDto user) {
        User userEntity = userMapper.toUser(user);
        User userLogin = userCrudRepository.findByUsernameAndPassword(
                userEntity.getUsername(),
                userEntity.getPassword()
        );
        return userMapper.toUserDto(userLogin);
    }

    public UserDto exists(UserDto userDto) {
        UserDto user = new UserDto();
        List<UserDto> users = getAll();
        for (int i = 0; i < users.size(); i++) {
            if (
                    users.get(i).getUsername().equals(userDto.getUsername()) &&
                            users.get(i).getPassword().equals(userDto.getPassword())
            ) {
                user = users.get(i);
                i = users.size();
            }
        }
        return user;
    }

    public UserDto findByUsername(String username) {
        User user = userCrudRepository.findByUsername(username);
        return userMapper.toUserDto(user);
    }

    public UserDto getUserByEmail(String email) {
        User user = userCrudRepository.findByEmail(email);
        return userMapper.toUserDto(user);
    }

    private String encodePass(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}