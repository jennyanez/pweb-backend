package cu.edu.cujae.pwebbackend.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "xrol")
public class XRol {

    @Id
    @Column(name = "rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "rol")
    private List<XUser> xUserList;

    /***********************         Getters and Setters        *************************/

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<XUser> getUserList() {
//        return xUserList;
//    }
//
//    public void setUserList(List<XUser> xUserList) {
//        this.xUserList = xUserList;
//    }

    public List<XUser> getxUserList() {
        return xUserList;
    }

    public void setxUserList(List<XUser> xUserList) {
        this.xUserList = xUserList;
    }


}
