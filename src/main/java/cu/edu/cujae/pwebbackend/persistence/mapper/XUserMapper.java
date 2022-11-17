package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.XUserDto;
import cu.edu.cujae.pwebbackend.persistence.entity.XUser;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {XRolMapper.class})
public interface XUserMapper {

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "username", target = "username"),
                    @org.mapstruct.Mapping(source = "password", target = "password"),
                    @org.mapstruct.Mapping(source = "rol", target = "rol"),
                    @org.mapstruct.Mapping(source = "rol.id", target = "rolId")
            }
    )
    XUser toXUser(XUserDto xUserDto);

    List<XUser> toXUserList(List<XUserDto> xUserDtoList);

    @InheritInverseConfiguration
    XUserDto toXUserDto(XUser xUser);
    List<XUserDto> toXUserDtoList(List<XUser> xUserList);
}
