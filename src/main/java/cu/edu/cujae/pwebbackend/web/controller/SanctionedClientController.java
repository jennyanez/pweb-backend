package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.SanctionedClientDto;
import cu.edu.cujae.pwebbackend.domain.service.SanctionedClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sanctioned_clients")
public class SanctionedClientController {

    @Autowired
    private SanctionedClientService sanClientService;

    @GetMapping("/all")
    @Operation(summary = "Get all sanctioned clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<List<SanctionedClientDto>> getAll(){
        return new ResponseEntity<>(sanClientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get  sanctioned client by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<SanctionedClientDto> getSanctionedClient(@Parameter(description = "The id of the Sanctioned Client")
                                                                 @PathVariable("id") Long sanctionedClientId){
        return sanClientService.getSanctionedClient(sanctionedClientId).map(sanctionedClientDto ->
                new ResponseEntity<>(sanctionedClientDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
