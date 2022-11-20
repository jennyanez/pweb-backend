package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.Author;
import cu.edu.cujae.pwebbackend.persistence.entity.BookAuthor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookAuthorCrudRepository extends CrudRepository<BookAuthor, Long> {
    List<BookAuthor> findByBookId(Long bookId);
}
