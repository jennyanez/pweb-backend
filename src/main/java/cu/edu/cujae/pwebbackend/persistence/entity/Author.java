package cu.edu.cujae.pwebbackend.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="author")
public class Author {
    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @Column(name = "author_name")
    private String name;

    @OneToMany(mappedBy = "book")
    private List<BookAuthor> books;

    public Long getAuthorId() {
        return authorId;
    }

    /****GETTERS AND SETTERS******/
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookAuthor> getBooks() {
        return books;
    }

    public void setBooks(List<BookAuthor> books) {
        this.books = books;
    }
}
