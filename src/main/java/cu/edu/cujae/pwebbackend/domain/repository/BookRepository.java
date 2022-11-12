package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.BookDto;
import cu.edu.cujae.pwebbackend.persistence.crud.BookCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Book;
import cu.edu.cujae.pwebbackend.persistence.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    @Autowired
    private BookCrudRepository bookCrudRepository;

    @Autowired
    private BookMapper mapper;

    /**** CRUD methods ****/
    //Create
    public BookDto saveBook(BookDto bookDto){
        Book book = mapper.toBook(bookDto);
        return mapper.toBookDto(bookCrudRepository.save(book));
    }

    //Read
    public Optional<BookDto> getBook(Long bookId){
        return bookCrudRepository.findById(bookId).map(book -> mapper.toBookDto(book));
    }

    //Read all
    public List<BookDto> getAll(){
        List<Book> books = (List<Book>) bookCrudRepository.findAll();
        return mapper.toBookDtoList(books);
    }

    //Update
    public BookDto updateBook(BookDto bookDto, Long bookId){
        Book book = mapper.toBook(bookDto);
        book.setBookId(bookId);
        Book bookUpd = bookCrudRepository.save(book);
        return mapper.toBookDto(bookUpd);
    }

    //Delete
    public void deleteBook(Long bookId){
        bookCrudRepository.deleteById(bookId);

    }
}
