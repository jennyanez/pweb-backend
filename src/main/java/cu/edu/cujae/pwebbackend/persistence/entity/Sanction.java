package cu.edu.cujae.pwebbackend.persistence.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "sanction")
public class Sanction {
    @Id
    @Column(name = "sanction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sanctionId;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    @Column(name="client_id")
    private Long clientId;

    @Column(name = "type_of_sanction")
    private String typeOfSanction;

    @Column(name = "date_start_sanction")
    private Date dateStartSanction;

    @Column(name = "date_end_sanction")
    private Date dateEndSanction;


    /******** Getters and Setters ********/
    public Long getSanctionId() {
        return sanctionId;
    }

    public void setSanctionId(Long sanctionId) {
        this.sanctionId = sanctionId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getTypeOfSanction() {
        return typeOfSanction;
    }

    public void setTypeOfSanction(String typeOfSanction) {
        this.typeOfSanction = typeOfSanction;
    }

    public Date getDateStartSanction() {
        return dateStartSanction;
    }

    public void setDateStartSanction(Date dateStartSanction) {
        this.dateStartSanction = dateStartSanction;
    }

    public Date getDateEndSanction() {
        return dateEndSanction;
    }

    public void setDateEndSanction(Date dateEndSanction) {
        this.dateEndSanction = dateEndSanction;
    }
}
