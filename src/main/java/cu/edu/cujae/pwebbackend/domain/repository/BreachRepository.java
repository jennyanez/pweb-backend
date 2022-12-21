package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.BreachDto;
import cu.edu.cujae.pwebbackend.domain.dto.LoanDto;
import cu.edu.cujae.pwebbackend.persistence.crud.BreachCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Breach;
import cu.edu.cujae.pwebbackend.persistence.mapper.BookMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.BreachMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.ClientMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.CopyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private LoanRepository loanRepository;


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
        //insertBreaches();
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

//    //// update breaches
//    public void insertBreaches(){
//        List<LoanDto> loans = loanRepository.getAll();
//        for (LoanDto loan: loans) {
//            if(loan.getReturnDate().compareTo(Date.valueOf(LocalDate.now())) < 0){
//                System.out.println(loan.getReturnDate().compareTo(Date.valueOf(LocalDate.now())) < 0);
//                BreachDto breachDto = new BreachDto();
//                breachDto.setCopy(loan.getCopy());
//                breachDto.setClient(loan.getClient());
//
//                long diff = Date.valueOf(LocalDate.now()).getTime() - loan.getReturnDate().getTime();
//
//                TimeUnit time = TimeUnit.DAYS;
//                long diffDays = time.convert(diff, TimeUnit.MILLISECONDS);
//
//                System.out.println(diffDays);
//
//                breachDto.setDays((int) diffDays);
//
//                for(BreachDto b: getAll()){
//                    if(!Objects.equals(b.getCopy().getCopyId(), breachDto.getCopy().getCopyId()) && !Objects.equals(b.getClient().getClientId(), breachDto.getClient().getClientId())){
//                        saveBreach(breachDto);
//                    }
//                }
//
//
//            }
//        }

}
