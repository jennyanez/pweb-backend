package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.LoanDto;
import cu.edu.cujae.pwebbackend.domain.repository.LoanRepository;
import cu.edu.cujae.pwebbackend.persistence.utils.LoanPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public LoanDto saveLoan(LoanDto loanDto){
        return loanRepository.saveLoan(loanDto);
    }
    public Optional<LoanDto> getLoan(Long loanId){
        return loanRepository.getLoan(loanId);
    }

    public List<LoanDto> getAll(){
        return loanRepository.getAll();
    }

    public LoanDto updateLoan(LoanDto loanDto,Long loanId){
        return loanRepository.updateLoan(loanDto,loanId);
    }

    public boolean deleteLoan(Long loanId){
        if(loanRepository.deleteLoan(loanId)){
            return true;
        }
        return false;
    }

}
