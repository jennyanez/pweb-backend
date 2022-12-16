package cu.edu.cujae.pwebbackend.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name="breach")
public class Breach {
    @Id
    @Column(name = "breach_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breachId;

    @ManyToOne
    @JoinColumn(name="book_id", insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name="copy_id", insertable = false, updatable = false)
    private Copy copy;

    @ManyToOne
    @JoinColumn(name="client_id", insertable = false, updatable = false)
    private Client client;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "copy_id")
    private Long copyId;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "amount_days")
    private int days;


    /*******************            Getters And Setters            ***********************/
    public Long getBreachId() {
        return breachId;
    }

    public void setBreachId(Long breachId) {
        this.breachId = breachId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getCopyId() {
        return copyId;
    }

    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
