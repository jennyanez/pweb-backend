package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.UserDto;
import cu.edu.cujae.pwebbackend.domain.email.EmailSenderService;
import cu.edu.cujae.pwebbackend.domain.email.Mail;
import cu.edu.cujae.pwebbackend.domain.service.UserService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailSenderService emailService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll() throws SQLException {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") int code) throws SQLException{
        return new ResponseEntity<>(userService.getById(code), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> create(@RequestBody UserDto user) throws SQLException, IOException{
        try{
            userService.save(user);
            sendMailToUserWithCredentials(user.getFirstName(), user.getEmail());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (SQLException e){
            return new ResponseEntity<>("This user already exists",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody UserDto user) throws SQLException, IOException{
        try {
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (SQLException e){
            return new ResponseEntity<>("This user already exists",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int code) throws SQLException, IOException{
        try {
            userService.delete(code);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/isUser")
    public ResponseEntity<UserDto> isUser(@RequestBody UserDto userDto) throws SQLException{
        return new ResponseEntity<UserDto>(userService.isUser(userDto), HttpStatus.OK);
    }

    /// para validar que no exista ese email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email) throws SQLException{
        try {
            return new ResponseEntity<UserDto>(userService.getUserByEmail(email), HttpStatus.OK);
        }catch (SQLException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /// para validar que no exista ese username
    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable("username") String username) throws SQLException{
        try {
            return new ResponseEntity<UserDto>(userService.findByUsername(username), HttpStatus.OK);
        }catch (SQLException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /******* email method ********/
        private void sendMailToUserWithCredentials(String fullName, String email){
        Mail mail=new Mail();
        mail.setMailTo(email);
        mail.setSubject("Welcome to CUJAE Library System");
        mail.setTemplate("user-registration-template.ftl");

        Map<String,Object> model=new HashMap<String, Object>();
        model.put("name",fullName);
        mail.setProps(model);

        try{
            emailService.sendEmail(mail);
        }catch(MessagingException | IOException | TemplateException e){
            e.printStackTrace();
        }

    }
}
