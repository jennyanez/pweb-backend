package cu.edu.cujae.pwebbackend.domain.dto;

import java.util.Calendar;

public class SanctionedUserDto extends ClientDto {
	private int typeOfSanction;
	private Calendar dateStartSanction;
	private Calendar dateEndSanction;
	
	public SanctionedUserDto(String DNI, String area, String name, String firstSurname, String lastSurname, int typeOfSanction, Calendar dateStartSanction,
			                 Calendar dateEndSanction){
		super(DNI, area, name, firstSurname, lastSurname);
		setTypeOfSanction(typeOfSanction);
		setDateStartSanction(dateStartSanction);
		setDateEndSanction(dateEndSanction);
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