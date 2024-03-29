package cu.edu.cujae.pwebbackend.persistence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="copy")
public class Copy {

    @Id
    @Column(name = "copy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long copyId;
    @ManyToOne
    @JoinColumn(name="book_id", insertable = false, updatable = false)
    private Book book;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "copy_number")
    private int copyNumber;

    @OneToOne(mappedBy = "copy")
    private Loan loan;

    @OneToOne(mappedBy = "copy")
    private LoanRequest loanRequest;

    @OneToMany(mappedBy = "copy",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Breach> breachList;


    /*******************            Getters And Setters            ***********************/


    public Long getCopyId() {
        return copyId;
    }

    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public LoanRequest getLoanRequest() {
        return loanRequest;
    }

    public void setLoanRequest(LoanRequest loanRequest) {
        this.loanRequest = loanRequest;
    }

    public List<Breach> getBreachList() {
        return breachList;
    }

    public void setBreachList(List<Breach> breachList) {
        this.breachList = breachList;
    }
}
