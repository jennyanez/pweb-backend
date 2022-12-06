package cu.edu.cujae.pwebbackend.web.controller;

import cu.edu.cujae.pwebbackend.domain.dto.BookDto;
import cu.edu.cujae.pwebbackend.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAll(){
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id") Long bookId){
        return bookService.getBook(bookId).map(bookDto ->
                new ResponseEntity<>(bookDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody BookDto book){
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto book){
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long bookId){
        if(bookService.deleteBook(bookId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
