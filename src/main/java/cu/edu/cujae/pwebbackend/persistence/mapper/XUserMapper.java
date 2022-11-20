package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.*;
import cu.edu.cujae.pwebbackend.persistence.entity.XUser;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
<<<<<<< HEAD
import org.mapstruct.*;
=======
>>>>>>> 563f1529b8a80fa58abe4e486799f6d6fb68730a
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {XRolMapper.class})
public interface XUserMapper {

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "username", target = "username"),
                    @org.mapstruct.Mapping(source = "password", target = "password"),
                    @org.mapstruct.Mapping(source = "rol", target = "rol"),
                    @org.mapstruct.Mapping(source = "rol.id", target = "rolId"),
                    @org.mapstruct.Mapping(source = "fullName", target = "fullName"),
                    @org.mapstruct.Mapping(source = "email", target = "email"),
                    @org.mapstruct.Mapping(source = "identification", target = "identification")
            }
    )
    XUser toXUser(XUserDto xUserDto);

    List<XUser> toXUserList(List<XUserDto> xUserDtoList);

    @InheritInverseConfiguration
    XUserDto toXUserDto(XUser xUser);
    List<XUserDto> toXUserDtoList(List<XUser> xUserList);
}
