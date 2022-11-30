package cu.edu.cujae.pwebbackend.domain.service.repository;

import cu.edu.cujae.pwebbackend.domain.dto.LoanDto;
import cu.edu.cujae.pwebbackend.persistence.crud.LoanCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Loan;
import cu.edu.cujae.pwebbackend.persistence.mapper.LoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoanRepository {

    @Autowired
    LoanCrudRepository loanCrudRepository;

    @Autowired
    LoanMapper loanMapper;

    public LoanDto saveLoan(LoanDto loanDto){
        Loan loan = loanMapper.toLoan(loanDto);
        return loanMapper.toLoanDto(loanCrudRepository.save(loan));
    }

    public Optional<LoanDto> getLoan(Long loanId){
        return loanCrudRepository.findById(loanId).map(loan -> loanMapper.toLoanDto(loan));
    }

    public List<LoanDto> getAll(){
        List<Loan> loanList = (List<Loan>) loanCrudRepository.findAll();
        return loanMapper.toLoanDtoList(loanList);
    }

    public LoanDto updateLoan(LoanDto loanDto,Long loanId){
        Loan loan = loanMapper.toLoan(loanDto);
        loan.setLoanId(loanId);
        Loan loanUpdate = loanCrudRepository.save(loan);
        return loanMapper.toLoanDto(loanUpdate);
    }

    public boolean deleteLoan(Long loanId){
        loanCrudRepository.deleteById(loanId);
        return true;
    }

}
