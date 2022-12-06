package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.MatterDto;
import cu.edu.cujae.pwebbackend.domain.repository.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatterService {
    @Autowired
    private MatterRepository matterRepository;

    //Get all matters
    public List<MatterDto> getAll(){
        return matterRepository.getAll();
    }

    //get matter by id
    public Optional<MatterDto> getMatter(Long matterId){
        return matterRepository.getMatter(matterId);
    }

    //create matter
    public MatterDto saveMatter(MatterDto matterDto){
        return matterRepository.saveMatter(matterDto);
    }

    //update matter
    public MatterDto updateMatter(MatterDto matterDto){
        return matterRepository.updateMatter(matterDto);
    }

    //delete matter
    public boolean deleteMatter(Long matterId){
        try{
            matterRepository.deleteMatter(matterId);
            return true;
        } catch(EmptyResultDataAccessException e) {
            return false;
        }

    }
}
