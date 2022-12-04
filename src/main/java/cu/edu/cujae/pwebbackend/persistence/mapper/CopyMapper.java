package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.CopyDto;
import cu.edu.cujae.pwebbackend.persistence.entity.Copy;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface CopyMapper {
    @Mappings(
            {
              @Mapping(source = "copyId", target = "copyId"),
              @Mapping(source = "copyNumber", target = "copyNumber"),
              @Mapping(source="book", target = "book"),
              @Mapping(target = "loan", ignore = true),
                    @Mapping(source = "book.bookId", target = "bookId")

            }
    )
    Copy toCopy(CopyDto copy);
    List<Copy> toCopyList(List<CopyDto> copies);

    @InheritInverseConfiguration
    CopyDto toCopyDto(Copy copy);
    List<CopyDto> toCopyDtoList(List<Copy> copiesList);
}
