package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.LoanRequestDto;
import cu.edu.cujae.pwebbackend.domain.repository.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanRequestService {

    @Autowired
    private LoanRequestRepository repository;

    public LoanRequestDto saveLoanRequest(LoanRequestDto loanRequestDto){
        return repository.saveLoan(loanRequestDto);
    }

    public Optional<LoanRequestDto> getLoanRequest(Long id){
        return repository.getLoanRequest(id);
    }

    public List<LoanRequestDto> getAll(){
        return repository.getAll();
    }

    public LoanRequestDto updateLoanRequest(LoanRequestDto dto){
        return repository.updateLoanRequest(dto);
    }

    public boolean deleteLoan(Long id){
        if(repository.deleteLoanRequest(id)){
            return true;
        }
        return false;
    }

}
