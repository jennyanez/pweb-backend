package cu.edu.cujae.pwebbackend.persistence.mapper;


import cu.edu.cujae.pwebbackend.domain.dto.SanctionedClientDto;
import cu.edu.cujae.pwebbackend.persistence.entity.SanctionedClient;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SanctionedClientMapper{

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "sanctionedClientId", target = "sanctionedClientId"),
                    @org.mapstruct.Mapping(source = "typeOfSanction", target = "typeOfSanction"),
                    @org.mapstruct.Mapping(source = "dateStartSanction", target = "dateStartSanction"),
                    @org.mapstruct.Mapping(source = "dateEndSanction", target = "dateEndSanction"),
            }
    )
    SanctionedClient toSanctionedClient(SanctionedClientDto sanctionedClient);
    List<SanctionedClient> toSanctionedClientList(List<SanctionedClientDto> sanctionedClientDtoList);


    @InheritInverseConfiguration
    SanctionedClientDto toSanctionedClientDto(SanctionedClient sanctionedClient);
    List<SanctionedClientDto> toSanctionedClientDtoList(List<SanctionedClient> sanctionedClientList);

}
