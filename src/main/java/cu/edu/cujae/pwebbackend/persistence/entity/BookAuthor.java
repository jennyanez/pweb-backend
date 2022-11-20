package cu.edu.cujae.pwebbackend.persistence.entity;

import cu.edu.cujae.pwebbackend.persistence.utils.BookAuthorPK;

import javax.persistence.*;

@Entity
@IdClass(value = BookAuthorPK.class)
@Table(name = "book_author")
public class BookAuthor {
    @Id
    @Column(name = "book_id")
    private Long bookId;
    @Id
    @Column(name = "author_id")
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;

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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }


}
