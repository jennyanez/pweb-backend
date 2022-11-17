package cu.edu.cujae.pwebbackend.persistence.entity;

import cu.edu.cujae.pwebbackend.persistence.utils.BookAuthorPK;

import javax.persistence.*;

@Entity
@Table(name = "book_author")
public class BookAuthor {
    @EmbeddedId
    private BookAuthorPK id;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;


    public BookAuthorPK getId() {
        return id;
    }

    public void setId(BookAuthorPK id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
