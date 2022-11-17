package cu.edu.cujae.pwebbackend.persistence.mapper;


import cu.edu.cujae.pwebbackend.domain.dto.AuthorDto;
import cu.edu.cujae.pwebbackend.persistence.entity.Author;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    @Mappings(
            {
                    @Mapping(source="authorId", target = "authorId"),
                    @Mapping(source="name", target = "name"),
                    @Mapping(target="books", ignore = true),
            }
    )
    Author toAuthor(AuthorDto author);
    List<Author> toAuthorList(List<AuthorDto> authorDtoList);

    @InheritInverseConfiguration
    AuthorDto toAuthorDto(Author author);
    List<AuthorDto> toAuthorDtoList(List<Author> authorList);
}
