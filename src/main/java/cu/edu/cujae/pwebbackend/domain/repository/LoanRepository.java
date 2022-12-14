package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.LoanDto;
import cu.edu.cujae.pwebbackend.domain.dto.LoanRequestDto;
import cu.edu.cujae.pwebbackend.persistence.crud.ClientCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.crud.CopyCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.crud.LoanCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Book;
import cu.edu.cujae.pwebbackend.persistence.entity.Loan;
import cu.edu.cujae.pwebbackend.persistence.entity.Loan;
import cu.edu.cujae.pwebbackend.persistence.mapper.ClientMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.CopyMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.LoanMapper;
import cu.edu.cujae.pwebbackend.persistence.utils.LoanPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoanRepository {

    @Autowired
    LoanCrudRepository crud;

    @Autowired
    LoanMapper mapper;


    public LoanDto saveLoan(LoanDto loanDto){
        Loan loan = mapper.toLoan(loanDto);
        return mapper.toLoanDto(crud.save(loan));
    }

    public Optional<LoanDto> getLoan(Long id){
        return crud.findById(id).map(loan -> mapper.toLoanDto(loan));
    }

    public List<LoanDto> getAll(){
        List<Loan> loanList = (List<Loan>) crud.findAll();
        return mapper.toLoanDtoList(loanList);
    }
    public LoanDto updateLoan (LoanDto loanDto, Long id){
        Loan loan= mapper.toLoan(loanDto);
        loan.setLoanId(id);
        Loan loanUpd = crud.save(loan);
        return mapper.toLoanDto(loanUpd);
    }

    public boolean deleteLoan(Long id){
        crud.deleteById(id);
        return true;
    }


}
