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

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "identification")
    private String identification;


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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
