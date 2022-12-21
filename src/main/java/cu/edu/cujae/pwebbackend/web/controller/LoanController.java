package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.LoanDto;
import cu.edu.cujae.pwebbackend.domain.service.LoanService;
import cu.edu.cujae.pwebbackend.persistence.utils.LoanPK;
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
@RequestMapping("/api/v1/loanList")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/all")
    @Operation(summary = "Get all loan")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<List<LoanDto>> getAll(){
        return new ResponseEntity<>(loanService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get loan by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "loan not found")
    })
    public ResponseEntity<LoanDto> getLoan(@Parameter(description = "The id of the loan")
                                           @PathVariable("id") Long loanId){
        return loanService.getLoan(loanId).map(loanDto ->
                new ResponseEntity<>(loanDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new loan")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<LoanDto> saveLoan(@Parameter(description = "The new loan")
                                            @RequestBody LoanDto loanDto){
        return new ResponseEntity<>(loanService.saveLoan(loanDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(summary = "Update a loan")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "loan not found")
    })
    public ResponseEntity updateLoan(@Parameter(description = "The loan that it's going to be updated")
                                     @RequestBody LoanDto loanDto) {
        return new ResponseEntity<>(loanService.updateLoan(loanDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a loan")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "loan not found")
    })
    public ResponseEntity deleteLoan(@Parameter(description = "The id of the loan")
                                     @PathVariable("id") Long loanId){
        if(loanService.deleteLoan(loanId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/client/{id}")
    @Operation(summary = "Get all loans by client ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "loan not found")
    })
    public ResponseEntity<List<LoanDto>> getLoanByClientId(@Parameter(description = "The id of the client")
                                                           @PathVariable("id") Long clientId){
        return new ResponseEntity<>(loanService.getLoanByClientId(clientId), HttpStatus.OK);
    }

}