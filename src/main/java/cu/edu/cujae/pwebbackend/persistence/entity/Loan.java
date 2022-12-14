package cu.edu.cujae.pwebbackend.persistence.entity;

import cu.edu.cujae.pwebbackend.persistence.utils.LoanPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;


    @Column(name = "copy_id")
    private Long copyId;

    
    @Column(name = "client_id")
    private Long clientId;



    /**********************    Relaciones *************************/
    @OneToOne
    @JoinColumn(name = "copy_id", insertable = false, updatable = false)
    private Copy copy;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

/***********************        Extras        ***************************/

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "loan_date")
    private Date loanDate;



    /*************************   Getters and Setters ************************/

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }
}
