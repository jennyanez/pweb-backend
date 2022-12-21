package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.ClientDto;
import cu.edu.cujae.pwebbackend.domain.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    @Operation(summary = "Get all clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<List<ClientDto>> getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<ClientDto> getClient(@Parameter(description = "The id of the Client")
                                               @PathVariable("id") Long clientId){
        return clientService.getClient(clientId).map(clientDto ->
                new ResponseEntity<>(clientDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<String> saveClient(@Parameter(description = "The new client")
                                                @RequestBody ClientDto clientDto) throws SQLException, IOException {
        try{
            clientService.saveClient(clientDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (SQLException e){
            return new ResponseEntity<>("This client already exists",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    @Operation(summary = "Update a client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Matter not found")
    })
    public ResponseEntity<String> updateClient(@Parameter(description = "The client that is going to be updated")
                                       @RequestBody ClientDto clientDto) throws SQLException, IOException {
        try{
            clientService.updateClient(clientDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (SQLException e){
            return new ResponseEntity<>("This client already exists",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<String> deleteClient(@Parameter(description = "The id of the Client")
                                       @PathVariable("id") Long clientId){
        if(clientService.deleteClient(clientId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
