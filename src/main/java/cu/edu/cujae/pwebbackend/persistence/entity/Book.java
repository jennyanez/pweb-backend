package cu.edu.cujae.pwebbackend.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(name = "book_title")
    private String bookTitle;
    @Column(name = "year_edition")
    private int yearEdition;
    @Column(name = "editorial")
    private String editorial;
    @Column(name = "country_origin")
    private String countryOrigin;
    @Column(name = "content_summary")
    private String summary;
    @Column(name = "amount_pages")
    private int amountPages;
    @ManyToOne
    @JoinColumn(name = "matter_id", insertable = false, updatable = false)
    private Matter matter;

    @Column(name = "matter_id")
    private Long matter_id;

    @OneToMany(mappedBy = "author")
    private List<BookAuthor> authors;

    @Column(name = "book_code")
    private String bookCode;
    @OneToMany(mappedBy = "book")
    private List<Copy> copies;

    /******* GETTERS AND SETTERS *********/
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getYearEdition() {
        return yearEdition;
    }

    public void setYearEdition(int yearEdition) {
        this.yearEdition = yearEdition;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getAmountPages() {
        return amountPages;
    }

    public void setAmountPages(int amountPages) {
        this.amountPages = amountPages;
    }

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    public List<BookAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<BookAuthor> authors) {
        this.authors = authors;
    }

    public Long getMatter_id() {
        return matter_id;
    }

    public void setMatter_id(Long matter_id) {
        this.matter_id = matter_id;
    }
}
