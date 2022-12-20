package cu.edu.cujae.pwebbackend.persistence.mapper;


import cu.edu.cujae.pwebbackend.domain.dto.SanctionDto;
import cu.edu.cujae.pwebbackend.persistence.entity.Sanction;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SanctionMapper {

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "sanctionId", target = "sanctionId"),
                    @org.mapstruct.Mapping(source = "typeOfSanction", target = "typeOfSanction"),
                    @org.mapstruct.Mapping(source = "dateStartSanction", target = "dateStartSanction"),
                    @org.mapstruct.Mapping(source = "dateEndSanction", target = "dateEndSanction"),
                    @org.mapstruct.Mapping(source = "client", target = "client"),
                    @org.mapstruct.Mapping(source = "client.clientId", target = "clientId"),
            }
    )
    Sanction toSanction(SanctionDto sanctionDto);
    List<Sanction> toSanctionList(List<SanctionDto> sanctionDtoList);


    @InheritInverseConfiguration
    SanctionDto toSanctionDto(Sanction sanction);
    List<SanctionDto> toSanctionDtoList(List<Sanction> sanctionList);

}
