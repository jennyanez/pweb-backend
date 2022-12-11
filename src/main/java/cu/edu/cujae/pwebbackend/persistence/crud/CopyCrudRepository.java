package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.Copy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CopyCrudRepository extends CrudRepository<Copy, Long> {
    List<Copy> getByBookId(Long bookId);
}
