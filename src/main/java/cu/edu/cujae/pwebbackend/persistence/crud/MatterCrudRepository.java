package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.Matter;
import org.springframework.data.repository.CrudRepository;

public interface MatterCrudRepository extends CrudRepository<Matter, Long> {

}
