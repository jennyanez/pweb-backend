package cu.edu.cujae.pwebbackend.persistence.crud;

import java.util.List;

import cu.edu.cujae.pwebbackend.persistence.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleCrudRepository extends CrudRepository<Role, Integer> {
    List<Role> findAll();

    Role save(Role role);

    Role findByCode(Integer code);

    void deleteByCode(Integer code);
}