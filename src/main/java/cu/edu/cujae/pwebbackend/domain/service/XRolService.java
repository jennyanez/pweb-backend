package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.XRoleDto;
import cu.edu.cujae.pwebbackend.domain.repository.XRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class XRolService {

    @Autowired
    private XRolRepository xRolRepository;

    public XRoleDto saveXRol(XRoleDto xRoleDto){
        return xRolRepository.saveXRol(xRoleDto);
    }

    public Optional<XRoleDto> getXRol(Long xRolId){
        return xRolRepository.getXRol(xRolId);
    }

    public List<XRoleDto> getAll(){
        return xRolRepository.getAll();
    }

    public XRoleDto updateXRol(XRoleDto xRoleDto, Long xRolId){
        return xRolRepository.updateXRol(xRoleDto,xRolId);
    }

    public boolean deleteXRol(Long xRolId){
       if(xRolRepository.deleteXRol(xRolId)){
           return true;
       }
       return false;
    }
}
