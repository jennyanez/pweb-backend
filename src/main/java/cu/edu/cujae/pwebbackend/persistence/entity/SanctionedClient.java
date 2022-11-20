package cu.edu.cujae.pwebbackend.persistence.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "sanctioned_client")
public class SanctionedClient{
    @Id
    @Column(name = "sanctioned_client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sanctionedClientId;

    @Column(name = "type_of_sanction")
    private int typeOfSanction;

    @Column(name = "date_start_sanction")
    private Calendar dateStartSanction;

    @Column(name = "date_end_sanction")
    private Calendar dateEndSanction;


    public Long getSanctionedClientId() {
        return sanctionedClientId;
    }

    public void setSanctionedClientId(Long sanctionedClientId) {
        this.sanctionedClientId = sanctionedClientId;
    }


    public int getTypeOfSanction() {
        return typeOfSanction;
    }

    public void setTypeOfSanction(int typeOfSanction) {
        this.typeOfSanction = typeOfSanction;
    }

    public Calendar getDateStartSanction() {
        return dateStartSanction;
    }

    public void setDateStartSanction(Calendar dateStartSanction) {
        this.dateStartSanction = dateStartSanction;
    }

    public Calendar getDateEndSanction() {
        return dateEndSanction;
    }

    public void setDateEndSanction(Calendar dateEndSanction) {
        this.dateEndSanction = dateEndSanction;
    }
}
