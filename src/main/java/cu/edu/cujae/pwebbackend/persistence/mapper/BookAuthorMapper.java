package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.persistence.entity.BookAuthor;
import cu.edu.cujae.pwebbackend.domain.dto.BookAuthorDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class, AuthorMapper.class})
public interface BookAuthorMapper {
    @Mappings(
            {
                @Mapping(source="book", target = "book"),
                @Mapping(source = "book.bookId", target = "bookId"),
                @Mapping(source="author", target = "author"),
                @Mapping(source = "author.authorId", target = "authorId"),
            }
    )
    BookAuthor toBookAuthor(BookAuthorDto bookAuthorDto);
    List<BookAuthor> toBookAuthorList(List<BookAuthorDto> bookAuthorDtoList);

    @InheritInverseConfiguration
    BookAuthorDto toBookAuthorDto(BookAuthor bookAuthor);
    List<BookAuthorDto> toBookAuthorDtoList(List<BookAuthor> bookAuthorList);
}
