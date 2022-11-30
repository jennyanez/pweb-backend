package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface LoanCrudRepository extends CrudRepository<Loan,Long> {

}
