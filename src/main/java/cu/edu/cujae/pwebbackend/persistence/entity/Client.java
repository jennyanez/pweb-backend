package cu.edu.cujae.pwebbackend.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    //Primary Key de la tabla
    @Id
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

    @OneToMany(mappedBy = "copy")
    private List<Loan> copyList;

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

    public List<Loan> getCopyList() {
        return copyList;
    }

    public void setCopyList(List<Loan> copyList) {
        this.copyList = copyList;
    }
}
