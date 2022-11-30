package cu.edu.cujae.pwebbackend.domain.service.repository;

import cu.edu.cujae.pwebbackend.domain.dto.AuthorDto;
import cu.edu.cujae.pwebbackend.domain.dto.BookAuthorDto;
import cu.edu.cujae.pwebbackend.domain.dto.BookDto;
import cu.edu.cujae.pwebbackend.persistence.crud.AuthorCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.crud.BookAuthorCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.crud.BookCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Author;
import cu.edu.cujae.pwebbackend.persistence.entity.Matter;
import cu.edu.cujae.pwebbackend.persistence.mapper.AuthorMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.BookAuthorMapper;
import cu.edu.cujae.pwebbackend.persistence.entity.Book;
import cu.edu.cujae.pwebbackend.persistence.mapper.BookMapper;
import cu.edu.cujae.pwebbackend.persistence.entity.BookAuthor;
import cu.edu.cujae.pwebbackend.persistence.mapper.MatterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    @Autowired
    private BookCrudRepository bookCrudRepository;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookAuthorMapper bookAuthorMapper;
    @Autowired
    private BookAuthorCrudRepository bookAuthorCrudRepository;
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private AuthorCrudRepository authorCrudRepository;
    @Autowired
    private MatterMapper matterMapper;

    /**** CRUD methods ****/
    //Create
    public void saveBook(BookDto bookDto){
        BookAuthorDto bookAuthorDto = new BookAuthorDto();
        Book book = bookMapper.toBook(bookDto);
        bookAuthorDto.setBook(bookMapper.toBookDto(bookCrudRepository.save(book)));
        for(AuthorDto a : bookDto.getAuthors()) {
            Author author = authorMapper.toAuthor(a);
            bookAuthorDto.setAuthor(authorMapper.toAuthorDto(author));
            BookAuthor ba = bookAuthorMapper.toBookAuthor(bookAuthorDto);
            bookAuthorCrudRepository.save(ba);
        }
    }
    //Read
    public Optional<BookDto> getBook(Long bookId){
        Optional<BookDto> bookDtoOptional = bookCrudRepository.findById(bookId).map(book -> bookMapper.toBookDto(book));
        if(bookDtoOptional.isPresent()){
            List<BookAuthor> bookAuthorList = bookAuthorCrudRepository.findByBookId(bookDtoOptional.get().getBookId());
            for(BookAuthor ba: bookAuthorList){
                AuthorDto authorDto = authorMapper.toAuthorDto(ba.getAuthor());
                bookDtoOptional.get().getAuthors().add(authorDto);
            }
        }
        return bookDtoOptional;
    }
    //Read all
    public List<BookDto> getAll(){
        List<Book> bookList = (List<Book>) bookCrudRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();

        for(Book b : bookList){
            List<BookAuthor> bookAuthorList = bookAuthorCrudRepository.findByBookId(b.getBookId());
            BookDto book = bookMapper.toBookDto(b);
            for(BookAuthor ba: bookAuthorList){
                AuthorDto authorDto = authorMapper.toAuthorDto(ba.getAuthor());
                book.getAuthors().add(authorDto);
            }
            bookDtoList.add(book);
        }

        return bookDtoList;
    }

    //Update
    public BookDto updateBook(BookDto bookDto, Long bookId){
        Book book = bookMapper.toBook(bookDto);
        book.setBookId(bookId);
        Book bookUpd = bookCrudRepository.save(book);
        return bookMapper.toBookDto(bookUpd);
    }

    //Delete
    public void deleteBook(Long bookId){
        bookCrudRepository.deleteById(bookId);

    }
}
