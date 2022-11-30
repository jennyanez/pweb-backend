package cu.edu.cujae.pwebbackend.domain.service.repository;

import cu.edu.cujae.pwebbackend.domain.dto.MatterDto;
import cu.edu.cujae.pwebbackend.persistence.crud.MatterCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Matter;
import cu.edu.cujae.pwebbackend.persistence.mapper.MatterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MatterRepository{
    @Autowired
    private MatterCrudRepository matterCrudRepository;

    @Autowired
    private MatterMapper mapper;

    /*** Crud methods ***/
    //Create
    public MatterDto saveMatter(MatterDto matterDto){
        Matter matter = mapper.toMatter(matterDto);
        return mapper.toMatterDto(matterCrudRepository.save(matter));
    }

    //Read
    public Optional<MatterDto> getMatter(Long matterId){
        return matterCrudRepository.findById(matterId).map(matter -> mapper.toMatterDto(matter));
    }

    //Read all
    public List<MatterDto> getAll(){
        List<Matter> matters = (List<Matter>) matterCrudRepository.findAll();
        return mapper.toMatterDtoList(matters);
    }

    //Update
    public MatterDto updateMatter(MatterDto matterDto, Long matterId){
        Matter matter = mapper.toMatter(matterDto);
        matter.setMatterId(matterId);
        Matter matterUpdated = matterCrudRepository.save(matter);
        return mapper.toMatterDto(matterUpdated);
    }

    //Delete
    public void deleteMatter(Long matterId){
        matterCrudRepository.deleteById(matterId);
    }
}
