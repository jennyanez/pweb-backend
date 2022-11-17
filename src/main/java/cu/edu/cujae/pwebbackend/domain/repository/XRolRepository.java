package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.XRoleDto;
import cu.edu.cujae.pwebbackend.persistence.crud.XRolCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.XRol;
import cu.edu.cujae.pwebbackend.persistence.mapper.XRolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class XRolRepository{

    @Autowired
    XRolCrudRepository xRolCrudRepository;

    @Autowired
    XRolMapper xRolMapper;

    public XRoleDto saveXRol(XRoleDto xRoleDto){
        XRol xRol = xRolMapper.toXRol(xRoleDto);
        return xRolMapper.toXRoleDto(xRolCrudRepository.save(xRol));
    }


    public Optional<XRoleDto> getXRol(Long xRolId){
        return xRolCrudRepository.findById(xRolId).map(xRol -> xRolMapper.toXRoleDto(xRol));
    }

    public List<XRoleDto> getAll(){
        List<XRol> xRolList = (List<XRol>)  xRolCrudRepository.findAll();
        return xRolMapper.toXRoleList(xRolList);
    }

    public XRoleDto updateXRol(XRoleDto xRoleDto, long xRolId){
        XRol xRol = xRolMapper.toXRol(xRoleDto);
        xRol.setRolId(xRolId);
        XRol xRolUpdate = xRolCrudRepository.save(xRol);
        return xRolMapper.toXRoleDto(xRolUpdate);
    }

    public boolean deleteXRol(Long xRolId){
        xRolCrudRepository.deleteById(xRolId);
        return true;
    }

}
