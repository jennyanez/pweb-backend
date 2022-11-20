package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.BookDto;
import cu.edu.cujae.pwebbackend.persistence.entity.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MatterMapper.class})
public interface BookMapper {

    @Mappings(
            {
                    @Mapping(source="bookId", target = "bookId"),
                    @Mapping(source="bookTitle", target="bookTitle"),
                    @Mapping(source="yearEdition", target = "yearEdition"),
                    @Mapping(source="editorial", target = "editorial"),
                    @Mapping(source="countryOrigin", target = "countryOrigin"),
                    @Mapping(source = "summary", target = "summary"),
                    @Mapping(source = "amountPages", target = "amountPages"),
                    @Mapping(source = "bookCode", target = "bookCode"),
                    @Mapping(source = "matter", target = "matter"),
                    @Mapping(source = "matter.matterId", target = "matter_id"),
                    @Mapping(target = "authors", ignore = true),
                    @Mapping(target = "copies", ignore = true),
            }
    )
    Book toBook(BookDto bookDto);
    List<Book> toBookList(List<BookDto> bookDtoList);

    @InheritInverseConfiguration
    BookDto toBookDto(Book book);
    List<BookDto> toBookDtoList(List<Book> bookList);
}
