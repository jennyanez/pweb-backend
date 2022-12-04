package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.LoanRequestDto;
import cu.edu.cujae.pwebbackend.domain.service.LoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loanRequestList")
public class LoanRequestController {

    @Autowired
    private LoanRequestService service;


    @GetMapping("/all")
    public ResponseEntity<List<LoanRequestDto>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanRequestDto> getLoanRequest(@PathVariable("id") Long id){
        return service.getLoanRequest(id).map(loanRequestDto ->
                new ResponseEntity<>(loanRequestDto,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<LoanRequestDto> saveLoanRequest(@RequestBody LoanRequestDto dto){
        return new ResponseEntity<>(service.saveLoanRequest(dto),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLoanRequest(@RequestBody LoanRequestDto dto,@PathVariable("id") Long id){
        return new ResponseEntity<>(service.updateLoanRequest(dto,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLoanRequest(@PathVariable("id") Long id){
        if(service.deleteLoan(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
