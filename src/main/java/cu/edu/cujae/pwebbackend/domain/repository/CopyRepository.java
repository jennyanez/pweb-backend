package cu.edu.cujae.pwebbackend.domain.repository;

import cu.edu.cujae.pwebbackend.domain.dto.CopyDto;
import cu.edu.cujae.pwebbackend.persistence.crud.CopyCrudRepository;
import cu.edu.cujae.pwebbackend.persistence.entity.Copy;
import cu.edu.cujae.pwebbackend.persistence.mapper.CopyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CopyRepository {
    @Autowired
    private CopyCrudRepository copyCrudRepository;

    @Autowired
    private CopyMapper mapper;

    /**** CRUD methods ****/
    //create
    public CopyDto saveCopy(CopyDto copyDto){
        Copy copy = mapper.toCopy(copyDto);
        return mapper.toCopyDto(copyCrudRepository.save(copy));
    }

    //read
    public Optional<CopyDto> getCopy(Long copyId){
        return copyCrudRepository.findById(copyId).map(copy -> mapper.toCopyDto(copy));
    }

    //read all
    public List<CopyDto> getAll(){
        List<Copy> copies = (List<Copy>) copyCrudRepository.findAll();
        return mapper.toCopyDtoList(copies);
    }

    //update
    public CopyDto updateCopy(CopyDto copyDto, Long copyId){
        Copy copy = mapper.toCopy(copyDto);
        copy.setCopyId(copyId);
        Copy copyUpd = copyCrudRepository.save(copy);
        return mapper.toCopyDto(copyUpd);
    }

    //delete
    public void deleteCopy(Long copyId){
        copyCrudRepository.deleteById(copyId);
    }
}
