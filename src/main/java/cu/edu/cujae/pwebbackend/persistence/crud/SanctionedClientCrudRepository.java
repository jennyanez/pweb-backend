package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.SanctionedClient;
import org.springframework.data.repository.CrudRepository;

public interface SanctionedClientCrudRepository extends CrudRepository<SanctionedClient, Long> {
}
