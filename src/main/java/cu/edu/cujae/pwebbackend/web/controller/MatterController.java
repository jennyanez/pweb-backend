package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.MatterDto;
import cu.edu.cujae.pwebbackend.domain.service.MatterService;
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
@RequestMapping("/matters")
public class MatterController {
    @Autowired
    private MatterService matterService;

    @GetMapping("/all")
    /** esto es lo que se muestra en el swagger **/
    @Operation(summary = "Get all matters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<List<MatterDto>> getAll(){
        return new ResponseEntity<>(matterService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get matter by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Matter not found")
    })
    public ResponseEntity<MatterDto> getMatter(@Parameter(description = "The id of the Matter")
                                                   @PathVariable("id") Long matterId){
        return matterService.getMatter(matterId).map(matterDto ->
                new ResponseEntity<>(matterDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a new matter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<MatterDto> saveMatter(@Parameter(description = "The new matter")
                                                    @RequestBody MatterDto matterDto){
        return new ResponseEntity<>(matterService.saveMatter(matterDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a matter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Matter not found")
    })
    public ResponseEntity<MatterDto> updateMatter(@Parameter(description = "The matter that it's going to be updated")
                                                      @RequestBody MatterDto matterDto,
                                                      @Parameter(description = "The id of the Matter")
                                                      @PathVariable("id") Long matterId) {
        return new ResponseEntity<>(matterService.updateMatter(matterDto, matterId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a matter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Matter not found")
    })
    public ResponseEntity<?> deleteMatter(@Parameter(description = "The id of the Matter")
                                           @PathVariable("id") Long matterId){
        if(matterService.deleteMatter(matterId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
