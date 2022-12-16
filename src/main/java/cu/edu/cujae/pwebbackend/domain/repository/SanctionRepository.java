package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.SanctionDto;
import cu.edu.cujae.pwebbackend.persistence.crud.SanctionCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Sanction;
import cu.edu.cujae.pwebbackend.persistence.mapper.ClientMapper;
import cu.edu.cujae.pwebbackend.persistence.mapper.SanctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class SanctionRepository {
    @Autowired
    private SanctionCrudRepository sanctionCrudRepository;

    @Autowired
    private SanctionMapper mapper;

    @Autowired
    private ClientMapper clientMapper;


    //** CRUD **//
    //Read
    public Optional<SanctionDto> getSanction(Long sanctionId){
        return sanctionCrudRepository.findById(sanctionId).map(sanction -> mapper.toSanctionDto(sanction));
    }

    //Read all
    public List<SanctionDto> getAll(){
        List<Sanction> sanctions = (List<Sanction>) sanctionCrudRepository.findAll();
        return mapper.toSanctionDtoList(sanctions);
    }

    //Create
    public SanctionDto saveSanction(SanctionDto sanctionDto){
        Sanction sanction = mapper.toSanction(sanctionDto);
        sanction.setClient(clientMapper.toClient(sanctionDto.getClient()));
        return mapper.toSanctionDto(sanctionCrudRepository.save(sanction));
    }

    //Delete
    public void deleteSanction(Long sanctionId){
        sanctionCrudRepository.deleteById(sanctionId);
    }

    //get sanction by id
    public Optional<SanctionDto> getSanctionById(Long id) {
        return sanctionCrudRepository.findById(id).map(sanction -> mapper.toSanctionDto(sanction));
    }
}
