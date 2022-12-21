package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.RoleDto;
import cu.edu.cujae.pwebbackend.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDto> getAll() {
        return roleRepository.getAll();
    }

    public RoleDto getById(Integer code) {
        return roleRepository.getByCode(code);
    }

    public void save(RoleDto role){
        roleRepository.save(role);
    }

    public void delete(Integer code) {
        roleRepository.delete(code);
    }
}
