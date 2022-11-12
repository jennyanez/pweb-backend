package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.BookDto;
import cu.edu.cujae.pwebbackend.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getAll(){
        return bookRepository.getAll();
    }

    public Optional<BookDto> getBook(Long bookId){
        return bookRepository.getBook(bookId);
    }

    public BookDto saveBook(BookDto bookDto){
        return bookRepository.saveBook(bookDto);
    }

    public BookDto updateBook(BookDto bookDto, Long bookId){
        return bookRepository.updateBook(bookDto, bookId);
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteBook(bookId);
    }
}
