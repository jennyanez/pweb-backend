package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.SanctionDto;
import cu.edu.cujae.pwebbackend.domain.service.SanctionService;
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
@RequestMapping("/sanctions")
public class SanctionController {

    @Autowired
    private SanctionService sanctionService;

    @GetMapping("/all")
    public ResponseEntity<List<SanctionDto>> getAll(){
        return ResponseEntity.ok(sanctionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SanctionDto> getSanction(@PathVariable("id") Long sanctionId){
        return sanctionService.getById(sanctionId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<SanctionDto> saveSanction(@RequestBody SanctionDto sanction){
        return ResponseEntity.ok(sanctionService.createSanction(sanction));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSanction(@PathVariable("id") Long sanctionId){
        if(sanctionService.deleteSanction(sanctionId)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
