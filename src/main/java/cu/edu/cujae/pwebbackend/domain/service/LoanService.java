package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.LoanDto;
import cu.edu.cujae.pwebbackend.domain.repository.ClientRepository;
import cu.edu.cujae.pwebbackend.domain.repository.LoanRepository;
import cu.edu.cujae.pwebbackend.persistence.utils.LoanPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ClientRepository clientRepository;

    public void saveLoan(LoanDto loanDto) throws SQLException {
        try{
            if(!clientRepository.isSanctioned(loanDto.getClient().getClientId())){
                loanRepository.saveLoan(loanDto);
            }
        }catch (Exception e){
            throw new SQLException("Error al guardar el prestamo");
        }

    }
    public Optional<LoanDto> getLoan(Long loanId){
        return loanRepository.getLoan(loanId);
    }

    public List<LoanDto> getAll(){
        return loanRepository.getAll();
    }

    public void updateLoan(LoanDto loanDto) throws SQLException {
        try {
            if (!clientRepository.isSanctioned(loanDto.getClient().getClientId())) {
                loanRepository.updateLoan(loanDto);
            }
        }
            catch(Exception e){
                throw new SQLException("Error al actualizar el prestamo");
            }

    }

    public List<LoanDto> getLoanByClientId(Long clientId){
        return loanRepository.getLoanByClientId(clientId);
    }

    public boolean deleteLoan(Long loanId){
        if(loanRepository.deleteLoan(loanId)){
            return true;
        }
        return false;
    }

}
