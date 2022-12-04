package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.LoanRequestDto;
import cu.edu.cujae.pwebbackend.persistence.entity.LoanRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, CopyMapper.class})
public interface LoanRequestMapper {

    @Mappings(
            {
                    @Mapping(source = "id",target = "id"),
                    @Mapping(source="copy", target = "copy"),
                    @Mapping(source="copy.copyId", target = "copyId"),
                    @Mapping(source="client", target = "client"),
                    @Mapping(source="client.clientId", target = "clientId"),
                    @Mapping(source="book", target = "book"),
                    @Mapping(source="book.bookId", target = "bookId"),
                    @Mapping(source = "loanRequestDate", target = "loanRequestDate")
            }
    )
    LoanRequest toLoanRequest(LoanRequestDto loanRequestDto);

    List<LoanRequest> toLoanRequestList(List<LoanRequestDto> LoanRequestDtoList);

    @InheritInverseConfiguration
    LoanRequestDto toLoanRequestDto(LoanRequest loanRequest);

    List<LoanRequestDto> toLoanRequestDtoList(List<LoanRequest> loanRequestList);

}
