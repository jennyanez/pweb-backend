package cu.edu.cujae.pwebbackend.persistence.mapper;

import cu.edu.cujae.pwebbackend.domain.dto.LoanDto;
import cu.edu.cujae.pwebbackend.persistence.entity.Loan;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, CopyMapper.class})
public interface LoanMapper {
    @Mappings(
            {
                    @Mapping(source="user", target = "client"),
                    @Mapping(source = "user.clientId", target = "clientId"),
                    @Mapping(source="copy", target = "copy"),
                    @Mapping(source = "copy.copyId", target = "copyId"),
                    //@Mapping(source = "returnDate", target = "returnDate"),
                    //@Mapping(source = "loanDate", target = "loanDate")
            }
    )
    Loan toLoan(LoanDto loanDto);

    List<Loan> toLoanList(List<LoanDto> loanDtoList);

    @InheritInverseConfiguration
    LoanDto toLoanDto(Loan loan);

    List<LoanDto> toLoanDtoList(List<Loan> loanList);

}