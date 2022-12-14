package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.CopyDto;
import cu.edu.cujae.pwebbackend.domain.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/copies")
public class CopyController {
    @Autowired
    private CopyService copyService;

    @GetMapping("/all")
    public ResponseEntity<List<CopyDto>> getAll(){
        return new ResponseEntity<>(copyService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CopyDto> getCopy(@PathVariable("id") Long copyId){
        return copyService.getCopy(copyId).map(copyDto ->
                new ResponseEntity<>(copyDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<CopyDto> saveCopy(@RequestBody CopyDto copy){
        return new ResponseEntity<>(copyService.saveCopy(copy), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CopyDto> updateCopy(@RequestBody CopyDto copy){
        return new ResponseEntity<>(copyService.updateCopy(copy), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCopy(@PathVariable("id") Long copyId){
        if(copyService.deleteCopy(copyId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<List<CopyDto>> getByBookId(@PathVariable("id") Long bookId){
        return new ResponseEntity<>(copyService.getByBookId(bookId), HttpStatus.OK);
    }
}
