package cu.edu.cujae.pwebbackend.domain.security;

import cu.edu.cujae.pwebbackend.domain.dto.UserDto;
import cu.edu.cujae.pwebbackend.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

     @Autowired
     UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = null;

        try{
            user = userService.findByUsername(username);
            if(user == null){
                throw new UsernameNotFoundException("User not found.");
            }
        }catch (SQLException e){
            user = null;
        }
        return UserPrincipal.create(user);
    }

}
