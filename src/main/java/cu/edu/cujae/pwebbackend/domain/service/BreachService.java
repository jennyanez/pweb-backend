package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.BreachDto;
import cu.edu.cujae.pwebbackend.domain.repository.BreachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreachService {
    @Autowired
    private BreachRepository breachRepository;

    //Get all breaches
    public List<BreachDto> getAll(){
        return breachRepository.getAll();
    }

    //get breach by id
    public Optional<BreachDto> getBreach(Long breachId){
        return breachRepository.getBreach(breachId);
    }

    //create breach
    public BreachDto saveBreach(BreachDto breachDto){
        return breachRepository.saveBreach(breachDto);
    }

    //update breach
    public BreachDto updateBreach(BreachDto breachDto){
        return breachRepository.updateBreach(breachDto);
    }

    //delete breach
    public boolean deleteBreach(Long breachId){
        try {
            breachRepository.deleteBreach(breachId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
