package cu.edu.cujae.pwebbackend.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "matter")
public class Matter {
    @Id
    @Column(name = "matter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matterId;

    @Column(name = "matter_name")
    private String matterName;

    /****** Getters and setters ******/
    public Long getMatterId() {
        return matterId;
    }

    public void setMatterId(Long matterId) {
        this.matterId = matterId;
    }

    public String getMatterName() {
        return matterName;
    }

    public void setMatterName(String matterName) {
        this.matterName = matterName;
    }
}
