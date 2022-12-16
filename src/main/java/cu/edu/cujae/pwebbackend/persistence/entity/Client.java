package cu.edu.cujae.pwebbackend.persistence.entity;


import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "client_dni")
    private String DNI;

    @Column(name = "client_area")
    private String area;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_first_surname")
    private String firstSurname;

    @Column(name = "client_last_surname")
    private String lastSurname;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Loan> loanList;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LoanRequest> loanRequestList;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Breach> breachList;


    /*****************      Getters And Setters      *************************/

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getLastSurname() {
        return lastSurname;
    }

    public void setLastSurname(String lastSurname) {
        this.lastSurname = lastSurname;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    public List<LoanRequest> getLoanRequestList() {
        return loanRequestList;
    }

    public void setLoanRequestList(List<LoanRequest> loanRequestList) {
        this.loanRequestList = loanRequestList;
    }

    public List<Breach> getBreachList() {
        return breachList;
    }

    public void setBreachList(List<Breach> breachList) {
        this.breachList = breachList;
    }
}
