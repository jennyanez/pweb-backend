package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.MatterDto;
import cu.edu.cujae.pwebbackend.persistence.entity.Matter;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatterMapper {

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "matterId", target = "matterId"),
                    @org.mapstruct.Mapping(source = "matterName", target = "matterName"),
                  //  @org.mapstruct.Mapping(target = "books", ignore = true),
            }
    )
    Matter toMatter(MatterDto matter);
    List<Matter> toMatterList(List<MatterDto> matterDtoList);

    @InheritInverseConfiguration
    MatterDto toMatterDto(Matter matter);
    List<MatterDto> toMatterDtoList(List<Matter> matterList);
}
