package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.LoanDto;
import cu.edu.cujae.pwebbackend.persistence.crud.ClientCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.crud.CopyCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.crud.LoanCrudRepository;
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
    LoanCrudRepository loanCrudRepository;

    @Autowired
    LoanMapper loanMapper;

    @Autowired
    ClientCrudRepository clientCrudRepository;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    CopyCrudRepository copyCrudRepository;

    @Autowired
    CopyMapper copyMapper;

    public LoanDto saveLoan(LoanDto loanDto){
        Loan loan = loanMapper.toLoan(loanDto);
        return loanMapper.toLoanDto(loanCrudRepository.save(loan));
    }

    public Optional<LoanDto> getLoan(Long loanId){
        List<Loan> loanList = (List<Loan>) loanCrudRepository.findAll();
        LoanPK loanPK = new LoanPK();

        for(int i = 0;i < loanList.size();i++){
            if(loanList.get(i).getLoanId()==loanId) {
                 loanPK = new LoanPK(loanId, loanList.get(i).getClientId(), loanList.get(i).getCopyId());
            }
        }
        return loanCrudRepository.findById(loanPK).map(loan -> loanMapper.toLoanDto(loan));
    }

    public List<LoanDto> getAll(){
        List<Loan> loanList = (List<Loan>) loanCrudRepository.findAll();
        return loanMapper.toLoanDtoList(loanList);
    }

    public LoanDto updateLoan(LoanDto loanDto,Long loanId){

        LoanPK loanPK = new LoanPK();
        Loan loanUpdate = new Loan();

        List<Loan> loanList = (List<Loan>) loanCrudRepository.findAll();
        for(int i = 0;i < loanList.size();i++){
            if(loanList.get(i).getLoanId()==loanId) {
                Loan loan = loanMapper.toLoan(loanDto);
                loan.setLoanId(loanId);
                loanUpdate = loanCrudRepository.save(loan);
            }
        }
        return loanMapper.toLoanDto(loanUpdate);
    }

    public boolean deleteLoan(Long loanId){

        List<Loan> loanList = (List<Loan>) loanCrudRepository.findAll();
        LoanPK loanPK = new LoanPK();

        for(int i = 0; i < loanList.size(); i++){
            if(loanList.get(i).getLoanId()==loanId) {
                loanPK.setLoanId(loanId);
                loanPK.setClientId(loanList.get(i).getClientId());
                loanPK.setCopyId(loanList.get(i).getCopyId());
            }
        }
        loanCrudRepository.deleteById(loanPK);
        return true;
    }

}
