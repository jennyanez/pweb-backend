package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.MatterDto;
import cu.edu.cujae.pwebbackend.domain.service.MatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matters")
public class MatterController {
    @Autowired
    private MatterService matterService;

    @GetMapping("/all")
    public ResponseEntity<List<MatterDto>> getAll(){
        return new ResponseEntity<>(matterService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatterDto> getMatter(@PathVariable("id") Long matterId){
        return matterService.getMatter(matterId).map(matterDto ->
                new ResponseEntity<>(matterDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<MatterDto> saveMatter(@RequestBody MatterDto matterDto){
        return new ResponseEntity<>(matterService.saveMatter(matterDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMatter(@RequestBody MatterDto matterDto,
                                       @PathVariable("id") Long matterId) {
        return new ResponseEntity<>(matterService.updateMatter(matterDto, matterId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMatter(@PathVariable("id") Long matterId){
        if(matterService.deleteMatter(matterId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
