package cu.edu.cujae.pwebbackend.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="copy")
public class Copy {
    @Id
    @Column(name = "copy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long copyId;
    @ManyToOne
    @JoinColumn(name="book_id", insertable = false, updatable = false)
    private Book book;
    @Column(name = "copy_number")
    private int copyNumber;


    //////GETTERS AND SETTERS
    public Long getCopyId() {
        return copyId;
    }

    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }

    public Book getBook() { return book; }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }
}
