package cu.edu.cujae.pwebbackend.domain.dto;

public class LoginRequestDto {

    private String username;
    private String password;

    public LoginRequestDto() {
        super();
    }

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
}
