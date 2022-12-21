package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.BookDto;
import cu.edu.cujae.pwebbackend.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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

    public void saveBook(BookDto bookDto) throws SQLException {
        try {
            bookRepository.saveBook(bookDto);
        }catch (Exception e){
            throw new SQLException(e);
        }
    }

    public void updateBook(BookDto bookDto) throws SQLException{
        try{
            bookRepository.updateBook(bookDto);
        }catch(Exception e){
            throw new SQLException(e);
        }
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
