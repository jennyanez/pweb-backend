package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.UserDto;
import cu.edu.cujae.pwebbackend.domain.service.UserService;
import cu.edu.cujae.pwebbackend.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sendmail")
public class EmailController {

    @Autowired
    private UserService userServices;

    @Autowired
    private SendEmail sendEmail;

    @PostMapping("/{email}")
    public ResponseEntity<String> sendEmail(@PathVariable String email)
            throws Exception {
        
        int randomPIN = (int) (Math.random() * 90000000) + 1000;

        UserDto user = userServices.getUserByEmail(email);
        if (user != null) {
            user.setRecoverCode(Integer.toString(randomPIN));
            String name = user.getFirstName().split(" ")[0];
            userServices.save(user);
            sendEmail.sendEmail(
                    email,
                    name,
                    "Codigo de verificacion",
                    Integer.toString(randomPIN)
            );
            return ResponseEntity.ok("Correo enviado");
        } else {
            return ResponseEntity.ok("Correo no registrado");
        }
    }
}