package cu.edu.cujae.pwebbackend.domain.service;

import cu.edu.cujae.pwebbackend.domain.dto.MatterDto;
import cu.edu.cujae.pwebbackend.domain.repository.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
    public void saveMatter(MatterDto matterDto) throws SQLException {
        try{
            matterRepository.saveMatter(matterDto);
        }catch (Exception e){
            throw new SQLException("Error al crear la materia");
        }
    }

    //update matter
    public void updateMatter(MatterDto matterDto) throws SQLException{
        try{
            matterRepository.updateMatter(matterDto);
        }catch(Exception e){
            throw new SQLException("Error al actualizar la materia");
        }
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
