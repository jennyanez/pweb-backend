package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.LoanRequestDto;
import cu.edu.cujae.pwebbackend.domain.repository.ClientRepository;
import cu.edu.cujae.pwebbackend.domain.repository.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class LoanRequestService {

    @Autowired
    private LoanRequestRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    public void saveLoanRequest(LoanRequestDto loanRequestDto) throws SQLException {
        try{
            if(!clientRepository.isSanctioned(loanRequestDto.getClient().getClientId())){
                repository.saveLoan(loanRequestDto);
            }
        }catch (Exception e){
            throw new SQLException(e);
        }
    }

    public Optional<LoanRequestDto> getLoanRequest(Long id){
        return repository.getLoanRequest(id);
    }

    public List<LoanRequestDto> getAll(){
        return repository.getAll();
    }

    public void updateLoanRequest(LoanRequestDto dto) throws SQLException {
        try{
            repository.updateLoanRequest(dto);
        }catch(Exception e){
            throw new SQLException(e);
        }
    }

    public boolean deleteLoan(Long id){
        if(repository.deleteLoanRequest(id)){
            return true;
        }
        return false;
    }

}
