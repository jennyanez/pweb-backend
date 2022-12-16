package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.BreachDto;
import cu.edu.cujae.pwebbackend.domain.service.BreachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breaches")
public class BreachController {
    @Autowired
    private BreachService breachService;

    @GetMapping("/all")
    public ResponseEntity<List<BreachDto>> getAll(){
        return ResponseEntity.ok(breachService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BreachDto> getBreach(@PathVariable("id") Long breachId){
        return breachService.getBreach(breachId).map(breachDto ->
                ResponseEntity.ok(breachDto)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<BreachDto> saveBreach(@RequestBody BreachDto breach){
        return ResponseEntity.ok(breachService.saveBreach(breach));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BreachDto> updateBreach(@RequestBody BreachDto breach){
        return ResponseEntity.ok(breachService.updateBreach(breach));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBreach(@PathVariable("id") Long breachId){
        if(breachService.deleteBreach(breachId)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
