package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.BreachDto;
import cu.edu.cujae.pwebbackend.persistence.crud.BreachCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Breach;
import cu.edu.cujae.pwebbackend.persistence.mapper.BookMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.BreachMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.ClientMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.CopyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BreachRepository {
    @Autowired
    private BreachCrudRepository breachCrudRepository;

    @Autowired
    private BreachMapper mapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CopyMapper copyMapper;

    @Autowired
    private ClientMapper clientMapper;


    /***** CRUD methods ****/
    //create
    public BreachDto saveBreach(BreachDto breachDto){
       Breach breach = mapper.toBreach(breachDto);
       breach.setCopy(copyMapper.toCopy(breachDto.getCopy()));
       breach.setClient(clientMapper.toClient(breachDto.getClient()));
       return mapper.toBreachDto(breachCrudRepository.save(breach));
    }

    //read
    public Optional<BreachDto> getBreach(Long breachId){
        return breachCrudRepository.findById(breachId).map(breach -> mapper.toBreachDto(breach));
    }

    //read all
    public List<BreachDto> getAll(){
        List<Breach> breaches = (List<Breach>) breachCrudRepository.findAll();
        return mapper.toBreachDtoList(breaches);
    }

    //update
    public BreachDto updateBreach(BreachDto breachDto){
        Breach breach = mapper.toBreach(breachDto);
        breach.setBreachId(breachDto.getBreachId());
        Breach breachUpd = breachCrudRepository.save(breach);
        return mapper.toBreachDto(breachUpd);
    }

    //delete
    public void deleteBreach(Long breachId){
        breachCrudRepository.deleteById(breachId);
    }


}
