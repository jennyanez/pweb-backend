package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.XUserDto;
import cu.edu.cujae.pwebbackend.domain.service.XUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class XUserController {

    @Autowired
    private XUserService xUserService;

    @PostMapping("/save")
    @Operation(summary = "Save a new xUSer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<XUserDto> saveXUSer(@Parameter(description = "The new xUser")
                                              @RequestBody XUserDto xUserDto) {
        return new ResponseEntity<>(xUserService.saveXUser(xUserDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get xUser by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "xUser not found")
    })
    public ResponseEntity<XUserDto> getMatter(@Parameter(description = "The id of the xUser")
                                              @PathVariable("id") String username) {
        return xUserService.getXUser(username).map(xUserDto ->
                new ResponseEntity<>(xUserDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<List<XUserDto>> getAll() {
        return new ResponseEntity<>(xUserService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    @Operation(summary = "Update a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity updateXUSer(@Parameter(description = "The user that is going to be updated")
                                          @RequestBody XUserDto xUserDto) {
        return new ResponseEntity<>(xUserService.updateXUser(xUserDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity deleteMatter(@Parameter(description = "The id of the User")
                                       @PathVariable("id") String username) {

        xUserService.deleteXUser(username);
        return new ResponseEntity(HttpStatus.OK);
    }
}
