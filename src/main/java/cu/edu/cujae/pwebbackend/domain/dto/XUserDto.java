package cu.edu.cujae.pwebbackend.domain.dto;

import java.util.List;

public class XUserDto {
	private String username;
	private String fullName;
	private String password;
	private String email;
	private String identification;
	private boolean newRecord;
	private XRoleDto rol;
	
	public XUserDto() {
		super();
	}

	public XUserDto(String username, String fullName, String password, String email, String identification,
			 XRoleDto rol, boolean newRecord) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.identification = identification;
		this.rol = rol;
		this.newRecord = newRecord;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public XRoleDto getRoles() {
		return this.rol;
	}
	public void setRoles(XRoleDto rol) {
		this.rol = rol;
	}

	public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}
	
}
