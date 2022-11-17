package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookCrudRepository extends CrudRepository<Book, Long> {
}
