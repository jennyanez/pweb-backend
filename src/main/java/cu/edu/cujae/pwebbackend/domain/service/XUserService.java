package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.XUserDto;
import cu.edu.cujae.pwebbackend.domain.repository.XUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XUserService {

    @Autowired
    XUserRepository xUserRepository;

    public XUserDto saveXUser(XUserDto xUserDto){
        return xUserRepository.saveXUSer(xUserDto);
    }

    public Optional<XUserDto> getXUser(String username){
        return xUserRepository.getXUser(username);
    }

    public List<XUserDto> getAll(){
       return xUserRepository.getAll();
    }

    public XUserDto updateXUser(XUserDto xUserDto){
        return xUserRepository.updateXUser(xUserDto);
    }

    public void deleteXUser(String username){
        xUserRepository.deleteXUser(username);
    }
}
