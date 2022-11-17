package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.XRoleDto;
import cu.edu.cujae.pwebbackend.persistence.entity.XRol;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface XRolMapper {

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "id", target = "rolId"),
                    @org.mapstruct.Mapping(source = "description", target = "description"),
                    //@org.mapstruct.Mapping(target = "xUserList" , ignore = true)
            }
    )
    XRol toXRol(XRoleDto toXRoleDto);

    List<XRol> toXRolList(List<XRoleDto> toXRoleList);

    @InheritInverseConfiguration
    XRoleDto toXRoleDto(XRol toXRol);
    List<XRoleDto> toXRoleList(List<XRol> toXRolList);
}

