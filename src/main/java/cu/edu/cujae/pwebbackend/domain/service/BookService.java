package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.BookDto;
import cu.edu.cujae.pwebbackend.domain.service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public void saveBook(BookDto bookDto){
        bookRepository.saveBook(bookDto);
    }

    public BookDto updateBook(BookDto bookDto, Long bookId){
        return bookRepository.updateBook(bookDto, bookId);
    }

    public boolean deleteBook(Long bookId){
        try{
            bookRepository.deleteBook(bookId);
            return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }

    }
}
