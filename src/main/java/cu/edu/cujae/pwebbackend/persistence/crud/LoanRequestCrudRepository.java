package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.LoanRequest;
import org.springframework.data.repository.CrudRepository;

public interface LoanRequestCrudRepository extends CrudRepository<LoanRequest,Long> {
}
