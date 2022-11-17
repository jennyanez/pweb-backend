package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.Client;
import org.springframework.data.repository.CrudRepository;


public interface ClientCrudRepository extends CrudRepository<Client, Long> {

}
