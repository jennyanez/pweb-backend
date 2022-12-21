package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.Breach;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BreachCrudRepository extends CrudRepository<Breach, Long> {

}

