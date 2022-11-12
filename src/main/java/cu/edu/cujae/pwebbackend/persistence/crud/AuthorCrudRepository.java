package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorCrudRepository extends CrudRepository<Author, Long> {
}
