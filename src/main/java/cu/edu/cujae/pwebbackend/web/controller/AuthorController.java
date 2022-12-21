package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.AuthorDto;
import cu.edu.cujae.pwebbackend.domain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    public ResponseEntity<List<AuthorDto>> getAll(){
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable("id") Long authorId){
        return authorService.getAuthor(authorId).map(authorDto ->
                new ResponseEntity<>(authorDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveAuthor(@RequestBody AuthorDto author) throws SQLException, IOException {
        try {
            authorService.saveAuthor(author);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (SQLException e){
            return new ResponseEntity<>("This author already exists",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAuthor(@RequestBody AuthorDto authorDto) throws SQLException{
        try {
            authorService.updateAuthor(authorDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (SQLException e){
            return new ResponseEntity<>("This author already exists",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long authorId){
        if(authorService.deleteAuthor(authorId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
