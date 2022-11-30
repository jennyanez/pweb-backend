package cu.edu.cujae.pwebbackend.domain.dto;

import java.util.Date;

public class LoanDto {
	private Long id;
	private BookDto book;
	private CopyDto copy;
	private ClientDto user;
	private Date returnDate;
	private Date loanDate;
	private boolean newRecord;
	
	public LoanDto(Long loanId, BookDto book, CopyDto copy, ClientDto user, Date returnDate, Date loanDate, boolean newRecord) {
		super();
		this.id = loanId;
		this.book = book;
		this.copy = copy;
		this.user = user;
		this.setReturnDate(returnDate);
		this.setLoanDate(loanDate);	
		this.newRecord = newRecord;
	}
	
	public LoanDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

	public CopyDto getCopy() {
		return copy;
	}

	public void setCopy(CopyDto copy) {
		this.copy = copy;
	}

	public ClientDto getUser() {
		return user;
	}

	public void setUser(ClientDto user) {
		this.user = user;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}
}
