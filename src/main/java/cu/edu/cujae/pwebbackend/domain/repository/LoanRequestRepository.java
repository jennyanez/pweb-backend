package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.LoanRequestDto;
import cu.edu.cujae.pwebbackend.persistence.crud.LoanRequestCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.LoanRequest;
import cu.edu.cujae.pwebbackend.persistence.mapper.LoanRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoanRequestRepository {

    @Autowired
    LoanRequestCrudRepository crud;

    @Autowired
    LoanRequestMapper mapper;

    public LoanRequestDto saveLoan(LoanRequestDto loanRequestDto){
        LoanRequest loanRequest = mapper.toLoanRequest(loanRequestDto);
        return mapper.toLoanRequestDto(crud.save(loanRequest));
    }

    public Optional<LoanRequestDto> getLoanRequest(Long id){
        return crud.findById(id).map(loanRequest -> mapper.toLoanRequestDto(loanRequest));
    }

    public List<LoanRequestDto> getAll(){
        List<LoanRequest> loanRequestList = (List<LoanRequest>) crud.findAll();
        return mapper.toLoanRequestDtoList(loanRequestList);
    }
    public LoanRequestDto updateLoanRequest (LoanRequestDto loanRequestDto, Long id){
        LoanRequest loanRequest = mapper.toLoanRequest(loanRequestDto);
        loanRequest.setId(id);
        LoanRequest loanRequestUpd = crud.save(loanRequest);
        return mapper.toLoanRequestDto(loanRequestUpd);
    }

    public boolean deleteLoanRequest(Long id){
        crud.deleteById(id);
        return true;
    }

}
