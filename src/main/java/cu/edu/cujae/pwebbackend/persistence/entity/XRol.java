package cu.edu.cujae.pwebbackend.persistence.entity;

import cu.edu.cujae.pwebbackend.domain.dto.XUserDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table()
public class XRol {

    @Id
    @Column(name = "rol")
    private long rolId;

    @Column(name = "description")
    private String description;
/*
    @OneToMany(mappedBy = "rol")
    private List<XUser> xUserList;

 */



    /***********************         Getters and Setters        *************************/

    public long getRolId() {
        return rolId;
    }

    public void setRolId(long rolId) {
        this.rolId = rolId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/*
    public List<XUser> getUserList() {
        return xUserList;
    }

    public void setUserList(List<XUser> xUserList) {
        this.xUserList = xUserList;
    }

 */
}
