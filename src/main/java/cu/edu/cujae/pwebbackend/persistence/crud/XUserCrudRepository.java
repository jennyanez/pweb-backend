package cu.edu.cujae.pwebbackend.persistence.crud;

import cu.edu.cujae.pwebbackend.persistence.entity.XUser;
import org.springframework.data.repository.CrudRepository;

public interface XUserCrudRepository extends CrudRepository<XUser, String> {

}
