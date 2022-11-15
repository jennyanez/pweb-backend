package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.DefaulterClientDto;
import cu.edu.cujae.pwebbackend.persistence.entity.DefaulterClient;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DefaulterClientMapper {

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "defaulterClientId", target = "defaulterClientId"),
                    @org.mapstruct.Mapping(source = "bookTitlePossession", target = "bookTitlePossession"),
                    @org.mapstruct.Mapping(source = "amountDaysBreach", target = "amountDaysBreach"),
            }
    )
    DefaulterClient toDefaulterClient(DefaulterClientDto defaulterClient);
    List<DefaulterClient> toDefaulterClientList(List<DefaulterClientDto> defaulterClientDtoList);


    @InheritInverseConfiguration
    DefaulterClientDto toDefaulterClientDto(DefaulterClient defaulterClient);
    List<DefaulterClientDto> toDefaulterClientDtoList(List<DefaulterClient> defaulterClientList);

}
