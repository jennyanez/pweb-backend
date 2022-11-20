package cu.edu.cujae.pwebbackend.persistence.utils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


public class BookAuthorPK implements Serializable {
    private Long bookId;
    private Long authorId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }





    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.bookId);
        hash = 59 * hash + Objects.hashCode(this.authorId);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookAuthorPK other = (BookAuthorPK) obj;
        if (!Objects.equals(this.bookId, other.bookId)) {
            return false;
        }
        if (!Objects.equals(this.authorId, other.authorId)) {
            return false;
        }
        return true;
    }
}
