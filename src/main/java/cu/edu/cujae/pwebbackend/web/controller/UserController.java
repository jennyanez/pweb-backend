package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.UserDto;
import cu.edu.cujae.pwebbackend.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll() throws SQLException {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") int code) throws SQLException{
        return new ResponseEntity<>(userService.getById(code), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> create(@RequestBody UserDto user) throws SQLException{
        userService.save(user);
        return ResponseEntity.ok("User created");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody UserDto user) throws SQLException{
        userService.save(user);
        return ResponseEntity.ok("User updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int code) throws SQLException{
        userService.delete(code);
        return ResponseEntity.ok("User deleted");
    }

    @PostMapping("/isUser")
    public ResponseEntity<UserDto> isUser(@RequestBody UserDto userDto) throws SQLException{
        return new ResponseEntity<UserDto>(userService.isUser(userDto), HttpStatus.OK);
    }
}
