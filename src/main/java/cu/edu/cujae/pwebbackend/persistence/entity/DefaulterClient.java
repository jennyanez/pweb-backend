package cu.edu.cujae.pwebbackend.persistence.entity;



import javax.persistence.*;

@Entity
@Table(name = "defaulter_client")
public class DefaulterClient{
    @Id
    @Column(name = "defaulter_client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long defaulterClientId;

    @Column(name = "book_title")
    private String bookTitlePossession;

    @Column(name = "amount_days")
    private int amountDaysBreach;


    public Long getDefaulterClientId() {
        return defaulterClientId;
    }

    public void setDefaulterClientId(Long defaulterClientId) {
        this.defaulterClientId = defaulterClientId;
    }

    public String getBookTitlePossession() {
        return bookTitlePossession;
    }

    public void setBookTitlePossession(String bookTitlePossession) {
        this.bookTitlePossession = bookTitlePossession;
    }

    public int getAmountDaysBreach() {
        return amountDaysBreach;
    }

    public void setAmountDaysBreach(int amountDaysBreach) {
        this.amountDaysBreach = amountDaysBreach;
    }
}
