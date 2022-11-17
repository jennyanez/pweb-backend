package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.XUserDto;
import cu.edu.cujae.pwebbackend.persistence.crud.XUserCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.XUser;
import cu.edu.cujae.pwebbackend.persistence.mapper.XUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class XUserRepository {

    @Autowired
    private XUserCrudRepository xUserCrudRepository;

    @Autowired
    private XUserMapper mapper;

   public XUserDto saveXUSer(XUserDto xUserDto){
       XUser xUser = mapper.toXUser(xUserDto);
       return mapper.toXUserDto(xUserCrudRepository.save(xUser));
   }

   public Optional<XUserDto> getXUser(String username){
       return xUserCrudRepository.findById(username).map(xUser -> mapper.toXUserDto(xUser));
   }

   public List<XUserDto> getAll(){
       List<XUser> xUserList = (List<XUser>) xUserCrudRepository.findAll();
       return mapper.toXUserDtoList(xUserList);
   }

   public XUserDto updateXUSer(XUserDto xUserDto, String username){
       XUser xUser = mapper.toXUser(xUserDto);
       xUser.setUsername(username);
       XUser xUserUpdate = xUserCrudRepository.save(xUser);
       return mapper.toXUserDto(xUserUpdate);
   }

   public void deleteXUSer (String username){
       xUserCrudRepository.deleteById(username);
   }
}
