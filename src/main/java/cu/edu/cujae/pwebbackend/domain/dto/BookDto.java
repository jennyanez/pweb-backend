package cu.edu.cujae.pwebbackend.domain.dto;

import cu.edu.cujae.pwebbackend.persistence.entity.Matter;

import java.util.List;

public class BookDto {
	private Long bookId;
	private String code;
	private String title;
	private int yearEdition;
	private String editorial;
	private String countryOrigin;
	private String summary;
	private int amountPages;
	private Matter matter;
	private List<AuthorDto> authors;
	//private boolean newRecord;
//	private List<CopyDto> copiesList;
	
	public BookDto(Long bookId, String code, String title, List<AuthorDto> authors, Matter matter){
		setBookId(bookId);
		setCode(code);
		setTitle(title);
		setAuthors(authors);
		setMatter(matter);
	//	setNewRecord(newRecord);
	//	setCopiesList(copiesList);
	}
	public BookDto() {

	}
	
//	/**
//	 * @return the newRecord
//	 */
//	public boolean isNewRecord() {
//		return newRecord;
//	}
//
//	/**
//	 * @param newRecord the newRecord to set
//	 */
//	public void setNewRecord(boolean newRecord) {
//		this.newRecord = newRecord;
//	}

//	public List<CopyDto> getCopiesList() {
//		return copiesList;
//	}
//
//	public void setCopiesList(List<CopyDto> copiesList) {
//		this.copiesList = copiesList;
//	}
	
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearEdition() {
		return yearEdition;
	}

	public void setYearEdition(int yearEdition) {
		this.yearEdition = yearEdition;
	}

	public String getCountryOrigin() {
		return countryOrigin;
	}

	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getAmountPages() {
		return amountPages;
	}

	public void setAmountPages(int amountPages) {
		this.amountPages = amountPages;
	}

	public Matter getMatter() {
		return matter;
	}

	public void setMatter(Matter matter) {
		this.matter = matter;
	}

	public List<AuthorDto> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorDto> authors) {
		this.authors = authors;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
