package cu.edu.cujae.pwebbackend.persistence.entity;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_request")
public class LoanRequest {

    @Id
    @Column(name = "loan_request_id")
    private Long id;

    @Column(name = "copy_id")
    private Long copyId;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "book_id")
    private Long bookId;

    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false, updatable = false)
    private Client client;

    @OneToOne
    @JoinColumn(name = "copy_id",insertable = false, updatable = false)
    private Copy copy;

    @Column(name = "date_request")
    private Date loanRequestDate;

    @OneToOne
    @JoinColumn(name = "book_id",insertable = false, updatable = false)
    private Book book;

    /*************  Getters  And  Setters   ***************/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Date getLoanRequestDate() {
        return loanRequestDate;
    }

    public void setLoanRequestDate(Date loanRequestDate) {
        this.loanRequestDate = loanRequestDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
