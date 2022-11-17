package cu.edu.cujae.pwebbackend.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "xuser")
public class XUser {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "xpassword")
    private String password;

    @ManyToOne
    @JoinColumn(name = "rol", insertable = false, updatable=false)
    private XRol rol;

    @Column(name = "rol")
    private Long rolId;


    /***********************         Getters and Setters        *************************/

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public XRol getRol() {
        return rol;
    }

    public void setRol(XRol rol) {
        this.rol = rol;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

}
