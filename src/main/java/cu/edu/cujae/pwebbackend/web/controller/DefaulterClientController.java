package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.DefaulterClientDto;
import cu.edu.cujae.pwebbackend.domain.service.DefaulterClientService;
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
@RequestMapping("/defaulter_clients")
public class DefaulterClientController {

    @Autowired
    private DefaulterClientService deClientService;

    @GetMapping("/all")
    @Operation(summary = "Get all defaulter clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<List<DefaulterClientDto>> getAll(){
        return new ResponseEntity<>(deClientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get  defaulter client by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<DefaulterClientDto> getDefaulterClient(@Parameter(description = "The id of the Defaulter Client")
                                               @PathVariable("id") Long defaulterClientId){
        return deClientService.getDefaulterClient(defaulterClientId).map(defaulterClientDto ->
                new ResponseEntity<>(defaulterClientDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a defaulter client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity deleteDefaulterClient(@Parameter(description = "The id of the Defaulter Client")
                                       @PathVariable("id") Long defaulterClientId){
        if(deClientService.deleteClient(defaulterClientId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
