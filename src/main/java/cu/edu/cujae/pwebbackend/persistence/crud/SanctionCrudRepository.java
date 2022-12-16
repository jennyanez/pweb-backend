package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.Sanction;
import org.springframework.data.repository.CrudRepository;

public interface SanctionCrudRepository extends CrudRepository<Sanction, Long> {
}
