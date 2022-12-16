package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.BreachDto;
import cu.edu.cujae.pwebbackend.persistence.entity.Breach;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class, ClientMapper.class, CopyMapper.class})
public interface BreachMapper {

    @Mappings(
            {
            @Mapping(source = "breachId", target = "breachId"),
            @Mapping(source = "days", target = "days"),
            @Mapping(source = "copy.book", target = "book"),
            @Mapping(source = "copy", target = "copy"),
            @Mapping(source = "client", target = "client"),
            @Mapping(source = "copy.book.bookId", target = "bookId"),
            @Mapping(source = "copy.copyId", target = "copyId"),
            @Mapping(source = "client.clientId", target = "clientId")
    }
    )
    Breach toBreach(BreachDto breach);
    List<Breach> toBreachList(List<BreachDto> breaches);

    @InheritInverseConfiguration
    BreachDto toBreachDto(Breach breach);
    List<BreachDto> toBreachDtoList(List<Breach> breachesList);

}
