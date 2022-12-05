package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.XRoleDto;
import cu.edu.cujae.pwebbackend.domain.service.XRolService;
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
@RequestMapping("/roles")
public class XRolController {
    @Autowired
    private XRolService xRolService;

    @GetMapping("/all")
    @Operation(summary = "Get all xRol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<List<XRoleDto>> getAll(){
        return new ResponseEntity<>(xRolService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get XRol by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "XRol not found")
    })
    public ResponseEntity<XRoleDto> getXRol(@Parameter(description = "The id of the XRol")
                                               @PathVariable("id") Long xRolId){
        return xRolService.getXRol(xRolId).map(xRolDto ->
                new ResponseEntity<>(xRolDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new XRol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<XRoleDto> saveXRol(@Parameter(description = "The new XRol")
                                                @RequestBody XRoleDto xRoleDto){
        return new ResponseEntity<>(xRolService.saveXRol(xRoleDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a XRol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "XRol not found")
    })
    public ResponseEntity updateXRol(@Parameter(description = "The XRol that it's going to be updated")
                                       @RequestBody XRoleDto xRoleDto,
                                       @Parameter(description = "The id of the XRol")
                                       @PathVariable("id") Long xRolId) {
        return new ResponseEntity<>(xRolService.updateXRol(xRoleDto, xRolId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a XRol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "XRol not found")
    })
    public ResponseEntity deleteXRol(@Parameter(description = "The id of the XRol")
                                       @PathVariable("id") Long xRolId){
        if(xRolService.deleteXRol(xRolId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
