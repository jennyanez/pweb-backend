package cu.edu.cujae.pwebbackend.persistence.mapper;

import java.util.List;
import cu.edu.cujae.pwebbackend.domain.dto.RoleDto;
import cu.edu.cujae.pwebbackend.persistence.entity.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "code", target = "code"),
                    @org.mapstruct.Mapping(source = "role", target = "role"),
                    @org.mapstruct.Mapping(source = "description", target = "description"),
                    @org.mapstruct.Mapping(target = "users", ignore = true),
            }
    )
    Role toRole(RoleDto role);

    List<Role> toListRole(List<RoleDto> roles);

    @InheritInverseConfiguration
    RoleDto toRoleDto(Role role);

    List<RoleDto> toListRoleDto(List<Role> roles);
}
